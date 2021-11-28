package utility;

import java.util.UUID;

public class Utility {

	public static String getUniqueId() {

		String uniqueID = UUID.randomUUID().toString();

		return uniqueID;
	}
}
