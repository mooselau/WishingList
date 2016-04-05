package mainPart;

import java.util.Date;

public class WishItem {
	
	/** Global Variables */
	private String name, notes, costType;
	private String creatingDate, expEndDate;
	private int completion, totalCost, totalEfforts;
	
	
	/** Constructor */
	public WishItem() {
	}
	
	public WishItem(String na, String costType, int totalCost, String creatingDa) {
		this.name = na;
		this.costType = costType;
		this.totalCost = totalCost;
		this.creatingDate = creatingDa;
		this.expEndDate = "unlimited";
	}
	
	public WishItem(String na, String costType, int totalCost, String creatingDa, String expEndDa, String descrip) {
		this.name = na;
		this.costType = costType;
		this.totalCost = totalCost;
		this.creatingDate = creatingDa;
		this.expEndDate = expEndDa;
		this.notes = descrip;
	}
	
	// Temporally use
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
