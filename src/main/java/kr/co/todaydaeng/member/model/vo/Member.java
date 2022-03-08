package kr.co.todaydaeng.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String authProvider;
	private String nickname;
	private String gender;
	private String birthdate;
	private String email;
	private String address;
	private String addressDetail;
	private Date enrollDate;
	private char memberStatus;
	private char dogYN;
	private String memberProfile;
	
	public Member() {
		super();
	}

	public Member(int memberNo, String memberId, String memberPwd, String authProvider, String nickname, String gender,
			String birthdate, String email, String address, String addressDetail, Date enrollDate, char memberStatus,
			char dogYN, String memberProfile) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.authProvider = authProvider;
		this.nickname = nickname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.email = email;
		this.address = address;
		this.addressDetail = addressDetail;
		this.enrollDate = enrollDate;
		this.memberStatus = memberStatus;
		this.dogYN = dogYN;
		this.memberProfile = memberProfile;
	}

	public Member(String memberId, String memberPwd, String email, String nickname, String gender,
			String birthdate, String address, String addressDetail, String memberProfile) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.nickname = nickname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.email = email;
		this.address = address;
		this.addressDetail = addressDetail;
		this.memberProfile = memberProfile;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getAuthProvider() {
		return authProvider;
	}

	public void setAuthProvider(String authProvider) {
		this.authProvider = authProvider;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(char memberStatus) {
		this.memberStatus = memberStatus;
	}

	public char getDogYN() {
		return dogYN;
	}

	public void setDogYN(char dogYN) {
		this.dogYN = dogYN;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo 
				+ ", memberId=" + memberId 
				+ ", memberPwd=" + memberPwd
				+ ", authProvider=" + authProvider 
				+ ", nickname=" + nickname 
				+ ", gender=" + gender 
				+ ", birthdate="+ birthdate 
				+ ", email=" + email 
				+ ", address=" + address
				+ ", addressDetail=" + addressDetail
				+ ", enrollDate=" + enrollDate 
				+ ", memberStatus=" + memberStatus 
				+ ", dogYN=" + dogYN
				+ ", memberProfile=" + memberProfile 
				+ "]";
	}
}
