package api;

import java.sql.SQLException;

import dbconnection.Connection;
import dbconnection.MysqlConnection;
import model.Developer;
import model.Team;

public class TeamAPI {
	
	public boolean createTeam(Team team) {

		try {
			Connection connection = new MysqlConnection();
			
			insertTeamInfo(team, connection);
			
			for (Developer developer : team.getTeamDevelopersList()) {
				
				insertDevInfo(team.getTeamId(), developer, connection);
			}
			
		} catch (SQLException e) {
			
			return false;
		}
		catch (Exception e) {
			
		}
		
		return true;
	}
	
	private void insertTeamInfo(Team team, Connection connection) throws SQLException {
		
		String teamId = team.getTeamId();
		
		String teamName = team.getTeamName();
		
		String insertTeamQuery = this.getInsertQueryForTeams(teamId, teamName);
		
		boolean isInsertSuccessfull = connection.executeUpdate(insertTeamQuery);
		
		if (isInsertSuccessfull)
			System.out.println("Team information inserted successfully");
	}
	
	private String getInsertQueryForDeveloper(String teamId, String devId, String devName,
			String devContact) {
		
		StringBuilder query =
				new StringBuilder("INSERT INTO DEVELOPERS (TEAMID, DEVID, DEVNAME, DEVCONTACT) VALUES (");
		
		query.append(teamId).append(",");
		query.append(devId).append(",");
		query.append(devName).append(",");
		query.append(devContact).append(")");
		
		return query.toString();
	}

	private void insertDevInfo(String teamId, Developer developer, Connection connection) throws SQLException {
		
		String devId = developer.getDevId();
		
		String devName = developer.getDevName();
		
		String devContact = developer.getContactNum();
		
		String insertDevQuery = this.getInsertQueryForDeveloper(teamId, devId, devName, devContact);
		
		boolean insertDevSuccessfull = connection.executeUpdate(insertDevQuery);
		
		if (insertDevSuccessfull)
			System.out.println("Developer information inserted successfully");
	}
	
	private String getInsertQueryForTeams(String teamId, String teamName) {
		
		StringBuilder query = new StringBuilder("INSERT INTO TEAMS (TEAMID, TEAMNAME) VALUES (");
		
		query.append(teamId).append(",");
		query.append(teamName).append(")");
		
		return query.toString();
	}
}
