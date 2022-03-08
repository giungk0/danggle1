package kr.co.todaydaeng.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Notice;

public interface ManageService {

	String selectAdminIDCheck(String chkID);

	int insertAdminAccount(AdminVO avo);

	int updateAdminGrade(HashMap<String, Object> map);
	
	int updateMemberStatus(HashMap<String, Object> map);

	int insertAdminNotice(HashMap<String, String> map);

	Notice selectNoticeRead(int noticeNo);

	int updateNoticeEdit(HashMap<String, Object> map);

	int updateNoticeDelete(int noticeNo);

	int updateNoticeChange(HashMap<String, Object> map);

	int updateBoardChange(HashMap<String, Object> map);

}
