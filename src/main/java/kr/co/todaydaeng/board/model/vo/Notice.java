package kr.co.todaydaeng.board.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice {
	
	private int noticeNo;
	private String subject;
	private String content;
	private Date regDate;
	private int viewCount;
	private char delYN;
	private String noticePhoto;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int noticeNo, String subject, String content, Date regDate, int viewCount, char delYN,
			String noticePhoto) {
		super();
		this.noticeNo = noticeNo;
		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.delYN = delYN;
		this.noticePhoto = noticePhoto;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public String getRegDateString() {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		return format.format(regDate);
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public char getDelYN() {
		return delYN;
	}
	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}
	public String getNoticePhoto() {
		return noticePhoto;
	}
	public void setNoticePhoto(String noticePhoto) {
		this.noticePhoto = noticePhoto;
	}
	
	

}
