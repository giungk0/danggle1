package kr.co.todaydaeng.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todaydaeng.admin.model.dao.AdminDAO;
import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.board.model.vo.Notice;
import kr.co.todaydaeng.member.model.vo.Member;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO aDAO;

	@Override
	public AdminVO selectAdminLogin(HashMap<String, String> map) {		
		return aDAO.selectAdminLogin(map);
	}

	@Override
	public String selectAdminEmailCheck(String chkMail) {
		return aDAO.selectAdminEmailCheck(chkMail);
	}

	@Override
	public int updateAdminAccount(AdminVO avo) {
		return aDAO.updateAdminAccount(avo);
	}

	@Override
	public int updateAdminPWD(HashMap<String, String> mapPwd) {
		return aDAO.updateAdminPWD(mapPwd);
	}

	@Override
	public AdminVO selectAdminAccount(String adminID) {
		return aDAO.selectAdminAccount(adminID);
	}

	@Override
	public ArrayList<AdminVO> selectAdminList() {
		return aDAO.selectAdminList();
	}

	@Override
	public int selectAdminNew() {
		return aDAO.selectAdminNew();
	}

	@Override
	public ArrayList<AdminVO> selectAdminSearch(HashMap<String, String> findMap) {
		return aDAO.selectAdminSearch(findMap);
	}

	@Override
	public ArrayList<Member> selectMemberList(HashMap<String, Integer> pageNum) {
		return aDAO.selectMemberList(pageNum);
	}
	


	@Override
	public int selectMemberCount() {
		return aDAO.selectMemberCount();
	}

	@Override
	public int selectMemberDormant() {
		return aDAO.selectMemberDormant();
	}

	@Override
	public ArrayList<Member> selectMemberSearch(HashMap<String, String> findMap) {
		return aDAO.selectMemberSearch(findMap);
	}

	@Override
	public ArrayList<Notice> selectNoticeList(HashMap<String, Integer> pageNum) {
		return aDAO.selectNoticeList(pageNum);
	}


	@Override
	public int selectNoticeCount() {
		return aDAO.selectNoticeCount();
	}

	@Override
	public ArrayList<Notice> selectNoticeSearch(HashMap<String, String> findMap) {
		return aDAO.selectNoticeSearch(findMap);
	}

	@Override
	public ArrayList<Board> selectBoardList(HashMap<String, Integer> pageNum) {
		return aDAO.selectBoardList(pageNum);
	}

	@Override
	public int selectBoardCount() {
		return aDAO.selectBoardCount();
	}


	@Override
	public ArrayList<Board> selectBoardSearch(HashMap<String, String> findMap) {
		return aDAO.selectBoardSearch(findMap);
	}


	@Override
	public String pageNavi(int currentPage, int recordCountPerPage, int naviCountPerPage, String tag) {
		return aDAO.pageNavi(currentPage, recordCountPerPage, naviCountPerPage, tag);
	}

}
