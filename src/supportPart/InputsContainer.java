package supportPart;

import java.util.HashMap;

/**
 * This class is for saving inputs when view changes between one and another.
 * @author MooseLiu
 *
 */
public class InputsContainer {
	
	/** GLOBAL VARIABLES */
	
	HashMap<String, String> container;
	
	/** Constructor */
	public InputsContainer() {
		
		initVariables();
	}
	
	/**
	 * Initialize variables.
	 */
	private void initVariables() {
		
		container = new HashMap<String, String>();
	}
	
	/**
	 * Push input field and the value into the container.
	 * @param fieldName
	 * @param fieldValue
	 */
	public void pushInput(String fieldName, String fieldValue) {
		
		container.put(fieldName, fieldValue);
	}
	
	/**
	 * Get the input value with the given input field name.
	 * @param fieldName
	 * @return the input value and input field info will still in the container.
	 */
	public String pullInputValue(String fieldName) {
		
		String result = container.get(fieldName);
		return result;
	}
	
}
