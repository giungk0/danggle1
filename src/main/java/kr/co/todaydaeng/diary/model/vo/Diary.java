package kr.co.todaydaeng.diary.model.vo;

import java.sql.Date;

public class Diary {

	private int diaryNo;
	private int dogNo;
	private int memberNo;
	private String weight;
	private String feedName;
	private char feedType;
	private String feedAmount;
	private String waterAmount;
	private char healthFoodYN;
	private char snackYN;
	private String walk;
	private String memo;
	private String scheduleDate;
	private Date regDate;
	
	private String year;
	private String month;
	private String date;

	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diary(int diaryNo, int dogNo, int memberNo, String weight, String feedName, char feedType, String feedAmount,
			String waterAmount, char healthFoodYN, char snackYN, String walk, String memo, String scheduleDate,
			Date regDate) {
		super();
		this.diaryNo = diaryNo;
		this.dogNo = dogNo;
		this.memberNo = memberNo;
		this.weight = weight;
		this.feedName = feedName;
		this.feedType = feedType;
		this.feedAmount = feedAmount;
		this.waterAmount = waterAmount;
		this.healthFoodYN = healthFoodYN;
		this.snackYN = snackYN;
		this.walk = walk;
		this.memo = memo;
		this.scheduleDate = scheduleDate;
		this.regDate = regDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public int getDogNo() {
		return dogNo;
	}

	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public char getFeedType() {
		return feedType;
	}

	public void setFeedType(char feedType) {
		this.feedType = feedType;
	}

	public String getFeedAmount() {
		return feedAmount;
	}

	public void setFeedAmount(String feedAmount) {
		this.feedAmount = feedAmount;
	}

	public String getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(String waterAmount) {
		this.waterAmount = waterAmount;
	}

	public char getHealthFoodYN() {
		return healthFoodYN;
	}

	public void setHealthFoodYN(char healthFoodYN) {
		this.healthFoodYN = healthFoodYN;
	}

	public char getSnackYN() {
		return snackYN;
	}

	public void setSnackYN(char snackYN) {
		this.snackYN = snackYN;
	}

	public String getWalk() {
		return walk;
	}

	public void setWalk(String walk) {
		this.walk = walk;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", dogNo=" + dogNo + ", memberNo=" + memberNo + ", weight=" + weight
				+ ", feedName=" + feedName + ", feedType=" + feedType + ", feedAmount=" + feedAmount + ", waterAmount="
				+ waterAmount + ", healthFoodYN=" + healthFoodYN + ", snackYN=" + snackYN + ", walk=" + walk + ", memo="
				+ memo + ", scheduleDate=" + scheduleDate + ", regDate=" + regDate + "]";
	}

}
