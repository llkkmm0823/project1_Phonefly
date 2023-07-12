package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.util.Paging;
@Mapper
public interface ICommonDao {

	List<NoticeVO> getNoticeList(Paging paging, String key);
	NoticeVO getNotice(int nseq);
	int getAllCount(String string, String string2, String key);
	List<EventVO> getEventList(Paging paging, String key);
	EventVO getEvent(int eseq);
	int getAllCountById(String string, String string2, String key, String id);
	
}
