package kr.co.todaydaeng.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.board.model.vo.Notice;
import kr.co.todaydaeng.member.model.vo.Member;

public interface AdminService {

	AdminVO selectAdminLogin(HashMap<String, String> map);

	String selectAdminEmailCheck(String chkMail);

	int updateAdminAccount(AdminVO avo);

	int updateAdminPWD(HashMap<String, String> mapPwd);

	AdminVO selectAdminAccount(String adminID);

	ArrayList<AdminVO> selectAdminList();

	int selectAdminNew();

	ArrayList<AdminVO> selectAdminSearch(HashMap<String, String> findMap);

	ArrayList<Member> selectMemberList(HashMap<String, Integer> pageNum);
	
	int selectMemberCount();

	int selectMemberDormant();

	ArrayList<Member> selectMemberSearch(HashMap<String, String> findMap);

	ArrayList<Notice> selectNoticeList(HashMap<String, Integer> pageNum);
	

	int selectNoticeCount();

	ArrayList<Notice> selectNoticeSearch(HashMap<String, String> findMap);

	ArrayList<Board> selectBoardList(HashMap<String, Integer> pageNum);

	int selectBoardCount();
	

	ArrayList<Board> selectBoardSearch(HashMap<String, String> findMap);

	String pageNavi(int currentPage, int recordCountPerPage, int naviCountPerPage, String tag);

}
