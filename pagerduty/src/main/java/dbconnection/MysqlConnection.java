package dbconnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.ResolveResult;
import javax.security.auth.login.FailedLoginException;

import errorinfo.ErrorMap;

public class MysqlConnection extends Connection {
	
	private java.sql.Connection connection;
	
	public MysqlConnection() throws Exception {
		
		initDriver();
	}
	
	private void initDriver() throws Exception {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			
			throw new Exception(ErrorMap.errorMap.get(ErrorMap.FAILED_LOAD_DRIVER));
		}
	}

	@Override
	public void createConnection() throws SQLException {
		
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (SQLException e) {
			
			throw new SQLException(ErrorMap.errorMap.get(ErrorMap.FAILED_CREATE_CONNECTION));
		}
	}

	@Override
	public java.sql.Connection getConnection() throws SQLException {
		
		if (this.connection == null)
			createConnection();
		
		return connection;
	}

	@Override
	public boolean createTable(String tableName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executeUpdate(String query) throws SQLException {
		
		Statement stmt;
		try {
			stmt = this.connection.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			new SQLException(ErrorMap.errorMap.get(ErrorMap.FAILED_TO_INSERT_RECORDS));
		}
		
		return true;
	}

	@Override
	public ResultSet executeQuery(String query) throws SQLException {
		
		Statement stmt;
		
		ResultSet rs = null;
		
		try {
			stmt = this.connection.createStatement();
			
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {
			
			new SQLException(ErrorMap.errorMap.get(ErrorMap.FAILED_TO_INSERT_RECORDS));
		}
		
		return rs;
	}
	
	
}
