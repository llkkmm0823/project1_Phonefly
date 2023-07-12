package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IQnaDao {

	List<QnaVO> qnaList(Paging paging, String key, MemberVO mvo);
	QnaVO getQna(int qseq);
	void qnaWrite(QnaVO qnavo);
	void qnaUpdate(QnaVO qnavo);
	void qnaDelete(int qseq);
	

}
