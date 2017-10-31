package com.hunangy.DbRes;

import java.util.Date;

public class ProbeDataRes {
	int probeDataId;			//探针数据ID
	String mac;					//Mac信息
	int  action;				//动作进店铺，出店铺，进探针范围，出探针范围
	Date time=null;					//时间
	int tc=1;						//目标ssid，手机连接的WIFI的ssid
	String essid;				//曾经连接过的WIFI的SSID
	String probeAttrbutesTable_probeAttrId ="";
	
	
	@Override
	public String toString() {
		return "PprobeDataRes [probeDataId=" + probeDataId + ", mac=" + mac
				+ ", action=" + action + ", time=" + time + ", tc=" + tc
				+ ", essid=" + essid + ", probeAttrbutesTable_probeAttrId="
				+ probeAttrbutesTable_probeAttrId + "]";
	}
	
	
	public ProbeDataRes(String mac, int action, String essid,
			String probeAttrbutesTable_probeAttrId) {
		super();
		this.mac = mac;
		this.action = action;
		this.time = time;
		this.essid = essid;
		this.probeAttrbutesTable_probeAttrId = probeAttrbutesTable_probeAttrId;
	}



	
	
	public ProbeDataRes(int probeDataId, String mac, int action, Date time) {
		super();
		this.probeDataId = probeDataId;
		this.mac = mac;
		this.action = action;
		this.time = time;
	}


	public ProbeDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProbeDataId() {
		return probeDataId;
	}
	public void setProbeDataId(int probeDataId) {
		this.probeDataId = probeDataId;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getTc() {
		return tc;
	}
	public void setTc(int tc) {
		this.tc = tc;
	}
	public String getEssid() {
		return essid;
	}
	public void setEssid(String essid) {
		this.essid = essid;
	}
	public String getProbeAttrbutesTable_probeAttrId() {
		return probeAttrbutesTable_probeAttrId;
	}
	public void setProbeAttrbutesTable_probeAttrId(
			String probeAttrbutesTable_probeAttrId) {
		this.probeAttrbutesTable_probeAttrId = probeAttrbutesTable_probeAttrId;
	}

}
