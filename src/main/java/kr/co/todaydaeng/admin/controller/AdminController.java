package kr.co.todaydaeng.admin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.todaydaeng.admin.model.service.AdminService;
import kr.co.todaydaeng.admin.model.service.ManageService;
import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.board.model.vo.Board;
import kr.co.todaydaeng.board.model.vo.Notice;
import kr.co.todaydaeng.common.StatusChk;
import kr.co.todaydaeng.member.model.vo.Member;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	@Autowired
	private ManageService mService;
	
	@Autowired
	private StatusChk sChk;

	@RequestMapping(value="/admin/adminIndex.do", method = RequestMethod.GET)
		public String adminIndex (HttpSession session) {
		//기존 댕댕에서의 세션을 초기화
		session.invalidate();
		
		//관리자 로그인 페이지로 리다이렉트		
		return "adminView/adminLogin";
		}
	
	
	@RequestMapping(value="/admin/adminLogin.do", method = RequestMethod.POST)
	public void selectAdminLogin(HttpSession session, HttpServletResponse response,
							@RequestParam String adminID, @RequestParam String adminPWD) throws IOException {
						
				//Request Param 인자의 유효성 검사 
				if (adminID == null || adminPWD == null) {
					response.getWriter().print(false);
					
				}else {		
					
					HashMap<String, String> map = new HashMap<String, String>();
					
					map.put("adminID",adminID);
					map.put("adminPWD",adminPWD);
								
				AdminVO adm = aService.selectAdminLogin(map);
				
				if (adm != null) {			
					session.setAttribute("adminVO", adm);
					response.getWriter().print(true);				
				}else {
					// return되는 정보가 없으면 false 반환, 로그인 페이지 그대로 유지
					response.getWriter().print(false);
				}	
		
			}
	}
	
	@RequestMapping(value="/admin/adminLogout.do", method = RequestMethod.GET)
	public String adminLogout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/admin/adminMain.do", method = RequestMethod.GET)
	public String adminMain(HttpSession session) {
		AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {
			return "adminView/aOnly";
		}else {
		return "adminView/adminMain";
		}
	}
	
	@RequestMapping(value="/admin/adminAccount.do")
	public String adminAccount(HttpSession session) {
		AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {
			return "adminView/aOnly";
		}else {
		return "adminView/adminAccount";
		}
	}
	
	@RequestMapping(value="/admin/adminIDCheck.do", method = RequestMethod.POST)
	public void selectAdminIDCheck(@RequestParam String chkID, HttpServletResponse response) throws IOException {		
		
		//ID중복 확인값의 유효성 검사
		if (chkID == null || chkID.length() > 15) {
			response.getWriter().print("invalid");
		}else {
			String result = mService.selectAdminIDCheck(chkID);						
			
			if (result == null) {
				response.getWriter().print("pass");
			}else {
				response.getWriter().print("false");
			}
		}
	}
	
	@RequestMapping(value="/admin/insertAdminAccount.do", method = RequestMethod.POST)
	public void insertAdminAccount(AdminVO avo, HttpServletResponse response) throws IOException {
		String id = avo.getAdminID();
		String pwd = avo.getAdminPWD();
		String name = avo.getAdminName();
		String email = avo.getAdminEmail();
		
		//유효성 검사
		if ( id == null || pwd == null || name == null || email == null || name.length() <2 || name.length() > 5 || email.length() > 31 || !(email.contains("@")) || pwd.length() > 21 ) {
			response.getWriter().print("invalid");
		}else {
			int result = mService.insertAdminAccount(avo);
			
			if (result >0) {
				response.getWriter().print("pass");
			}else {
				response.getWriter().print("false");
			}
		}		
	}
	
	@RequestMapping(value="/admin/adminInfo.do")
	public String adminInfo(HttpSession session) {
		AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {
			return "adminView/aOnly";
		}else {
		return "adminView/adminInfo";
		}
	}

	@RequestMapping(value="/admin/adminEmailCheck.do", method=RequestMethod.POST)
	public void selectAdminEmailCheck(@RequestParam String chkMail, HttpServletResponse response) throws IOException {
		
		//email중복 확인값의 유효성 검사
		if (chkMail == null || chkMail.length() > 30 ) {
			response.getWriter().print("invalid");
		}else {
			String result = aService.selectAdminEmailCheck(chkMail);						
			
			if (result == null) {
				response.getWriter().print("pass");
			}else {
				response.getWriter().print("false");
			}
		}
	}
	
	@RequestMapping(value="/admin/updatePWDChange.do", method=RequestMethod.POST)
	public void updateAdminPWD(@RequestParam String adminID, @RequestParam String oldPWD, 
								@RequestParam String newPWD, HttpServletResponse response)  throws IOException {
		
		// 로그인 메소드를 호출하여 사용자 검증 후에 암호 변경 로직을 수행한다
		HashMap<String, String> map = new HashMap<String, String>();		
		map.put("adminID",adminID);
		map.put("adminPWD",oldPWD);

		AdminVO adm = aService.selectAdminLogin(map);
	
		if (adm == null)  {
			response.getWriter().print("invalid");
			
		}else {
		//사용자 검증-로그인 메소드를 통과했다면 암호 변경 로직을 수행
		HashMap<String, String> mapPwd = new HashMap<String, String>();		
		mapPwd.put("adminID", adminID);		
		mapPwd.put("newPWD", newPWD);		
			int result = aService.updateAdminPWD(mapPwd);						
			
			if (result >0) {
				response.getWriter().print("true");
			}else {
				response.getWriter().print("false");
			}
		}	
	}	
	
	@RequestMapping(value="/admin/updateAdminAccount.do", method=RequestMethod.POST)
	public void updateAdminAccount(AdminVO avo, HttpServletResponse response, HttpSession session) throws IOException {						
		String name = avo.getAdminName();
		String email = avo.getAdminEmail();
		String adminID = avo.getAdminID();
		
		//int sign = sChk.gradeChk(session);
		
		//유효성 검사 및 권한 검사 추가해야 함
		if ( name == null || email == null || name.length() <2 || name.length() > 5 || email.length() > 31 || !(email.contains("@")) ) {
			response.getWriter().print("invalid");

		}else {	
			String chkMail = email;
			String chk = aService.selectAdminEmailCheck(chkMail);
			if (chk != null) {
				response.getWriter().print("invalid");
			}else {
			
			int result = aService.updateAdminAccount(avo);
			
			if (result >0) {
				
				//업데이트 끝나면 select query 실행해서 session을 갱신
				AdminVO refresh = aService.selectAdminAccount(adminID);
				session.setAttribute("adminVO",refresh);				
				response.getWriter().print("pass");
			}else {
				response.getWriter().print("false");
			}
		  }
		}	
	}
	
	@RequestMapping(value="/admin/adminManage.do")
	public ModelAndView adminManage(ModelAndView mav,HttpSession session) {
		AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {					
			mav.setViewName("adminView/aOnly");
			return mav;
		}else {									
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<AdminVO> list = aService.selectAdminList();
		map.put("admin", list);
		
		int newbie = aService.selectAdminNew();
		map.put("count", newbie);

		mav.addObject("map",map);		
		mav.setViewName("adminView/adminManage");
		
		return mav;
		}
	}
	
	@RequestMapping(value="/admin/adminGradeChange.do", method=RequestMethod.POST)
	public void updateAdminGrade(@RequestParam(value="dataArray[]")ArrayList<Integer> dataArray, @RequestParam String newGrade, 
								HttpServletResponse response, HttpSession session ) throws IOException {

		if(dataArray == null || newGrade == null) {
			response.getWriter().print(false);
		}else {
			
		int sign = sChk.gradeChk(session);			
		if(sign == 1) {										
			HashMap<String, Object> map = new HashMap<String, Object>();		
			map.put("newGrade",newGrade);
			map.put("adminNo",dataArray);
			int result = mService.updateAdminGrade(map);

			if(result == dataArray.size()) {
				response.getWriter().print("pass");
			}else {
				response.getWriter().print("false");
			}
			 }else {
				response.getWriter().print("false");
			 }
		}
 
	}
	
	@RequestMapping(value="/admin/manageSearch.do", method=RequestMethod.GET)
	public ModelAndView selectAdminSearch(HttpServletRequest request, ModelAndView mav) {
		String tag = request.getParameter("tag");
		String keyword = request.getParameter("keyword");
		
		if ( tag == null || keyword == null ) {
			mav.addObject("msg","값을 입력해야 합니다");		
			mav.setViewName("adminView/alert");				
			return mav;
		}else {
		HashMap<String, String> findMap = new HashMap<String, String>();		
		findMap.put("keyword",keyword);
		findMap.put("tag",tag);		
		ArrayList<AdminVO> list = aService.selectAdminSearch(findMap);
		
		HashMap<String, Object> map = new HashMap<String, Object>();		
		map.put("admin", list);		
		int newbie = aService.selectAdminNew();
		map.put("count", newbie);

		mav.addObject("map",map);		
		mav.setViewName("adminView/adminManage");	
		
		return mav;
		}
	}		

	@RequestMapping(value="/admin/memberManage.do")
	public ModelAndView memberManage(ModelAndView mav,HttpServletRequest request,HttpSession session) {
		AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {		
			mav.setViewName("adminView/aOnly");
			return mav;
		}else {		
		
		// 1. 사용자 목록과 페이징 처리를 위한 매개변수 저장		
		int currentPage=0;
		//시작페이지 설정		
		int recordCountPerPage =5;		
		if (request.getParameter("currentPage") == null ) currentPage =1;
		else currentPage = Integer.parseInt(request.getParameter("currentPage") );				
		
		//시작 페이지 쪽수
		int first = currentPage * recordCountPerPage - (recordCountPerPage -1);
		
		//마지막 페이지 쪽수
		int last = currentPage * recordCountPerPage;
		
		HashMap<String, Integer> pageNum = new HashMap<String, Integer>();
		pageNum.put("first", first);
		pageNum.put("last", last);
		//사용자 목록을 페이징 처리해서 출력하는 메소드
		ArrayList<Member> list = aService.selectMemberList(pageNum);			

		/*  //list 출력 테스트
		int total=list.size();
		for (int i=0; i<total;i++) {
			System.out.println(list.get(i));
		}  */

		
		// 페이징 처리된 목록을 위한 페이지 네비 생성	
		// 페이지 네비 호출
		int naviCountPerPage = 5;			
		String tag = "member";
		String pageNavi = aService.pageNavi(currentPage, recordCountPerPage, naviCountPerPage, tag);
		
		//사용자 목록 페이지 네비의 시작점 종료점
		int start = 1;
		int end = aService.selectMemberCount();
		//System.out.println(end);
		

		// 2. 페이징 처리 된 목록을 model 객체에 저장
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list",list);
		
		
		map.put("pageNavi", pageNavi);
		map.put("currentPage",currentPage);			
		map.put("start",start);
		map.put("end",end);
		
		int dormant = aService.selectMemberDormant();
		map.put("count", dormant);
		
		// 3. VIEW로 전송
		mav.addObject("map",map);
		mav.setViewName("adminView/memberManage");		
		return mav;	
		}
	}
	
	@RequestMapping(value="/admin/memberStatusChange.do")
	public void memberStatusChange(@RequestParam(value="dataArray[]")ArrayList<Integer> dataArray, @RequestParam String status, 
							HttpServletResponse response,HttpSession session ) throws IOException {
		//System.out.println(status.charAt(0));
		//System.out.println(dataArray);
		
			char newStatus = status.charAt(0);
			if(dataArray == null || status == null) {
			response.getWriter().print(false);
			}else {
				int sign = sChk.gradeChk(session);			
				if(sign == 1) {				
					HashMap<String, Object> map = new HashMap<String, Object>();		
					map.put("status",newStatus);
					map.put("memberNo",dataArray);
					int result = mService.updateMemberStatus(map);
					
					if(result == dataArray.size()) {
					response.getWriter().print("pass");
					}else {
					response.getWriter().print("false");
					}
				}else {
					response.getWriter().print("false");
				}
			}
	}
	
	@RequestMapping(value="/admin/memberSearch.do")
	public ModelAndView memberSearch(HttpServletRequest request, ModelAndView mav, @RequestParam int currentPage) {
		
		String tag = request.getParameter("tag");
		String keyword = request.getParameter("keyword");
		if ( tag == null || keyword == null ) {
			mav.addObject("msg","값을 입력해야 합니다");		
			mav.setViewName("adminView/alert");				
			return mav;
		}else {
		HashMap<String, String> findMap = new HashMap<String, String>();		
		findMap.put("keyword",keyword);
		findMap.put("tag",tag);		
		ArrayList<Member> list = aService.selectMemberSearch(findMap);

		HashMap<String, Object> map = new HashMap<String, Object>();		
		map.put("list", list);		
		int dormant = aService.selectMemberDormant();
		map.put("count", dormant);
		map.put("currentPage", currentPage);

		mav.addObject("map",map);		
		mav.setViewName("adminView/memberManage");	

		return mav;
		}
	}
	
	@RequestMapping(value="/admin/noticeWrite.do")
	public String noticeWrite(HttpSession session) {
		AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {
			return "adminView/aOnly";
		}else {		
		return "adminView/noticeWrite";
		}
	}
	
	@RequestMapping(value="/admin/insertNotice.do")
	public void insertNotice(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws IOException {		
				
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int sign = sChk.gradeChk(session);
		//문자열의 앞,뒤 공백 제거
		title.trim();
		content.trim();
		
		//작성한 글의 유효성과 사용자 권한 검사
		if (title == null || content == null || sign == 0) {			
			response.getWriter().print("false");			
		}else {																	
			HashMap<String, String> map = new HashMap<String, String>();		
			map.put("subject", title);
			map.put("content", content);			
			int result = mService.insertAdminNotice(map);
			
			if(result>0) {
				response.getWriter().print("true");
			}else {				
				response.getWriter().print("false");	
			}
		}
		
	}
	
	@RequestMapping(value="/admin/noticeManage.do")
	public ModelAndView noticeManage(ModelAndView mav,HttpServletRequest request,HttpSession session) {
		 AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {		
			mav.setViewName("adminView/aOnly");
			return mav;
		}else { 				
			// 1. 공지글 목록과 페이징 처리를 위한 매개변수 저장		
			int currentPage=0;
			//시작페이지 설정		
			int recordCountPerPage =5;		
			if (request.getParameter("currentPage") == null ) currentPage =1;
			else currentPage = Integer.parseInt(request.getParameter("currentPage") );				
			
			//시작 페이지 쪽수
			int first = currentPage * recordCountPerPage - (recordCountPerPage -1);
			
			//마지막 페이지 쪽수
			int last = currentPage * recordCountPerPage;
			
			HashMap<String, Integer> pageNum = new HashMap<String, Integer>();
			pageNum.put("first", first);
			pageNum.put("last", last);
			//공지글 목록을 페이징 처리해서 출력하는 메소드
			ArrayList<Notice> list = aService.selectNoticeList(pageNum);
			
			/* //date 출력 포맷 변경			 
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 kk시 mm분");			
			int total=list.size();
			for (int i=0; i<total;i++) {				
				Date outDate = new Date();
				outDate = list.get(i).getRegDate();
				simpleDate.format(outDate);
				list.get(i).setRegDate(outDate);
			}  */
			
			
			// 페이징 처리된 목록을 위한 페이지 네비 생성	
			// 페이지 네비 호출
			int naviCountPerPage = 3;				
			String tag = "notice";
			String pageNavi = aService.pageNavi(currentPage, recordCountPerPage, naviCountPerPage, tag);
			
			//사용자 목록 페이지 네비의 시작점 종료점
			int start = 1;
			int end = aService.selectNoticeCount();

			// 2. 페이징 처리 된 목록을 model 객체에 저장
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("list",list);
			
			
			map.put("pageNavi", pageNavi);
			map.put("currentPage",currentPage);			
			map.put("start",start);
			map.put("end",end);
						
			// 3. VIEW로 전송
			mav.addObject("map",map);					
			mav.setViewName("adminView/noticeManage");
			return mav;
		}
	 }

		
	@RequestMapping(value="/admin/noticeEdit.do")
	public ModelAndView noticeEdit(HttpServletRequest request, ModelAndView mav,HttpSession session) {
		int currentPage = Integer.parseInt(request.getParameter("currentPage") );
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo") );		
		
		int sign = sChk.gradeChk(session);		
		if(sign == 1) {			
			Notice rNotice = mService.selectNoticeRead(noticeNo);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("currentPage", currentPage);		
			map.put("notice", rNotice);
			
			mav.addObject("map",map);
			mav.setViewName("adminView/noticeEdit");
			return mav; 
		}else {
			mav.addObject("msg","편집 권한이 없습니다");
			mav.setViewName("adminView/alert");	
			return mav;
		}
		
	}
   
	@RequestMapping(value="/admin/updateNotice.do")
	public void updateNotice(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo") );
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//유효성 검사
		if (title == null || content == null) {			
			response.getWriter().print("false");
		} else {
				
			int sign = sChk.gradeChk(session);			
			if(sign == 1) {
				//공지사항 수정 내역 표시하기
				StringBuilder sb = new StringBuilder();
				LocalDateTime now = LocalDateTime.now();
				String timeStamp = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
				
				sb.append(content); 
				sb.append("------ [ ");
				sb.append(timeStamp); 
				sb.append(" ]에 수정된 글입니다");
				content = sb.toString();
				
				
				map.put("subject", title);
				map.put("content", content);
				map.put("noticeNo", noticeNo);
				
				int result = mService.updateNoticeEdit(map);		
				
				if(result>0) {
					response.getWriter().print("true");
				}else {			
					response.getWriter().print("false");
				}			
			}else {
				response.getWriter().print("false");
			}
		}
		
	}
	
	@RequestMapping(value="/admin/noticeDelete.do")
	public void deleteNotice(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo") );		

		int sign = sChk.gradeChk(session);			
		if(sign == 1) {
			int result = mService.updateNoticeDelete(noticeNo);					
			if(result>0) {
					response.getWriter().print("true");
				}else {			
					response.getWriter().print("false");
				}
			}else {
				response.getWriter().print("false");
		}
   }
	@RequestMapping(value="/admin/noticeSearch.do")
	public ModelAndView noticeSearch(HttpServletRequest request,@RequestParam int currentPage,
		  ModelAndView mav) {

		String tag = request.getParameter("tag");
		String keyword = request.getParameter("keyword");
		
		if ( tag == null || keyword == null ) {
			mav.addObject("msg","값을 입력해야 합니다");		
			mav.setViewName("adminView/alert");				
			return mav;
		}else {
		
		HashMap<String, String> findMap = new HashMap<String, String>();		
		findMap.put("keyword",keyword);
		findMap.put("tag",tag);			
		ArrayList<Notice> list = aService.selectNoticeSearch(findMap);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("list", list);
		
		//System.out.println(list);
		mav.addObject("map",map);		
		mav.setViewName("adminView/noticeManage");	
		return mav;
	 }
		
	}
	
	
	@RequestMapping(value="/admin/noticeChange.do")
	public void noticeChange(@RequestParam(value="dataArray[]")ArrayList<Integer> dataArray, @RequestParam String status, 
							HttpServletResponse response,HttpSession session ) throws IOException {
		//System.out.println(status.charAt(0));
		//System.out.println(dataArray);
				
		char newStatus = status.charAt(0);
		newStatus = Character.toUpperCase(newStatus);
		//System.out.println(newStatus);
		
		if(dataArray == null) {
		response.getWriter().print(false);
		
		}else {
			
			int sign = sChk.gradeChk(session);			
			if(sign == 1) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();		
			map.put("status",newStatus);
			map.put("noticeNo",dataArray);
			int result = mService.updateNoticeChange(map);
			
			//System.out.println(result);
			
			if(result == dataArray.size() ) {
			response.getWriter().print("pass");
			}else {
			response.getWriter().print("false");
		 }
		}else {
			response.getWriter().print("false");
		}
	  }
	}
	
	@RequestMapping(value="/admin/boardManage.do")
	public ModelAndView boardManage(ModelAndView mav,HttpServletRequest request,HttpSession session) {
		 AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
		if (chkIn == null) {		
			mav.setViewName("adminView/aOnly");
			return mav;
		}else {  				
		
			// 1. 공지글 목록과 페이징 처리를 위한 매개변수 저장		
			int currentPage=0;
			//시작페이지 설정		
			int recordCountPerPage =5;		
			if (request.getParameter("currentPage") == null ) currentPage =1;
			else currentPage = Integer.parseInt(request.getParameter("currentPage") );				
			
			//시작 페이지 쪽수
			int first = currentPage * recordCountPerPage - (recordCountPerPage -1);
			
			//마지막 페이지 쪽수
			int last = currentPage * recordCountPerPage;
			
			HashMap<String, Integer> pageNum = new HashMap<String, Integer>();
			pageNum.put("first", first);
			pageNum.put("last", last);
			//공지글 목록을 페이징 처리해서 출력하는 메소드
			ArrayList<Board> list = aService.selectBoardList(pageNum);
			
			/* //date 출력 포맷 변경			 
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 kk시 mm분");			
			int total=list.size();
			for (int i=0; i<total;i++) {				
				Date outDate = new Date();
				outDate = list.get(i).getRegDate();
				simpleDate.format(outDate);
				list.get(i).setRegDate(outDate);
			}  */
			
			
			// 페이징 처리된 목록을 위한 페이지 네비 생성	
			// 페이지 네비 호출
			int naviCountPerPage = 5;				
			String tag = "board";
			String pageNavi = aService.pageNavi(currentPage, recordCountPerPage, naviCountPerPage, tag);
			
			//사용자 목록 페이지 네비의 시작점 종료점
			int start = 1;
			int end = aService.selectBoardCount();

			// 2. 페이징 처리 된 목록을 model 객체에 저장
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("list",list);
						
			map.put("pageNavi", pageNavi);
			map.put("currentPage",currentPage);			
			map.put("start",start);
			map.put("end",end);
						
			// 3. VIEW로 전송
			mav.addObject("map",map);				
			mav.setViewName("adminView/boardManage");
			return mav;
		}
	 }
	
	@RequestMapping(value="/admin/boardChange.do")
	public void boardChange(@RequestParam(value="dataArray[]")ArrayList<Integer> dataArray, @RequestParam String status, 
			HttpServletResponse response,HttpSession session ) throws IOException {
			//System.out.println(status.charAt(0));
			//System.out.println(dataArray);
			
			char newStatus = status.charAt(0);
			newStatus = Character.toUpperCase(newStatus);
			//System.out.println(newStatus);
			
			if(dataArray == null) {
			response.getWriter().print(false);
			
			}else {
			
			int sign = sChk.gradeChk(session);			
			if(sign == 1) {	
				HashMap<String, Object> map = new HashMap<String, Object>();		
				map.put("status",newStatus);
				map.put("boardNo",dataArray);
				int result = mService.updateBoardChange(map);
				
				//System.out.println(result);
				
				if(result == dataArray.size() ) {
				response.getWriter().print("pass");
				}else {
				response.getWriter().print("false");
				}
			  }else {
				 response.getWriter().print("false"); 
			  }
			}
		}

	@RequestMapping(value="/admin/boardSearch.do")
	public ModelAndView boardSearch (HttpServletRequest request, ModelAndView mav,@RequestParam int currentPage) {
		String tag = request.getParameter("tag");
		String keyword = request.getParameter("keyword");
		
		if ( tag == null || keyword == null ) {
			mav.addObject("msg","값을 입력해야 합니다");		
			mav.setViewName("adminView/alert");				
			return mav;
		}else {
			
		HashMap<String, String> findMap = new HashMap<String, String>();		
		findMap.put("keyword",keyword);
		findMap.put("tag",tag);		
		ArrayList<Board> list = aService.selectBoardSearch(findMap);
		
		HashMap<String, Object> map = new HashMap<String, Object>();		
		map.put("list", list);		
		map.put("currentPage", currentPage);
		
		mav.addObject("map",map);		
		mav.setViewName("adminView/boardManage");	
		return mav;	
		}
	 }
	
	
}
	