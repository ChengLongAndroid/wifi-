package com.hunangy.DbRes;

public class ProbeAttrRes {
	protected String probeAttrId;
	protected String mmac;
	protected int rate;
	protected double lat;
	protected double lon;
	protected String probeAddr;
	protected String userTable_userAccount;
	protected String shopTable_shopId;

	public ProbeAttrRes(String probeAttrId, String mmac, int rate, double lat, double lon, String probeAddr,
			String userTable_userAccount, String shopTable_shopId) {
		this.probeAttrId = probeAttrId;
		this.mmac = mmac;
		this.rate = rate;
		this.lat = lat;
		this.lon = lon;
		this.probeAddr = probeAddr;
		this.userTable_userAccount = userTable_userAccount;
		this.shopTable_shopId = shopTable_shopId;
	}
	

	@Override
	public String toString() {
		return "ProbeAttrRes [probeAttrId=" + probeAttrId + ", mmac=" + mmac
				+ ", rate=" + rate + ", lat=" + lat + ", lon=" + lon
				+ ", probeAddr=" + probeAddr + ", userTable_userAccount="
				+ userTable_userAccount + ", shopTable_shopId="
				+ shopTable_shopId + "]";
	}


	public ProbeAttrRes() {

	}

	public String getProbeAttrId() {
		return probeAttrId;
	}

	public void setProbeAttrId(String probeAttrId) {
		this.probeAttrId = probeAttrId;
	}

	public String getMmac() {
		return mmac;
	}

	public void setMmac(String mmac) {
		this.mmac = mmac;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getProbeAddr() {
		return probeAddr;
	}

	public void setProbeAddr(String probeAddr) {
		this.probeAddr = probeAddr;
	}

	public String getUserTable_userAccount() {
		return userTable_userAccount;
	}

	public void setUserTable_userAccount(String userTable_userAccount) {
		this.userTable_userAccount = userTable_userAccount;
	}

	public String getShopTable_shopId() {
		return shopTable_shopId;
	}

	public void setShopTable_shopId(String shopTable_shopId) {
		this.shopTable_shopId = shopTable_shopId;
	}

}
