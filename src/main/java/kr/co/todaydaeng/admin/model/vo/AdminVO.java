package kr.co.todaydaeng.admin.model.vo;

import java.sql.Date;

public class AdminVO {

	private int adminNo;
	private String adminID;
	private String adminPWD;
	private String adminName;
	private String adminEmail;
	private String adminGrade;
	private Date adminDate;
	
	public AdminVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminVO(int adminNo, String adminID, String adminPWD, String adminName, String adminEmail, String adminGrade,
			Date adminDate) {
		super();
		this.adminNo = adminNo;
		this.adminID = adminID;
		this.adminPWD = adminPWD;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminGrade = adminGrade;
		this.adminDate = adminDate;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPWD() {
		return adminPWD;
	}

	public void setAdminPWD(String adminPWD) {
		this.adminPWD = adminPWD;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminGrade() {
		return adminGrade;
	}

	public void setAdminGrade(String adminGrade) {
		this.adminGrade = adminGrade;
	}

	public Date getAdminDate() {
		return adminDate;
	}

	public void setAdminDate(Date adminDate) {
		this.adminDate = adminDate;
	}

	@Override
	public String toString() {
		return "AdminVO [adminNo=" + adminNo + ", adminID=" + adminID + ", adminPWD=" + adminPWD + ", adminName="
				+ adminName + ", adminEmail=" + adminEmail + ", adminGrade=" + adminGrade + ", adminDate=" + adminDate
				+ "]";
	}	
	
	
}
