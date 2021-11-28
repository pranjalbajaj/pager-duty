package model;

import java.util.List;

import utility.Utility;

public class Team {

	// teamid
	private String teamId;
	
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Developer> getTeamDevelopersList() {
		return teamDevelopersList;
	}

	public void setTeamDevelopersList(List<Developer> teamDevelopersList) {
		this.teamDevelopersList = teamDevelopersList;
	}

	// team name
	private String teamName;
	
	// list of developers associated with team
	private List<Developer> teamDevelopersList;
	
	public Team(String name, List<Developer> developers) {
		
		this.teamName = name;
		
		this.teamDevelopersList = developers;
		
		//this.teamId = Utility.getUniqueId();
	}
}
