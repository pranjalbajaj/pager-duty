package driver;

import java.util.ArrayList;
import java.util.List;

import api.TeamAPI;
import model.Developer;
import model.Team;

// driver class to call APIs

public class Driver {
	
	public static void main(String[] args) {
		
		//1. crete a team
		List<Developer> list = new ArrayList<Developer>();
		
		list.add(new Developer("Dev1", "Team1", "9999999999"));
		
		Team team = new Team("Team1", list);
		
		TeamAPI teamAPI = new TeamAPI();
		
		teamAPI.createTeam(team);
		
		//2. send alert
	}
}
