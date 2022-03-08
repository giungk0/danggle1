package kr.co.todaydaeng.member.model.vo;

import java.sql.Date;

public class EmailAuthHist {
	private int memberNo;
	private Date sendDate;
	private String email;
	private String randomNo;
	
	public EmailAuthHist() {
		super();
	}
	
	public EmailAuthHist(int memberNo, Date sendDate, String email, String randomNo) {
		super();
		this.memberNo = memberNo;
		this.sendDate = sendDate;
		this.email = email;
		this.randomNo = randomNo;
	}

	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRandomNo() {
		return randomNo;
	}
	public void setRandomNo(String randomNo) {
		this.randomNo = randomNo;
	}
	@Override
	public String toString() {
		return "EmailAuthHist [memberNo=" + memberNo + ", sendDate=" + sendDate + ", email=" + email + ", randomNo="
				+ randomNo + "]";
	}
}
