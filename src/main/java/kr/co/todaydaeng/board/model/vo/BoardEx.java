package kr.co.todaydaeng.board.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardEx {

	private int boardNo;
	private int memberNo;
	private String subject;
	private String content;
	private Date regDate;
	private int viewCount;
	private char delYN;
	private String boardPhoto;
	private String memberId;
	
	public BoardEx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardEx(int boardNo, int memberNo, String subject, String content, Date regDate, int viewCount, char delYN,
			String boardPhoto, String memberId) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.delYN = delYN;
		this.boardPhoto = boardPhoto;
		this.memberId = memberId;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRegDateString() {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		return format.format(regDate);
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
	public String getBoardPhoto() {
		return boardPhoto;
	}
	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
