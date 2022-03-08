package kr.co.todaydaeng.member.model.service;

import java.util.HashMap;

import kr.co.todaydaeng.member.model.vo.Member;

public interface AuthService {
	//카카오 액세스 토큰 요청
	public String getAccessToken(String authorize_code);
	
	//카카오 사용자 정보 요청
	public HashMap<String, Object> getUserInfo(String access_Token);
	
	//네이버 액세스 토큰 요청
	public String getNaverAccessToken(String authorize_code);
	
	//네이버 사용자 정보 요청
	public HashMap<String, Object> getNaverUserInfo(String access_Token);

	//이미 존재하는 소셜 사용자인지 확인
	public Member selectSocialId(String socialId);

	//소셜 가입 (첫 사용자)
	public int socialJoin(Member member);

	////로그인한 날짜 업데이트
	public int updateLoginDate(Member m);
}
