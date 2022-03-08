package kr.co.todaydaeng.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.board.model.vo.Notice;
import kr.co.todaydaeng.member.model.vo.Member;
import kr.co.todaydaeng.myPage.model.vo.Dog;

@Repository
public class AdminDAO {
	
	//sqlSessionTemplate 임포트	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession; 

	public AdminVO selectAdminLogin(HashMap<String, String> map) {				
		return sqlSession.selectOne("admin.selectAdminLogin",map);
	}

	public String selectAdminIDCheck(String chkID) {
		return sqlSession.selectOne("admin.selectAdminIDCheck",chkID);
				
	}

	public int insertAdminAccount(AdminVO avo) {
		return sqlSession.insert("admin.insertAdminAccount",avo);
				
	}

	public String selectAdminEmailCheck(String chkMail) {
		return sqlSession.selectOne("admin.selectAdminEmailCheck",chkMail);
	}

	public int updateAdminPWD(HashMap<String, String> mapPwd) {
		return sqlSession.update("admin.updateAdminPWD",mapPwd);
	}

	public AdminVO selectAdminAccount(String adminID) {
		return sqlSession.selectOne("admin.selectAdminAccount",adminID);
	}

	public int updateAdminAccount(AdminVO avo) {
		return sqlSession.update("admin.updateAdminAccount", avo);
	}

	public ArrayList<AdminVO> selectAdminList() {
		
		//arrayList로 바로 casting이 되질 않아서 List객체에 저장했다가 형변환해서 리턴
		List<AdminVO> adm = new ArrayList<AdminVO>();		
		adm = sqlSession.selectList("admin.selectAdminList");
		
		return (ArrayList<AdminVO>) adm;	
		
	}

	public int selectAdminNew() {
		return sqlSession.selectOne("admin.selectAdminNew");
	}

	public int updateAdminGrade(HashMap<String, Object> map) {
		return sqlSession.update("admin.updateAdminGrade", map);
	}

	public ArrayList<AdminVO> selectAdminSearch(HashMap<String, String> findMap) {
		List<AdminVO> adm = new ArrayList<AdminVO>();
		adm = sqlSession.selectList("admin.selectAdminSearch", findMap);
		return (ArrayList<AdminVO>) adm;
	}
	

	public ArrayList<Member> selectMemberList(HashMap<String, Integer> pageNum) {				
		List<Member> mvo = new ArrayList<Member>();
		mvo = sqlSession.selectList("admin.selectMemberList", pageNum);
		return (ArrayList<Member>) mvo;
	}

	public int selectMemberCount() {
		return sqlSession.selectOne("admin.selectMemberCount");
	}
	
	public int updateMemberStatus(HashMap<String, Object> map) {
		return sqlSession.update("admin.updateMemberStatus", map);
	}

	public int selectMemberDormant() {
		return sqlSession.selectOne("admin.selectDormantCount");
	}

	public ArrayList<Member> selectMemberSearch(HashMap<String, String> findMap) {
		List<Member> list = new ArrayList<Member>();
		list = sqlSession.selectList("admin.selectMemberSearch",findMap);
		return (ArrayList<Member>) list;
	}

	public int insertAdminNotice(HashMap<String, String> map) {
		return sqlSession.insert("admin.insertAdminNotice",map);
	}

	public ArrayList<Notice> selectNoticeList(HashMap<String, Integer> pageNum) {
		List<Notice> list = new ArrayList<Notice>();
		list = sqlSession.selectList("admin.selectNoticeList",pageNum);
		return (ArrayList<Notice>) list;
	}

	public int selectNoticeCount() {
		return sqlSession.selectOne("admin.selectNoticeCount"); 
	}

	public Notice selectNoticeRead(int noticeNo) {		
		return sqlSession.selectOne("admin.selectNoticeRead", noticeNo); 
	}

	public int updateNoticeEdit(HashMap<String, Object> map) {
		return sqlSession.update("admin.updateNoticeEdit", map);
	}

