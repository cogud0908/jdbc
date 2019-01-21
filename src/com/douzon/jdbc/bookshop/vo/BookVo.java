package com.douzon.jdbc.bookshop.vo;

public class BookVo {
	private long no;
	private String title;
	private String status;
	private long authorNo;
	private String authorName;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(long authorNo) {
		this.authorNo = authorNo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "["+no+"]책제목 : " + title + ", 대여 여부 : " + status + ", 작가 이름 : " + authorName;
	}
}
