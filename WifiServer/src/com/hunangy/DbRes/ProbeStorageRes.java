package com.hunangy.DbRes;

import java.util.Date;

public class ProbeStorageRes {
	protected String probeStorageId;
	protected Date startTime;
	protected Date endTime=null;
	protected String serverIp;
	protected int serverPost;
	protected String probeAttributesTable_probeAttrId;

	public ProbeStorageRes(String probeStorageId, Date startTime, String serverIp, int serverPost,String probeAttributesTable_probeAttrId) {
		this.probeStorageId = probeStorageId;
		this.startTime = startTime;
		
		this.serverIp = serverIp;
		this.serverPost = serverPost;
		this.probeAttributesTable_probeAttrId = probeAttributesTable_probeAttrId;
	}

	
	public ProbeStorageRes(String probeStorageId, Date startTime, Date endTime,
			String serverIp, int serverPost,
			String probeAttributesTable_probeAttrId) {
		super();
		this.probeStorageId = probeStorageId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.serverIp = serverIp;
		this.serverPost = serverPost;
		this.probeAttributesTable_probeAttrId = probeAttributesTable_probeAttrId;
	}


	@Override
	public String toString() {
		return "ProbeStorageRes [probeStorageId=" + probeStorageId
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", serverIp=" + serverIp + ", serverPost=" + serverPost
				+ ", probeAttributesTable_probeAttrId="
				+ probeAttributesTable_probeAttrId + "]";
	}

	public ProbeStorageRes() {

	}

	public String getProbeStorageId() {
		return probeStorageId;
	}

	public void setProbeStorageId(String probeStorageId) {
		this.probeStorageId = probeStorageId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public int getServerPost() {
		return serverPost;
	}

	public void setServerPost(int serverPost) {
		this.serverPost = serverPost;
	}

	public String getProbeAttributesTable_probeAttrId() {
		return probeAttributesTable_probeAttrId;
	}

	public void setProbeAttributesTable_probeAttrId(String probeAttributesTable_probeAttrId) {
		this.probeAttributesTable_probeAttrId = probeAttributesTable_probeAttrId;
	}

}
