package kr.co.todaydaeng.board.model.vo;

import java.util.Date;

public class Comment {

	private int commentNo;
	private int boardNo;
	private int memberNo;
	private String bComment;
	private Date regDate;
	private char delYN;
	private String memberId;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentNo, int boardNo, int memberNo, String bComment, Date regDate, char delYN, String memberId) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.bComment = bComment;
		this.regDate = regDate;
		this.delYN = delYN;
		this.memberId = memberId;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
	public String getbComment() {
		return bComment;
	}
	public void setbComment(String bComment) {
		this.bComment = bComment;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public char getDelYN() {
		return delYN;
	}
	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
//<<<<<<< HEAD
//}
//=======
}
//>>>>>>> 4cf2926bae90cd94425735eec0245dc3e29bc714
