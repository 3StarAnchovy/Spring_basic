package com.ssafy.test.dto;

public class Detail {
	private String ano;
	private String userid;
	private String issuedate;
	private String issue;
	private String name;
	private String rname;
	private String rclass;

	public Detail(String ano, String userid, String issuedate, String issue, String name, String rname, String rclass) {
		super();
		this.ano = ano;
		this.userid = userid;
		this.issuedate = issuedate;
		this.issue = issue;
		this.name = name;
		this.rname = rname;
		this.rclass = rclass;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRclass() {
		return rclass;
	}

	public void setRclass(String rclass) {
		this.rclass = rclass;
	}

	@Override
	public String toString() {
		return "Detail [ano=" + ano + ", userid=" + userid + ", issuedate=" + issuedate + ", issue=" + issue + ", name="
				+ name + ", rname=" + rname + ", rclass=" + rclass + "]";
	}

	public Detail() {
		super();
	}

}
