package com.ssafy.car.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private String birth;

	public User(String id, String password, String name, String birth) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
	}

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth + "]";
	}

}
