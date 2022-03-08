package kr.co.todaydaeng.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.todaydaeng.admin.model.dao.AdminDAO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.myPage.model.vo.Dog;

@Component
public class MainPrint {
	
	@Autowired
	private AdminDAO aDAO;

	// 커뮤니티 글 div에 출력
	public ArrayList<Board> printCommunityBoard() {
		//DESC 페이징 후 3개 추출
		int first=1;
		int last=3;
		
		HashMap<String, Integer> pageNum = new HashMap<String, Integer>();
		pageNum.put("first", first);
		pageNum.put("last", last);
		
		//공지글 목록을 최근 순서로 페이징 처리해서 출력하는 쿼리 메소드
		ArrayList<Board> list = aDAO.selectBoardList(pageNum);
		
		//list 인덱스를 직접 지정해서 처리하면 단순하지만 쉽게 작업 가능
		return list;
	}
	
	// 댕댕 프로필을 테이블에 출력
	public ArrayList<Dog> printDogProfile() {		

		ArrayList<Dog> list = aDAO.selectDogList();
		
		return list;
	}

}
