package com.javaex.vo;

public class UserVo {

	private int no;
	private String id;
	private String name;
	private String pw;
	private String gender;

	public UserVo() {
		super();
	}
	public UserVo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public UserVo(int no, String pw) {
		super();
		this.no = no;
		this.pw = pw;
	}
	public UserVo(String name, String pw, String gender) {
		super();
		this.name = name;
		this.pw = pw;
		this.gender = gender;
	}
	public UserVo(String id, String name, String pw, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.gender = gender;
	}
	public UserVo(int no, String id, String name, String pw, String gender) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.gender = gender;
	}

	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", pw=" + pw + ", gender=" + gender + "]";
	}
	
	
	

}