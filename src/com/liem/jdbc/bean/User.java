package com.liem.jdbc.bean;

import com.liem.jdbc.annotation.MTable;



@MTable("sys_user")
public class User extends BaseModel{

	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", getId()=" + getId() + ", getState()="
				+ getState() + ", getMemo()=" + getMemo() + ", getCreateTime()=" + getCreateTime()
				+ ", getUpdateTime()=" + getUpdateTime() + "]";
	}
	
	
 
	
	
	
	
	
	
	
	
	
}
