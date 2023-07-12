package pf.dto;

import java.sql.Timestamp;

public class OrderDetailVO {
	
	private int odseq;			// 주문상세 번호 [PK]
	private int pseq;			// 상품 번호 [product FK]
	private int rseq;			// 요금제 번호 [rplan FK]
	private String id;			// 회원 아이디 [member FK]
	private String result;		// 처리결과 {1: '접수중(default)', 2: '발송중', 3: '완료' }
	private int discount;		// 할인방법 {1: '공시지원할인', 2: '선택약정할인'}
	private int buyplan;		// 구매방법 {1, 24, 30, 36}
	private int dcmonth;		// 할부금 (금액: front-end에서 계산됨)
	private int dctotal;		// 할부원금 (금액: front-end에서 계산됨)
	private int mmonth;			// 통신요금 (금액: front-end에서 계산됨)
	private int mtotal;			// 월 총 납부금액 (금액: front-end에서 계산됨)
	private String cc;			// 가입 종류 {0: 통신사이동, 1: 기기변경}
	private Timestamp indate;	// 신청일 [SYSDATE(default)]
	private int cseq;			// 컬러 시퀀스 번호 [color: cseq]


	// join으로 다른 테이블에서 가져오는 parameter
	private String pname;		// 제품명 [product: name]
	private String cname;		// 통신사명 [comm : name]
	private String ccname;		// 컬러명 [color: name]
	private String rname;		// 요금제명 [rplan: name]
	private String mname;		// 회원명 [member: mame]
	private String image;		// 제품 이미지 파일명 [color: image]

	private int price;			// 제품 가격 [product: price2]
	private String mfc;			// 제조사 명 [product: mfc]
	private int charge;			// 요금 [rplan: charge]
	private String dataplan;	// 데이터제공량 [rplan: dataplan]
	private String timeplan;	// 통화제공량 [rplan: timeplan]
	private String textplan;	// 문자제공량 [rplan: textplan]
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getMfc() {
		return mfc;
	}
	public void setMfc(String mfc) {
		this.mfc = mfc;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public String getDataplan() {
		return dataplan;
	}
	public void setDataplan(String dataplan) {
		this.dataplan = dataplan;
	}
	public String getTimeplan() {
		return timeplan;
	}
	public void setTimeplan(String timeplan) {
		this.timeplan = timeplan;
	}
	public String getTextplan() {
		return textplan;
	}
	public void setTextplan(String textplan) {
		this.textplan = textplan;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public int getMtotal() {
		return mtotal;
	}
	public void setMtotal(int mtotal) {
		this.mtotal = mtotal;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getBuyplan() {
		return buyplan;
	}
	public void setBuyplan(int buyplan) {
		this.buyplan = buyplan;
	}
	public int getDcmonth() {
		return dcmonth;
	}
	public void setDcmonth(int dcmonth) {
		this.dcmonth = dcmonth;
	}
	public int getDctotal() {
		return dctotal;
	}
	public void setDctotal(int dctotal) {
		this.dctotal = dctotal;
	}
	public int getMmonth() {
		return mmonth;
	}
	public void setMmonth(int mmonth) {
		this.mmonth = mmonth;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public int getOdseq() {
		return odseq;
	}
	public void setOdseq(int odseq) {
		this.odseq = odseq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
