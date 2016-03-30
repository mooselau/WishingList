package mainPart;

public class WishItem {
	
	/** Global Variables */
	private String name, notes;
	private int completion;
	
	
	/** Constructor */
	public WishItem() {
		name = "";
		notes = "";
		completion = 0;
	}
	
	public WishItem(String na, int comp) {
		this.name = na;
		this.completion = comp;
	}
	
	public WishItem(String na, int comp, String not) {
		this.name = na;
		this.completion = comp;
		this.notes = not;
	}

	// Getters and Setters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCompletion() {
		return completion;
	}
	
	public String getCompletionAsString() {
		return String.valueOf(completion);
	}

	public void setCompletion(int completion) {
		this.completion = completion;
	}
	
}
