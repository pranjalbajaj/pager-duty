package dbconnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Connection {
	
	public abstract void createConnection() throws SQLException;
	
	public abstract java.sql.Connection getConnection() throws SQLException;
	
	public abstract boolean createTable(String tableName);
	
	public abstract ResultSet executeQuery(String query) throws SQLException;

	public abstract boolean executeUpdate(String query) throws SQLException;
}
