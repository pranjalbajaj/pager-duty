package api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dbconnection.Connection;
import dbconnection.MysqlConnection;
import errorinfo.ErrorMap;
import model.Developer;

public class NotificationAPI {
	
	public void recieveAlert(String teamId) throws SQLException {
		
		List<Developer> devList = new ArrayList<Developer>();
		
		ResultSet rs = getAllDevelopersFromTeam(teamId);
		
		while (rs.next()) {
			
			Developer developer = new Developer(rs.getString(2), "", rs.getString(4));
			
			devList.add(developer);
		}
		
		int randomId = this.getRandomDevId(0, devList.size());
		
		sendAlert(devList.get(randomId).getContactNum());
	}

	private void sendAlert(String contactNum) {
		
		System.out.println("alert has been sent to " + contactNum);
	}

	private ResultSet getAllDevelopersFromTeam(String teamId) throws SQLException {
		
		ResultSet rs = null;
		
		try {
			
			Connection connection = new MysqlConnection();
			
			String query = this.getDevelopersQuery(teamId);
			
			rs = connection.executeQuery(query);
		}
		catch(Exception e) {
			
			throw new SQLException(ErrorMap.errorMap.get(ErrorMap.FAILED_TO_FETCH_RECORDS));
		}
		
		return rs;
	}
	
	private int getRandomDevId(int min, int max) {
		
		Random random = new Random();
		
		return min + random.nextInt(max);
	}
	
	private String getDevelopersQuery(String teamId) {
		
		StringBuilder query = new StringBuilder("SELECT * FROM DEVELOPERS WHERE TEAMID = " + teamId);
		
		return query.toString();
	}
}
