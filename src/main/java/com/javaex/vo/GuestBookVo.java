package com.javaex.vo;

public class GuestBookVo {
	
	private int no;
	private String id;
	private String name;
	private String pw;
	private String content;
	
	
	
	public GuestBookVo() {
	}
	public GuestBookVo(String pw) {
		this.pw = pw;
	}
	public GuestBookVo(String name, String pw, String content) {
		this.name = name;
		this.pw = pw;
		this.content = content;
	}
	public GuestBookVo(int no, String id, String pw, String content) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", id=" + id + ", name=" + name + ", pw=" + pw + ", content=" + content + "]";
	}
	
	
}