	public int updateNoticeDelete(int noticeNo) {
		return sqlSession.update("admin.updateNoticeDelete", noticeNo);
	}

	public ArrayList<Notice> selectNoticeSearch(HashMap<String, String> findMap) {
		List<Notice> list = new ArrayList<Notice>();
		list = sqlSession.selectList("admin.selectNoticeSearch",findMap);
		return (ArrayList<Notice>) list;
	}

	public int updateNoticeChange(HashMap<String, Object> map) {
		return sqlSession.update("admin.updateNoticeChnage",map);
	}

	public ArrayList<Board> selectBoardList(HashMap<String, Integer> pageNum) {
		List<Board> list = new ArrayList<Board>();
		list = sqlSession.selectList("admin.selectBoardList",pageNum);
		return (ArrayList<Board>) list;
	}

	public int selectBoardCount() {
		return sqlSession.selectOne("admin.selectBoardCount");
	}



	public ArrayList<Board> selectBoardSearch(HashMap<String, String> findMap) {		
		List<Board> list = new ArrayList<Board>();
		list = sqlSession.selectList("admin.selectBoardSearch",findMap);
		return (ArrayList<Board>) list;
	}

	public int updateBoardChange(HashMap<String, Object> map) {
		return sqlSession.update("admin.updateBoardChange",map);
	}

	public ArrayList<Dog> selectDogList() {
		List<Dog> list = new ArrayList<Dog>();
		list = sqlSession.selectList("admin.selectDogList");
		return (ArrayList<Dog>) list;
		
	}
	
	public String pageNavi(int currentPage, int recordCountPerPage, int naviCountPerPage, String tag) {
		
		 String keyword = "";
		 int recordTotalCount = 0;
		
		//총 페이지 수			
		switch(tag){
		
		case("member"):
		recordTotalCount = selectMemberCount();
		keyword = "member";
		break;

		case("notice"):
		recordTotalCount = selectNoticeCount();
		keyword = "notice";
		break;

		case("board"):
		recordTotalCount = selectBoardCount();
		keyword = "board";
		break;
		}

		// 전체 페이지 수 계산
		int pageTotalCount = 0;				
		pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);

		//페이지 네비 시작점
		int startNavi = ( ((currentPage-1)/naviCountPerPage) * naviCountPerPage) +1;
		
		//페이지 네비 종료점
		int endNavi = startNavi + (naviCountPerPage-1);
		
		//페이지 네비의 종료점이 전체 페이지 수를 초과하지 않게 출력
		if ( endNavi > pageTotalCount) endNavi = pageTotalCount;
		
		//페이지 네비의 HTML 요소를 String Builder로 작성
		StringBuilder sb = new StringBuilder();		

		// 페이지 네비가 1페이지 시작이 아니라면 HTML요소를 뒤로가기로 생성
		if (startNavi != 1) sb.append("<li class='page-item'><a class='page-link' href='/admin/"+ keyword +"Manage.do?currentPage="+(startNavi-1)+"' aria-label='Previous'> ◀  </a> </li>");
			
			// 페이지 네비를 구성하는 HTML 요소를 반복문으로 생성
		for (int i=startNavi; i <= endNavi; i++) {
			//현재 페이지는 볼드
			if (i == currentPage) sb.append("<li class='page-item'><a class='page-link' href='/admin/"+ keyword +"Manage.do?currentPage="+i+"'><B style='font-size:1.2em'>"+i+"</B></a></li>");
			else sb.append("<li class='page-item'><a class='page-link' href='/admin/"+ keyword + "Manage.do?currentPage="+i+"'>"+i+"</a></li>");				
		}
		
		//페이지 네비가 마지막 이 아니라면 HTML 요소로 앞으로 가기를 생성				
		if (endNavi != pageTotalCount) sb.append("<li class='page-item'><a class='page-link' href='/admin/"+ keyword +"Manage.do?currentPage="+(endNavi+1)+"' aria-label='Next'> ▶  </a></li>");				
		
		
		//String Builder로 만든 HTML 요소를 String으로 return
		return sb.toString();
		
	}
	

}
