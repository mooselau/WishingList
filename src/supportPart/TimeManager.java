package supportPart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeManager {
	
	/** GLOBAL VARIABLES */
	Calendar calendar;
	DateFormat fullDateTimeFormat;
	DateFormat onlyDateFormat;
	
	/** Constructor */
	public TimeManager() {
		
		iniVariables();
	}
	
	/** Initialise all necessary variables */
	private void iniVariables() {
		
		//initialise a Calendar instance.
		calendar = Calendar.getInstance();
		//define two formatters for different uses.
		fullDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		onlyDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	/**
	 * Get current date.
	 * @return A String contains Date type value.
	 */
	public String getCurrentDate() {
		Date date = calendar.getTime();
		return onlyDateFormat.format(date);
	}
	
	/**
	 * Get current date and time.
	 * @return A String contains Date type value.
	 */
	public String getCurrentDateAndTime() {
		Date date = calendar.getTime();
		return fullDateTimeFormat.format(date);
	}
	
}
