package com.hunangy.DbRes;

public class UserRes {
	protected String userAccount;
	protected String username;
	protected String password;
	protected String probeAttrId=null;
	protected int rate=0;
	public int getRate() {
		return rate;
	}

	public UserRes(String userAccount, String username, String password,
			String probeAttrId, int rate) {
		super();
		this.userAccount = userAccount;
		this.username = username;
		this.password = password;
		this.probeAttrId = probeAttrId;
		this.rate = rate;
	}

	public UserRes(String userAccount, String username, String password,
			 int rate) {
		super();
		this.userAccount = userAccount;
		this.username = username;
		this.password = password;
		this.rate = rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getProbeAttrId() {
		return probeAttrId;
	}

	public void setProbeAttrId(String probeAttrId) {
		this.probeAttrId = probeAttrId;
	}

	public UserRes() {

	}

	public UserRes(String userAccount, String username, String passworld) {
		this.userAccount = userAccount;
		this.username = username;
		this.password = passworld;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "UserRes [userAccount=" + userAccount + ", username=" + username
				+ ", password=" + password + ", probeAttrId=" + probeAttrId
				+ ", rate=" + rate + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
