package kr.co.todaydaeng.chatting.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.todaydaeng.chatting.model.vo.ChattingVO;

@Repository
public class ChattingDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//메세지 리스트
	public ArrayList<ChattingVO> chattingList(ChattingVO vo) {
		
		String nick = vo.getNick();
		
		//메세지 리스트에 나타낼 것들을 가져오기 - 가장 최근 메세지, 보낸사람 profile 사진, 보낸사람 nick
		ArrayList<ChattingVO> list = (ArrayList)sqlSession.selectList("chatting_list",vo);
		
		for (ChattingVO chatVo : list)
		{
			chatVo.setNick(nick);
			//현재 사용자가 해당 room 에서 안읽은 메세지의 갯수를 가져온다.
			int unread = sqlSession.selectOne("count_unread",chatVo);
			//현재 사용자가 메세지를 주고받는 상대 profile을 가져온다.
			String profile = sqlSession.selectOne("get_other_profile",chatVo);
			//안읽은 메세지 갯수를 chatVo에 set한다.
			chatVo.setUnread(unread);
			//메세지 상대의 프로필 사진을 chatVo에 set한다.
			chatVo.setProfile(profile);
			//메세지 상대 nick을 세팅한다. other_nick
			if(nick.equals(chatVo.getSend_nick())) 
			{
				chatVo.setOther_nick(chatVo.getRecv_nick());
			}else
			{
				chatVo.setOther_nick(chatVo.getSend_nick());
			}
		}
		
		return list;
	}
}
