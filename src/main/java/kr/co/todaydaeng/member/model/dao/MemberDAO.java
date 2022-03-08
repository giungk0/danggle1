package kr.co.todaydaeng.member.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.co.todaydaeng.member.model.vo.EmailAuthHist;
import kr.co.todaydaeng.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	//회원가입
	public int joinMember(Member member) {
		return sqlSession.insert("member.insertMember",member);
	}
	
	//회원가입 id 중복 확인
	public int memberIdCheck(String memberId) {
		return sqlSession.selectOne("member.selectId",memberId)!=null?1:0;
	}
	
	//로그인
	public Member loginMember(Member member) {
		return sqlSession.selectOne("member.loginMember",member);
	}
	
	//id찾기 전 회원 여부 확인
	public Member memberEmailCheck(String email) {
		return sqlSession.selectOne("member.selectEmail",email);
	}
	
	//id찾기 시 이메일 인증 정보 저장
	public int insertAuthNo(EmailAuthHist emailAuthHist) {
		return sqlSession.insert("member.insertAuthNo",emailAuthHist);
	}
	
	//이메일 인증 번호 확인하여 id알려주기
	public HashMap<String, Object> checkIdCode(HashMap<String, String> map) {
		return sqlSession.selectOne("member.checkIdCode", map);
	}
	
	//pwd찾기 전 회원 여부 확인
	public Member memberIdEmailCheck(HashMap<String, String> map) {
		return sqlSession.selectOne("member.selectIdEmail", map);
	}

	//pwd찾기 인증번호 체크
	public String checkPwdCode(HashMap<String, String> map) {
		return sqlSession.selectOne("member.checkPwdCode",map);
	}

	//pwd인증번호 확인 후 비번 재설정
	public int changeMemberPwd(HashMap<String, String> map) {
		return sqlSession.update("member.updateMemberPwd",map);
	}
	
	//기존 소셜 회원인지 id값 확인
	public Member selectSocialId(String socialId) {
		return sqlSession.selectOne("member.selectId",socialId);
	}

	//로그인한 날짜 업데이트
	public int updateLoginDate(Member m) {
		return sqlSession.update("member.updateLoginDate",m);
	}
	
	//휴면 해제
	public int wakeUpDormantMember(Member member) {
		return sqlSession.update("member.updateDormantMember",member);
	}
}
