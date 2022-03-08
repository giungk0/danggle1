package kr.co.todaydaeng.myPage.model.vo;

public class Dog {

	private int dogNo;
	private int memberNo;
	private String dogName;
	private char gender;
	private String breed;
	private String dogSize;
	private char neutralizationYN;
	private String vaccinationYN;
	private String birthdate;
	private String dogProfile;
	private char delYN;

	public Dog() {
		super();
	}

	public Dog(int dogNo, int memberNo, String dogName, char gender, String breed, String dogSize,
			char neutralizationYN, String vaccinationYN, String birthdate, String dogProfile, char delYN) {
		super();
		this.dogNo = dogNo;
		this.memberNo = memberNo;
		this.dogName = dogName;
		this.gender = gender;
		this.breed = breed;
		this.dogSize = dogSize;
		this.neutralizationYN = neutralizationYN;
		this.vaccinationYN = vaccinationYN;
		this.birthdate = birthdate;
		this.dogProfile = dogProfile;
		this.delYN = delYN;
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

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDogSize() {
		return dogSize;
	}

	public void setDogSize(String dogSize) {
		this.dogSize = dogSize;
	}

	public char getNeutralizationYN() {
		return neutralizationYN;
	}

	public void setNeutralizationYN(char neutralizationYN) {
		this.neutralizationYN = neutralizationYN;
	}

	public String getVaccinationYN() {
		return vaccinationYN;
	}

	public void setVaccinationYN(String vaccinationYN) {
		this.vaccinationYN = vaccinationYN;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getDogProfile() {
		return dogProfile;
	}

	public void setDogProfile(String dogProfile) {
		this.dogProfile = dogProfile;
	}

	public char getDelYN() {
		return delYN;
	}

	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}

	@Override
	public String toString() {
		return "Dog [dogNo=" + dogNo + ", memberNo=" + memberNo + ", dogName=" + dogName + ", gender=" + gender
				+ ", breed=" + breed + ", dogSize=" + dogSize + ", neutralizationYN=" + neutralizationYN
				+ ", vaccinationYN=" + vaccinationYN + ", birthdate=" + birthdate + ", dogProfile=" + dogProfile
				+ ", delYN=" + delYN + "]";
	}

}
