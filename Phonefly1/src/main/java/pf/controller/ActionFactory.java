package pf.controller;

import pf.controller.action.Action;
import pf.controller.action.IndexAction;
import pf.controller.action.admin.board.event.AdminEventDeleteAction;
import pf.controller.action.admin.board.event.AdminEventDetailAction;
import pf.controller.action.admin.board.event.AdminEventInsertAction;
import pf.controller.action.admin.board.event.AdminEventInsertFormAction;
import pf.controller.action.admin.board.event.AdminEventListAction;
import pf.controller.action.admin.board.event.AdminEventUpdateAction;
import pf.controller.action.admin.board.event.AdminEventUpdateFormAction;
import pf.controller.action.admin.board.notice.AdminNoticeDeleteAction;
import pf.controller.action.admin.board.notice.AdminNoticeDetailAction;
import pf.controller.action.admin.board.notice.AdminNoticeInsertAction;
import pf.controller.action.admin.board.notice.AdminNoticeInsertFormAction;
import pf.controller.action.admin.board.notice.AdminNoticeListAction;
import pf.controller.action.admin.board.notice.AdminNoticeUpdateAction;
import pf.controller.action.admin.board.notice.AdminNoticeUpdateFormAction;
import pf.controller.action.admin.board.qna.AdminQnaListAction;
import pf.controller.action.admin.board.qna.AdminQnaUpdateAction;
import pf.controller.action.admin.board.qna.AdminQna_detailAction;
import pf.controller.action.admin.board.qna.Guide1Action;
import pf.controller.action.admin.board.qna.Guide2Action;
import pf.controller.action.admin.board.qna.Guide3Action;
import pf.controller.action.admin.login.AdminAction;
import pf.controller.action.admin.login.AdminLoginAction;
import pf.controller.action.admin.login.AdminLogoutAction;
import pf.controller.action.admin.member.AdminMemberDetailAction;
import pf.controller.action.admin.member.AdminMemberListAction;
import pf.controller.action.admin.order.AdminOrderListAction;
import pf.controller.action.admin.order.AdminOrderUpdateAction;
import pf.controller.action.admin.order.AdminOrderDetailAction;
import pf.controller.action.admin.order.OrderCancelAction;
import pf.controller.action.admin.product.AdminColorDeleteAction;
import pf.controller.action.admin.product.AdminColorDetailAction;
import pf.controller.action.admin.product.AdminColorInsertAction;
import pf.controller.action.admin.product.AdminColorInsertFormAction;
import pf.controller.action.admin.product.AdminColorListAction;
import pf.controller.action.admin.product.AdminColorUpdateAction;
import pf.controller.action.admin.product.AdminColorUpdateFormAction;
import pf.controller.action.admin.product.AdminProductDeleteAction;
import pf.controller.action.admin.product.AdminProductDetailAction;
import pf.controller.action.admin.product.AdminProductInsertAction;
import pf.controller.action.admin.product.AdminProductInsertFormAction;
import pf.controller.action.admin.product.AdminProductListAction;
import pf.controller.action.admin.product.AdminProductUpdateAction;
import pf.controller.action.admin.product.AdminProductUpdateFormAction;
import pf.controller.action.board.event.EventDetailAction;
import pf.controller.action.board.event.EventListAction;
import pf.controller.action.board.faq.FAQListAction;
import pf.controller.action.board.notice.NoticeDetailAction;
import pf.controller.action.board.notice.NoticeListAction;
import pf.controller.action.board.review.ReviewWriteAction;
import pf.controller.action.member.DeleteMemberAction;
import pf.controller.action.member.MemberUpdateAction;
import pf.controller.action.member.MemberUpdateFormAction;
import pf.controller.action.member.join.ContractAction;
import pf.controller.action.member.join.FindZipnumAction;
import pf.controller.action.member.join.IdCheckAction;
import pf.controller.action.member.join.JoinAction;
import pf.controller.action.member.join.JoinFormAction;
import pf.controller.action.member.login.LoginAction;
import pf.controller.action.member.login.LoginFormAction;
import pf.controller.action.member.login.LogoutAction;
import pf.controller.action.member.login.SelectIdAction;
import pf.controller.action.member.login.SelectPwdAction;
import pf.controller.action.member.login.SetPwdAction;
import pf.controller.action.member.mypage.MemberReviewDeleteAction;
import pf.controller.action.member.mypage.MemberReviewListAction;
import pf.controller.action.member.mypage.MemberReviewUpdateAction;
import pf.controller.action.member.mypage.QnaDeleteAction;
import pf.controller.action.member.mypage.QnaDetailAction;
import pf.controller.action.member.mypage.QnaListAction;
import pf.controller.action.member.mypage.QnaUpdateAction;
import pf.controller.action.member.mypage.QnaUpdateformAction;
import pf.controller.action.member.mypage.QnaWriteAction;
import pf.controller.action.member.mypage.QnaWriteFormAction;
import pf.controller.action.order.OrderAction;
import pf.controller.action.order.OrderDetailAction;
import pf.controller.action.order.OrderListAction;
import pf.controller.action.product.ProductCompareAction;
import pf.controller.action.product.ProductDetailAction;
import pf.controller.action.product.ProductListAction;
import pf.controller.action.product.ProductReviewListAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
	Action ac = null;
	
	//메인(main)
	if( command.equals("index") ) ac = new IndexAction();
	
	//회원(member)
	else if(command.equals("memberUpdateForm") ) ac = new MemberUpdateFormAction();
	else if(command.equals("memberUpdate") ) ac = new MemberUpdateAction();
	else if(command.equals("deleteMember") ) ac = new DeleteMemberAction();
	//회원(member).login
	else if(command.equals("loginForm") ) ac = new LoginFormAction();
	else if(command.equals("login") ) ac = new LoginAction();
	else if(command.equals("logout") ) ac = new LogoutAction();
	else if(command.equals("selectId") ) ac = new SelectIdAction();
	else if(command.equals("selectPwd") ) ac = new SelectPwdAction();
	else if(command.equals("setPwd") ) ac = new SetPwdAction();

	
	//회원(member).join
	else if(command.equals("contract") ) ac = new ContractAction();
	else if(command.equals("joinForm") ) ac = new JoinFormAction();
	else if(command.equals("join") ) ac = new JoinAction();
	else if(command.equals("idCheck") ) ac = new IdCheckAction();
	else if(command.equals("findZipnum") ) ac = new FindZipnumAction();
	//회원(member).mypage
	else if(command.equals("memberReviewList") ) ac = new MemberReviewListAction();
	else if(command.equals("memberReviewUpdate") ) ac = new MemberReviewUpdateAction();
	else if(command.equals("memberReviewDelete") ) ac = new MemberReviewDeleteAction();
	else if(command.equals("qnaWriteForm") ) ac = new QnaWriteFormAction();
	else if(command.equals("qnaWrite") ) ac = new QnaWriteAction();
	else if(command.equals("qnaUpdateform") ) ac = new QnaUpdateformAction();
	else if(command.equals("qnaUpdate") ) ac = new QnaUpdateAction();
	else if(command.equals("qnaDelete") ) ac = new QnaDeleteAction();
	else if(command.equals("qnaList") ) ac = new QnaListAction();
	else if(command.equals("qnaDetail") ) ac = new QnaDetailAction();
	
	//주문(order)
	else if(command.equals("orderList") ) ac = new OrderListAction();
	else if(command.equals("order") ) ac = new OrderAction();
	else if(command.equals("orderDetail") ) ac = new OrderDetailAction();
	else if(command.equals("orderCancel") ) ac = new OrderCancelAction();
	//else if(command.equals("orderDetailListForm") ) ac = new AdminOrder_detailAction();
	//else if(command.equals("orderDetailList") ) ac = new AdminOrderListAction();
	

	//상품(product)
	//else if(command.equals("category") ) ac = new CategoryAction();
	else if(command.equals("productDetail") ) ac = new ProductDetailAction();
	else if(command.equals("productList") ) ac = new ProductListAction();
	else if(command.equals("productCompare") ) ac = new ProductCompareAction();
	else if(command.equals("productListReview") ) ac = new ProductReviewListAction();	

	//게시판(board)
	
	//게시판(board).Faq
	else if(command.equals("FAQList") ) ac = new FAQListAction();
	//게시판(board).Review
	else if(command.equals("reviewWrite") ) ac = new ReviewWriteAction();
	//게시판(board).Event
	else if(command.equals("eventList") ) ac = new EventListAction();
	else if(command.equals("eventDetail") ) ac = new EventDetailAction();
	//게시판(board).Notice
	else if(command.equals("noticeList") ) ac = new NoticeListAction();
	else if(command.equals("noticeDetail") ) ac = new NoticeDetailAction();
	
	//하단링크
	else if(command.equals("guide1") ) ac = new Guide1Action();
	else if(command.equals("guide2") ) ac = new Guide2Action();
	else if(command.equals("guide3") ) ac = new Guide3Action();
	
	
	//관리자(admin)

	//관리자(admin).login
	else if(command.equals("admin") ) ac = new AdminAction();
	else if(command.equals("adminLogin") ) ac = new AdminLoginAction();
	else if(command.equals("adminLogout") ) ac = new AdminLogoutAction();

	//관리자(admin).member
	else if(command.equals("adminMemberList") ) ac = new AdminMemberListAction();
	else if(command.equals("adminMemberDetail") ) ac = new AdminMemberDetailAction();
	//관리자(admin).product
	else if(command.equals("adminProductList") ) ac = new AdminProductListAction();
	else if(command.equals("adminProductDetail") ) ac = new AdminProductDetailAction();
	else if(command.equals("adminProductInsertForm") ) ac = new AdminProductInsertFormAction();
	else if(command.equals("adminProductInsert") ) ac = new AdminProductInsertAction();
	else if(command.equals("adminProductDelete") ) ac = new AdminProductDeleteAction();
	else if(command.equals("adminProductUpdateForm") ) ac = new AdminProductUpdateFormAction();
	else if(command.equals("adminProductUpdate") ) ac = new AdminProductUpdateAction();
	//product color
	else if(command.equals("adminColorList") ) ac = new AdminColorListAction();
	else if(command.equals("adminColorDetail") ) ac = new AdminColorDetailAction();
	else if(command.equals("adminColorInsertForm") ) ac = new AdminColorInsertFormAction();
	else if(command.equals("adminColorInsert") ) ac = new AdminColorInsertAction();
	else if(command.equals("adminColorUpdateForm") ) ac = new AdminColorUpdateFormAction();
	else if(command.equals("adminColorUpdate") ) ac = new AdminColorUpdateAction();
	else if(command.equals("adminColorDelete") ) ac = new AdminColorDeleteAction();

	
	
	//관리자(admin).order
	else if(command.equals("adminOrderList") ) ac = new AdminOrderListAction();
	else if(command.equals("adminOrderDetail") ) ac = new AdminOrderDetailAction();
	else if(command.equals("adminOrderUpdate") ) ac = new AdminOrderUpdateAction();


	//관리자(admin).board
	
	//관리자(admin).board.QnA
	//else if(command.equals("adminQnaListForm") ) ac = new AdminQnaListFormAction();
	else if(command.equals("adminQnaUpdate") ) ac = new AdminQnaUpdateAction();
	else if(command.equals("adminQnaList") ) ac = new AdminQnaListAction();
	else if(command.equals("adminQnaDetail") ) ac = new AdminQna_detailAction();
	//관리자(admin).board.Notice
	else if(command.equals("adminNoticeList") ) ac = new AdminNoticeListAction();
	else if(command.equals("adminNoticeDetail") ) ac = new AdminNoticeDetailAction();
	else if(command.equals("adminNoticeInsertForm") ) ac = new AdminNoticeInsertFormAction();
	else if(command.equals("adminNoticeInsert") ) ac = new AdminNoticeInsertAction();
	else if(command.equals("adminNoticeUpdateForm") ) ac = new AdminNoticeUpdateFormAction();
	else if(command.equals("adminNoticeUpdate") ) ac = new AdminNoticeUpdateAction();
	else if(command.equals("adminNoticeDelete") ) ac = new AdminNoticeDeleteAction();
	//관리자(admin).board.Event
	else if(command.equals("adminEventList") ) ac = new AdminEventListAction();
	else if(command.equals("adminEventDetail") ) ac = new AdminEventDetailAction();
	// 수정 bhs : adminNoticeUpdateForm 누락
	else if(command.equals("adminEventUpdateForm") ) ac = new AdminEventUpdateFormAction();
	else if(command.equals("adminEventUpdate") ) ac = new AdminEventUpdateAction();
	else if(command.equals("adminEventDelete") ) ac = new AdminEventDeleteAction();
	else if(command.equals("adminEventInsertForm") ) ac = new AdminEventInsertFormAction();
	else if(command.equals("adminEventInsert") ) ac = new AdminEventInsertAction();
	
	return ac;
	}


}