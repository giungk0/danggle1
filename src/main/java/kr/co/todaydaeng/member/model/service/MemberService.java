package kr.co.todaydaeng.member.model.service;

import java.util.HashMap;

import kr.co.todaydaeng.member.model.vo.EmailAuthHist;
import kr.co.todaydaeng.member.model.vo.Member;

public interface MemberService {
	//회원가입
	int joinMember(Member member);

	//id 중복 확인
	int memberIdCheck(String userId);
	
	//로그인
	Member loginMember(Member member);
	
	//id찾기 전 회원 여부 확인
	Member memberEmailCheck(String email);
	
	//id찾기 시 이메일 인증 정보 저장
	int insertAuthNo(EmailAuthHist emailAuthHist);
	
	//id찾기 인증번호 확인 후 id 안내
	HashMap<String, Object> checkIdCode(HashMap<String, String> map);
	
	//pwd찾기 전 회원 여부 확인
	Member memberIdEmailCheck(HashMap<String, String> map);

	//pwd찾기 인증번호 확인
	String checkPwdCode(HashMap<String, String> map);

	//pwd인증번호 확인 후 비밀번호 재설정
	int changeMemberPwd(HashMap<String, String> map);

	//로그인한 날짜 업데이트
	int updateLoginDate(Member m);
	
	//휴면 해제
	int wakeUpDormantMember(Member member);

}
