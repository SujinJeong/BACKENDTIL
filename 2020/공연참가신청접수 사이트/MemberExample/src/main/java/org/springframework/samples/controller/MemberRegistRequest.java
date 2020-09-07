package org.springframework.samples.controller;

import java.util.Date;

import org.springframework.samples.model.Address;

public class MemberRegistRequest {
	private String name;
	private Address address;
	private String email;
	private String password;
	private String confirmPassword;
	private boolean isFirst;
	private String phonenum;
	private String song;
	private String type;
	private String time;
	private Date regTime;
	private String requirements;
	
	public String getRequirements() {
		return requirements;
	}


	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	
	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// 암호와 암호확인 같은지 확인하기 위한 method
	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	// 암호가 입력 되었는지 확인하기위한 method
	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}

	@Override
	public String toString() {
		return "MemberRegistRequest [name=" + name + ", address=" + address + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", isFirst=" + isFirst + ", song="
				+ song + ", type=" + type +", phonenum=" + phonenum + ", requirements=" + requirements + ", regTime=" + regTime + "]";
	}


	public MemberRegistRequest() {
		
	}
	
	public MemberRegistRequest(String name, Address address, String email, String password, String confirmPassword,
			boolean isFirst, String phonenum, String song, String type, String time, Date regTime, String requirements) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.isFirst = isFirst;
		this.phonenum = phonenum;
		this.song = song;
		this.type = type;
		this.time = time;
		this.regTime = regTime;
		this.requirements = requirements;
	}
}
