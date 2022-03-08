package kr.co.todaydaeng.myPage.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.todaydaeng.member.model.vo.Member;
import kr.co.todaydaeng.myPage.model.vo.Dog;

public interface MyPageService {

	Member selectPwdCheck(HashMap<String, String> map);

	int updateMemberInfo(Member m);

	int updatePwdChange(HashMap<String, String> map);

	int withdrawCheck(HashMap<String, String> map);

	HashMap<String , Object> selectDogInfo(int currentPage,int memberNo);

	int insertDogInfo(Dog dog);

	Dog selectOneDogInfo(int dogNo);

	int updateDogInfo(Dog dog);

	int deleteDogInfo(int dogNo);

	

}
