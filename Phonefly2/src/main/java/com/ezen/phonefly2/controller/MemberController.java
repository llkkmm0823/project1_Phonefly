package com.ezen.phonefly2.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.KakaoProfile;
import com.ezen.phonefly2.dto.KakaoProfile.KakaoAccount;
import com.ezen.phonefly2.dto.KakaoProfile.KakaoAccount.Profile;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.OAuthToken;
import com.ezen.phonefly2.service.MemberService;
import com.google.gson.Gson;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = ms.getMember(id);
		String url = "member/loginForm";
		if (mvo == null) {
			mav.addObject("message", "없는 아이디입니다");
		}
		else if (mvo.getUseyn().equals("N")) {
			mav.addObject("message", "회원가입후 탈퇴이력이 있습니다. 관리자에 문의하세요");
		}
		else if (mvo.getPwd() == null) {
			mav.addObject("message", "데이터 오류. 관리자에 문의하세요");
		}
		else if (!mvo.getPwd().equals(pwd)) {
			mav.addObject("message", "비밀번호가 틀렸습니다");
		}
		else if (mvo.getPwd().equals(pwd)) {
			session.setAttribute("loginUser", mvo);
			url = "redirect:/";
		} else {
			mav.addObject("message", "로그인 실패. 관리자에게 문의하세요");
		}
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}

	@RequestMapping("/kakaostart")
	public @ResponseBody String kakaostart() {
		return "<script type='text/javascript'>location.href='https://kauth.kakao.com/oauth/authorize?client_id=70bb359a47df3cde5cca26a20b65a399&redirect_uri=http://localhost/kakaoLogin&response_type=code'</script>";
	}

	@RequestMapping("/kakaoLogin")
	public String kakaoLogin(HttpServletRequest request) throws UnsupportedEncodingException, IOException {
		// ToDo : something do authentication
		String apiKey = "70bb359a47df3cde5cca26a20b65a399";
		// 카카오 아이디, 비번 인증 + 아이디 이메일 제공 동의 후 전송되는 암호화 코드
		String code = request.getParameter("code");
		String endPoint = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(endPoint); // import java.net.URL;
		
		// 파라미터 설정
		String bodyData = "grant_type=authorization_code&client_id=" + apiKey + "&redirect_uri=http://localhost/kakaoLogin&code=" + code;

		// Stream connection
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // import import java.net.HttpURLConnection;
		// http header 값 넣기
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);

		// Kakao API user information request (토큰 수신)
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.write(bodyData);
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder(); // 조각난 String을 조립하기 위한 객체
		while ((input = br.readLine()) != null) {
			sb.append(input);
			System.out.println(input);
		}

		// 여기서 부터 Gson(Google JSON)으로 parsing
		Gson gson = new Gson();
		OAuthToken oAuthToken = gson.fromJson(sb.toString(), OAuthToken.class);
		// 토큰을 이용해서 사용자 정보를 요청 수신
		String endPoint2 = "https://kapi.kakao.com/v2/user/me";
		URL url2 = new URL(endPoint2);
		HttpsURLConnection conn2 = (HttpsURLConnection)url2.openConnection();
		conn2.setRequestProperty("Authorization", "Bearer " + oAuthToken.getAccess_token());
		conn2.setDoOutput(true);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream(), "UTF-8"));
		String input2 = "";
		StringBuilder sb2 = new StringBuilder();
		while ((input2 = br2.readLine()) != null) {
			sb2.append(input2);
			System.out.println(input2);
		}

		// 전달받은 회원정보를 kakaoProfile 객체에 담습니다. (sb2 -> kakaoProfile)
		Gson gson2 = new Gson();
		KakaoProfile kakaoProfile = gson2.fromJson(sb2.toString(), KakaoProfile.class);

		System.out.println(kakaoProfile.getId());

		KakaoAccount ac = kakaoProfile.getAccount();
		System.out.println(ac.getEmail());

		Profile pf = ac.getProfile();
		System.out.println(pf.getNickname());

		// kakao 로 부터 얻은 정보로 member 테이블에서 조회 합니다.
		MemberVO mvo = ms.getMember(kakaoProfile.getId());
		if (mvo == null) {
			mvo = new MemberVO();
			mvo.setId(kakaoProfile.getId());
			mvo.setEmail(ac.getEmail());
			mvo.setName(pf.getNickname());
			mvo.setProvider("kakao");
			//mvo.setPwd("kakao");
			//mvo.setPhone("");

			ms.joinKakao(mvo);
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", mvo);

		return "redirect:/";
	}

	@RequestMapping("/contract")
	public String contract() {
		return "member/contract";
	}

	@RequestMapping("/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}

	@PostMapping("/join")
	public String join(MemberVO mvo) {
		ms.join(mvo);
		return "redirect:/loginForm";
	}

	@RequestMapping("/idCheck")
	public ModelAndView idCheck(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		MemberVO mvo = ms.getMember(id);
		int result = 1;
		if (mvo == null) {
			mav.addObject("result", -1);
		} else {
			mav.addObject("result", 1);
		}
		mav.addObject("id", id);
		mav.setViewName("member/idCheck");
		return mav;
	}

	@RequestMapping("/memberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			url = "member/updateForm";
		}
		return url;
	}


	@PostMapping("/memberUpdate")
	public String memberUpdate(MemberVO mvo, HttpServletRequest request) {
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo2 = (MemberVO)session.getAttribute("loginUser");
		if (mvo2 != null) {
			ms.memberUpdate(mvo);
			url = "redirect:/";
		}
		session.setAttribute("loginUser", mvo);
		return url;
	}

	@RequestMapping("/deleteMember")
	public String deleteMember(HttpServletRequest request) {
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			ms.deleteMember(mvo.getId());
			url = "redirect:/";
		}
		session.removeAttribute("loginUser");
		return url;
	}

	@RequestMapping("/selectId")
	public ModelAndView selectId(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "phone", required = false) String phone) {
		ModelAndView mav = new ModelAndView();
		String url = "member/findId";
		if (name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
			MemberVO mvo = ms.findId(name, phone);
			mav.addObject("member", mvo);
		}
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/selectPwd")
	public ModelAndView selectPwd(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "phone", required = false) String phone) {
		ModelAndView mav = new ModelAndView();
		String url = "member/findPwd";
		int result = 0;
		if (id != null && !id.isEmpty() && name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
			result = ms.findMember(id, name, phone);
		}
		mav.addObject("result", result);
		mav.addObject("id", id);
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping("/setPwd")
	public ModelAndView selectPwd(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "pwd", required = false) String pwd) {
		ModelAndView mav = new ModelAndView();
		String url = "member/findPwd";
		if (id != null && !id.isEmpty() && pwd != null && !pwd.isEmpty()) {
			ms.setNewPwd(id, pwd);
		}
		mav.addObject("result", 3);
		mav.setViewName(url);
		return mav;
	}
}

