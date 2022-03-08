package kr.co.todaydaeng.chatting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.todaydaeng.chatting.model.dao.ChattingDAO;
import kr.co.todaydaeng.chatting.model.vo.ChattingVO;

@Controller
public class ChattingController {

	@Autowired
	private ChattingDAO chatDAO;
	
	//메세지 목록
	
	@RequestMapping(value="/")
	public String message_list(HttpServletRequest request, HttpSession session) {
		//System.out.println("현대 사용자 nick : " + session.getAttribute("nick"));
		
		
		String nick = (String) session.getAttribute("nick");
		
		ChattingVO vo = new ChattingVO();
		vo.setNick(nick);
		
		//메세지 리스트
		ArrayList<ChattingVO> list = chatDAO.chattingList(vo);
		
		request.setAttribute("list", list);
		
		return "chatting/chatting_list";
	}
}
