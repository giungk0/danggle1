package kr.co.todaydaeng.common;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import kr.co.todaydaeng.admin.model.vo.AdminVO;

@Component
public class StatusChk {
	
public int gradeChk(HttpSession session){
		// return 경우의 수는 "S,B,C,"	
	AdminVO chkIn = (AdminVO) session.getAttribute("adminVO");
	String grade = chkIn.getAdminGrade();
	char chk = grade.charAt(0);
	//System.out.println( chk == 'S' );
	int sign = 0;	
	if( (chk == 'S') || (chk == 'B') ) {
		sign = 1;
		return sign;
	}		
		return sign;
  }



}
