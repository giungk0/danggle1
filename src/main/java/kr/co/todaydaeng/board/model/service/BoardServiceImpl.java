package kr.co.todaydaeng.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.todaydaeng.board.model.dao.BoardDAO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.board.model.vo.BoardEx;
import kr.co.todaydaeng.board.model.vo.Comment;
import kr.co.todaydaeng.board.model.vo.Notice;
import kr.co.todaydaeng.myPage.model.vo.Dog;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDAO bDAO;
	
	@Override
	public ArrayList<BoardEx> communityList(int currentPage, int pageSize, String searchOption, String keyword) {
		
		return bDAO.communityList(currentPage, pageSize, searchOption, keyword);
	}

	@Override
	public ArrayList<Notice> noticeList() {

		return bDAO.noticeList();
		
	}

	@Override
	public BoardEx view(int boardNo) throws Exception {
		
		return bDAO.view(boardNo);
	}

	@Override
	public int insertPost(Map<String, Object> map) {

		return bDAO.insertPost(map);
		
	}

	@Override
	public int update(HashMap<String,Object> map)  {
		
		return bDAO.update(map);
		
	}

	@Override
	public int deleteBoardPost(int boardNo) {

		return bDAO.deleteBoardPost(boardNo);
	}
	
	@Override
	public int getTotalCount(String searchOption, String keyword) {
		return bDAO.totalCount(searchOption, keyword);
	}

	@Override
	public List<Comment> commentList(int boardNo) throws Exception {
		
		return bDAO.commentList(boardNo);
	}

	@Override
	public int insertComment(Map<String, Object> map){
		
		return bDAO.insertComment(map);
		
	}

	
}
