package kr.co.todaydaeng.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.board.model.vo.BoardEx;
import kr.co.todaydaeng.board.model.vo.Comment;
import kr.co.todaydaeng.board.model.vo.Notice;
import kr.co.todaydaeng.myPage.model.vo.Dog;

@Repository
public class BoardDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<BoardEx> communityList(int currentPage, int pageSize, String searchOption, String keyword) {
		if (keyword.equals("")) searchOption = "none";
		String condition = "";
		switch(searchOption) {
			default: 
			case "none": 
				condition = " 1 = 1 "; break;
			case "subject": 
				condition = "subject LIKE '%" + keyword + "%' "; break;
			case "memberId":
				condition = "member_id LIKE '%" + keyword + "%' "; break;
			case "all":
				condition = "(subject LIKE '%" + keyword + "%' OR member_id LIKE '%" + keyword + "%' )"; break;
		}
		RowBounds rb = new RowBounds((currentPage - 1) * pageSize, pageSize);
		return new ArrayList<BoardEx>(sqlSession.selectList("board.communityListEx", condition, rb));
	}
	
	public ArrayList<Notice> noticeList() {
		RowBounds rb = new RowBounds(0, 5);
		return new ArrayList<Notice>(sqlSession.selectList("board.noticeList", null, rb));
	}

	public BoardEx view(int boardNo) throws Exception {
		 
		 return sqlSession.selectOne("board.view", boardNo);
		}

	public int insertPost(Map<String, Object> map) {

		return sqlSession.insert("board.insertPost",map);
		
	}
 
	public int update(HashMap<String,Object> map) {

		return sqlSession.update("board.update", map);
	}
	
	public int totalCount(String searchOption, String keyword) {
		if (keyword.equals("")) searchOption = "none";
		String condition = "";
		switch(searchOption) {
			default: 
			case "none": 
				condition = " 1 = 1 "; break;
			case "subject": 
				condition = "subject LIKE '%" + keyword + "%' "; break;
			case "memberId":
				condition = "member_id LIKE '%" + keyword + "%' "; break;
			case "all":
				condition = "(subject LIKE '%" + keyword + "%' OR member_id LIKE '%" + keyword + "%' )"; break;
		}
		return sqlSession.selectOne("board.searchTotalCount", condition);
	}

	public int deleteBoardPost(int boardNo) {

		return sqlSession.update("board.deleteBoardPost", boardNo);
	}
	
	public List<Comment> commentList(int boardNo) throws Exception {
		
		return sqlSession.selectList("comment.commentList", boardNo);
	}

	public int insertComment(Map<String, Object> map) {

		return sqlSession.insert("comment.insertComment",map);
	}
		

}
