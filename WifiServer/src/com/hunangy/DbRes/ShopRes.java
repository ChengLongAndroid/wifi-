package com.hunangy.DbRes;

public class ShopRes {
	protected String shopId;
	protected String shopName;
	protected String shopAddr;
	protected double shopRang;
	protected String userTable_userAccount;

	public ShopRes(String shopId, String shopName, String shopAddr, double shopRang, String userTable_userAccount) {
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopAddr = shopAddr;
		this.shopRang = shopRang;
		this.userTable_userAccount = userTable_userAccount;
	}

	@Override
	public String toString() {
		return "ShopRes [shopId=" + shopId + ", shopName=" + shopName
				+ ", shopAddr=" + shopAddr + ", shopRang=" + shopRang
				+ ", userTable_userAccount=" + userTable_userAccount + "]";
	}

	public ShopRes() {

	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public double getShopRang() {
		return shopRang;
	}

	public void setShopRang(double shopRang) {
		this.shopRang = shopRang;
	}

	public String getUserTable_userAccount() {
		return userTable_userAccount;
	}

	public void setUserTable_userAccount(String userTable_userAccount) {
		this.userTable_userAccount = userTable_userAccount;
	}

}
