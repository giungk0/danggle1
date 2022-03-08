package kr.co.todaydaeng.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.todaydaeng.board.model.vo.BoardEx;
import kr.co.todaydaeng.board.model.vo.Comment;
import kr.co.todaydaeng.board.model.vo.Notice;

public interface BoardService {
	
	ArrayList<BoardEx> communityList(int currentPage, int pageSize, String searchOption, String keyword);
	
	ArrayList<Notice> noticeList();

	public BoardEx view(int boardNo) throws Exception;

	int insertPost(Map<String, Object> map) throws Exception;

	int update(HashMap<String,Object> map);

	int deleteBoardPost(int boardNo);
	
	int getTotalCount(String searchOption, String keyword);

	List<Comment> commentList(int boardNo) throws Exception;

	int insertComment(Map<String, Object> map);

}
