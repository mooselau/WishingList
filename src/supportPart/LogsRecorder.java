package supportPart;

public class LogsRecorder {
	
	/** GLOBAL VARIABLES */
	StringBuilder logInfo;
	
	/** Constrcutor */
	public LogsRecorder() {
		
		iniVariables();
	}
	
	/**
	 * Initiate all variables
	 */
	private void iniVariables() {
		logInfo = new StringBuilder("");
	}
	
	/**
	 * Receiving all logging info.
	 * @param logMsg the logging string.
	 */
	public void logReciever(String logMsg) {
		
		//format and record the log message..
		//..
	}
	
	/**
	 * Records the log info in a log file.
	 * 
	 */
	public void logRecords() {
		
		//..
		
	}
	
}
