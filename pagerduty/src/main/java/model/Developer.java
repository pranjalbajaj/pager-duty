package model;

import utility.Utility;

public class Developer {

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	// developer id
	private String devId;
	
	// developer name
	private String devName;
	
	//team id for developer
	private String teamId;
	
	//phone num
	private String contactNum;
	
	public Developer(String name, String teamId, String contact) {
		
		this.devName = name;
		
		this.teamId = teamId;
		
		this.contactNum = contact;
		
		//this.devId = Utility.getUniqueId();
	}
}
