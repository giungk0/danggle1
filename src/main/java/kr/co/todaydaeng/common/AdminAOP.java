package kr.co.todaydaeng.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.todaydaeng.admin.model.vo.AdminVO;
import kr.co.todaydaeng.member.model.vo.Member;

@Aspect
@Component
public class AdminAOP {
	
	@Autowired
	private SHA256Util encrypt;
	
	@Autowired
	private StatusChk sChk;
	
	@Pointcut("execution(kr.co.todaydaeng.admin.model.vo.AdminVO kr.co.todaydaeng.admin.model.service.*ServiceImpl.selectAdminLogin(..) )")
	public void adminLoginPointcut() {}
	
	@Before ("adminLoginPointcut()")			
	public void adminLoginEncrypt (JoinPoint jp) throws Exception {				
		
		HashMap<String, String> map = (HashMap<String, String>)jp.getArgs()[0];
		
		String adminPWD = map.get("adminPWD");
		String adminID = map.get("adminID");

		String encrpt = encrypt.encryptionData(adminPWD, adminID);		
		
		map.put("adminPWD",encrpt);
		
	}
	
	@Pointcut("execution(int kr.co.todaydaeng.admin.model.service.*ServiceImpl.insertAdminAccount(..) )")
	public void adminJoinPointcut() {}
	
	@Before ("adminJoinPointcut()")
	public void adminJoinEncrypt (JoinPoint jp) throws Exception {
		
		AdminVO avo = (AdminVO)jp.getArgs()[0];
		String data = avo.getAdminPWD();
		String salt = avo.getAdminID();
		
		String encrpt = encrypt.encryptionData(data, salt);
		
		avo.setAdminPWD(encrpt);
	}
	
	
	@Pointcut("execution(int kr.co.todaydaeng.admin.model.service.*ServiceImpl.updateAdminPWD(..) )")
	public void pwdChangePointcut() {}
	
	@Before ("pwdChangePointcut()")
	public void pwdChangeEncrypt (JoinPoint jp) throws Exception {
		
		HashMap<String, String> map = (HashMap<String, String>)jp.getArgs()[0];
		
		//value 값이 object면 toString으로 형변환 했어야 함
		
		String salt = map.get("adminID");		
		String newPWD = map.get("newPWD");
		
		String encrptNew = encrypt.encryptionData(newPWD, salt);		
		
		map.put("newPWD",encrptNew);
	}
	

	


}
