package com.ssafy.test.dto;

public class Board {
	private String ano;
	private String userid;
	private String issuedate;
	private String issue;
	public Board(String ano, String userid, String issuedate, String issue) {
		super();
		this.ano = ano;
		this.userid = userid;
		this.issuedate = issuedate;
		this.issue = issue;
	}
	public Board() {
		super();
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "Board [ano=" + ano + ", userid=" + userid + ", issuedate=" + issuedate + ", issue=" + issue + "]";
	}
	
	
}
