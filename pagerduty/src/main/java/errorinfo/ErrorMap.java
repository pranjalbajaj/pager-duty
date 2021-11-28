package errorinfo;

import java.util.HashMap;

public class ErrorMap {
	
	public static HashMap<Integer, String> errorMap = new HashMap<Integer, String>();
	
	public final static int FAILED_CREATE_CONNECTION = 1;
	
	public final static int FAILED_LOAD_DRIVER = 2;
	
	public final static int FAILED_TO_INSERT_RECORDS = 3;
	
	public final static int FAILED_TO_FETCH_RECORDS = 4;
	
	static {
		
		errorMap.put(FAILED_CREATE_CONNECTION, "Failed to connect to database");
		errorMap.put(FAILED_LOAD_DRIVER, "Failed to load driver for database");
		errorMap.put(FAILED_TO_INSERT_RECORDS, "Failed to insert records into database");
		
		errorMap.put(FAILED_TO_FETCH_RECORDS, "Failed to fetch records from database");
	}
}
