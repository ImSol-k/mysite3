package com.javaex.vo;

public class BoardVo {
	
	private int no;
	private int hit;	//조회수
	private String title;
	private String content;
	private String date;
	private int userNo;
	private String id;
	private String pw;
	private String name;
	private String gender;
	
	
	public BoardVo() {
	}
	public BoardVo(String title) {
		this.id = title;
	}
	
	public BoardVo(int hit, String title, String content, String date, String name) {
		super();
		this.hit = hit;
		this.title = title;
		this.content = content;
		this.date = date;
		this.name = name;
	}
	public BoardVo(String title, String content, int userNo) {
		super();
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}
	public BoardVo(int no, int hit, String content, String date, int userNo, String name) {
		this.no = no;
		this.hit = hit;
		this.content = content;
		this.date = date;
		this.userNo = userNo;
		this.name = name;
	}
	public BoardVo(int no, int hit, String title, String content, String date, int userNo, String name, String id) {
		this.no = no;
		this.hit = hit;
		this.title = title;
		this.content = content;
		this.date = date;
		this.userNo = userNo;
		this.name = name;
		this.id = id;
	}
	public BoardVo(int no, int hit, String title, String content, String date, int userNo, String id, String pw,
			String name, String gender) {
		this.no = no;
		this.hit = hit;
		this.title = title;
		this.content = content;
		this.date = date;
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", hit=" + hit + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", userNo=" + userNo + ", id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + "]";
	}	
	
	
}
