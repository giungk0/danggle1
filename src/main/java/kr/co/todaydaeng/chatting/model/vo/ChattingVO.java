package kr.co.todaydaeng.chatting.model.vo;

import java.sql.Date;

public class ChattingVO {

	private int no;
	private int room;
	private String writer;
	private String send_nick;
	private String recv_nick;
	private Date send_time;
	private Date read_time;
	private String content;
	private int read_chk;
	
	//메세지 상대 nick
	private String other_nick;
	
	//메세지 상대 profile
	private String profile;
	
	//현재 사용자 nick
	private String nick;
	
	//안읽은 메세지 갯수
	private int unread;

	
	
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSend_nick() {
		return send_nick;
	}

	public void setSend_nick(String send_nick) {
		this.send_nick = send_nick;
	}

	public String getRecv_nick() {
		return recv_nick;
	}

	public void setRecv_nick(String recv_nick) {
		this.recv_nick = recv_nick;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public Date getRead_time() {
		return read_time;
	}

	public void setRead_time(Date read_time) {
		this.read_time = read_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRead_chk() {
		return read_chk;
	}

	public void setRead_chk(int read_chk) {
		this.read_chk = read_chk;
	}

	public String getOther_nick() {
		return other_nick;
	}

	public void setOther_nick(String other_nick) {
		this.other_nick = other_nick;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}

	public ChattingVO(int no, int room, String writer, String send_nick, String recv_nick, Date send_time,
			Date read_time, String content, int read_chk, String other_nick, String profile, String nick, int unread) {
		super();
		this.no = no;
		this.room = room;
		this.writer = writer;
		this.send_nick = send_nick;
		this.recv_nick = recv_nick;
		this.send_time = send_time;
		this.read_time = read_time;
		this.content = content;
		this.read_chk = read_chk;
		this.other_nick = other_nick;
		this.profile = profile;
		this.nick = nick;
		this.unread = unread;
	}

	public ChattingVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ChattingVO [no=" + no + ", room=" + room + ", writer=" + writer + ", send_nick=" + send_nick
				+ ", recv_nick=" + recv_nick + ", send_time=" + send_time + ", read_time=" + read_time + ", content="
				+ content + ", read_chk=" + read_chk + ", other_nick=" + other_nick + ", profile=" + profile + ", nick="
				+ nick + ", unread=" + unread + "]";
	}
	
	
	
	
	
	
	
}
