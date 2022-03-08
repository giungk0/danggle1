package kr.co.todaydaeng.member.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todaydaeng.member.model.dao.MemberDAO;
import kr.co.todaydaeng.member.model.vo.EmailAuthHist;
import kr.co.todaydaeng.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDAO;
	
	@Override
	public int joinMember(Member member) {
		return mDAO.joinMember(member);
	}
	
	@Override
	public int memberIdCheck(String memberId) {
		return mDAO.memberIdCheck(memberId);
	}
	
	@Override
	public Member loginMember(Member member) {
		return mDAO.loginMember(member);
	}
	
	@Override
	public Member memberEmailCheck(String email) {
		return mDAO.memberEmailCheck(email);
	}
	
	@Override
	public int insertAuthNo(EmailAuthHist emailAuthHist) {
		return mDAO.insertAuthNo(emailAuthHist);
	}
	
	@Override
	public HashMap<String, Object> checkIdCode(HashMap<String, String> map) {
		return mDAO.checkIdCode(map);
	}
	
	@Override
	public Member memberIdEmailCheck(HashMap<String, String> map) {
		return mDAO.memberIdEmailCheck(map);
	}

	@Override
	public String checkPwdCode(HashMap<String, String> map) {
		//동적인 쿼리 결과 처리
		String result="";
		if(mDAO.checkPwdCode(map)==null) {
			result = null;
		}else {
			result = mDAO.checkPwdCode(map);
		}
		return result;
	}

	@Override
	public int changeMemberPwd(HashMap<String, String> map) {
		return mDAO.changeMemberPwd(map);
	}

	@Override
	public int updateLoginDate(Member m) {
		return mDAO.updateLoginDate(m);
	}
	
	@Override
	public int wakeUpDormantMember(Member member) {
		return mDAO.wakeUpDormantMember(member);
	}
}
