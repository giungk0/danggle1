package kr.co.todaydaeng.admin.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todaydaeng.admin.model.dao.AdminDAO;
import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Notice;

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	private AdminDAO aDAO;

	@Override
	public String selectAdminIDCheck(String chkID) {
		return aDAO.selectAdminIDCheck(chkID);
		
	}

	@Override
	public int insertAdminAccount(AdminVO avo) {
		return aDAO.insertAdminAccount(avo);
	}

	@Override
	public int updateAdminGrade(HashMap<String, Object> map) {
		return aDAO.updateAdminGrade(map);
	}

	@Override
	public int updateMemberStatus(HashMap<String, Object> map) {
		return aDAO.updateMemberStatus(map);
	}

	@Override
	public int insertAdminNotice(HashMap<String, String> map) {
		return aDAO.insertAdminNotice(map);
	}

	@Override
	public Notice selectNoticeRead(int noticeNo) {
		return aDAO.selectNoticeRead(noticeNo);
	}

	@Override
	public int updateNoticeEdit(HashMap<String, Object> map) {
		return aDAO.updateNoticeEdit(map);
	}

	@Override
	public int updateNoticeDelete(int noticeNo) {
		return aDAO.updateNoticeDelete(noticeNo);
	}

	@Override
	public int updateNoticeChange(HashMap<String, Object> map) {
		return aDAO.updateNoticeChange(map);
	}

	@Override
	public int updateBoardChange(HashMap<String, Object> map) {
		return aDAO.updateBoardChange(map);
	}
	
}
