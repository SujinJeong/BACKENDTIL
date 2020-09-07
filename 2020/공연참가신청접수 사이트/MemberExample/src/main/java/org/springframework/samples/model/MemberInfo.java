package org.springframework.samples.model;

public class MemberInfo {

	private String email;
	private String name;
	private String password;
	private String phonenum;
	private Address address;	
	private String type;
	private String song;
	private int time; 
	private boolean isFirst;
	private String requirements;

	public String getRequirements() {
		return requirements;
	}


	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}


	public String getPhonenum() {
		return phonenum;
	}


	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSong() {
		return song;
	}


	public void setSong(String song) {
		this.song = song;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public boolean getIsFirst() {
		return isFirst;
	}


	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}


	public String getEmail() {
		return email;
	}


	public String getName() {
		return name;
	}


	public Address getAddress() {
		return address;
	}


	public MemberInfo() {
	}

	public MemberInfo(String email, String name, String password, String phonenum, Address address, String type,
			String song, int time, boolean isFirst, String requirements) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phonenum = phonenum;
		this.address = address;
		this.type = type;
		this.song = song;
		this.time = time;
		this.isFirst = isFirst;
		this.requirements = requirements;
	}
}
