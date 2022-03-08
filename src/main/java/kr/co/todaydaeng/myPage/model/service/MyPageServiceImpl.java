package kr.co.todaydaeng.myPage.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todaydaeng.member.model.vo.Member;
import kr.co.todaydaeng.myPage.model.dao.MyPageDAO;
import kr.co.todaydaeng.myPage.model.vo.Dog;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO mpDAO;

	@Override
	public Member selectPwdCheck(HashMap<String, String> map) {
		
		return mpDAO.selectPwdCheck(map);

	}

	@Override
	public int updateMemberInfo(Member m) {
		return mpDAO.updateMemberInfo(m);
	}

	@Override
	public int updatePwdChange(HashMap<String, String> map) {
		return mpDAO.updatePwdChange(map);
	}

	@Override
	public int withdrawCheck(HashMap<String, String> map) {
		return mpDAO.withdrawCheck(map);
	}

	@Override
	public HashMap<String , Object> selectDogInfo(int currentPage,int memberNo) {
		
		// 하나의 Page에 몇개의 강아지 정보를 보여 줄 것인지 설정
		int recordCountPerPage=2;
		ArrayList<Dog> list = mpDAO.selectAllDogInfoList(currentPage,recordCountPerPage, memberNo);
		
		// 하나의 PageNavi Bar 에 보여질 Navi 개수 설정
		int naviContPerPage=2;
		String pageNavi = mpDAO.getPageNavi(naviContPerPage,currentPage,recordCountPerPage, memberNo);
		
		HashMap<String , Object> result=new HashMap<String, Object>();
		result.put("list", list);
		result.put("pageNavi", pageNavi);
		
		return result;
	}

	@Override
	public int insertDogInfo(Dog dog) {
		return mpDAO.insertDogInfo(dog);
	}

	@Override
	public Dog selectOneDogInfo(int dogNo) {
		return mpDAO.selectOneDogInfo(dogNo);
	}

	@Override
	public int updateDogInfo(Dog dog) {
		return mpDAO.updateDogInfo(dog);
	}

	@Override
	public int deleteDogInfo(int dogNo) {
		return mpDAO.deleteDogInfo(dogNo);
	}
}
