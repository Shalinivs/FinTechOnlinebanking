package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log {
	
	private static final Logger loghelp=LogManager.getLogger(Log.class);
	
	
	 public static void info(String message) 
	 {
	        loghelp.info(message);
	  }
	 
	 public static void warn(String message)
	 {
		 loghelp.warn(message);
	 }
	 
	 public static void error(String message)
	 {
		 loghelp.error(message);
	 }
	 
	 public static void debug(String message)
	 {
		 loghelp.debug(message);
	 }


}
