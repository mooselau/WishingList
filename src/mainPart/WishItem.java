package mainPart;

import java.util.Date;

public class WishItem {
	
	/** Global Variables */
	private String name, notes, costType, wishType;
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
		this.wishType = "General";
	}
	
	public WishItem(String na, String wishType, String costType, int totalCost, String creatingDa, String expEndDa, String descrip) {
		this.name = na;
		this.wishType = wishType;
		this.costType = costType;
		this.totalCost = totalCost;
		this.creatingDate = creatingDa;
		this.expEndDate = expEndDa;
		this.notes = descrip;
	}
	
	// Temporally use
	public WishItem(String na, int comp) {
		this.name = na;
		this.wishType = "General";
		this.completion = comp;
	}
	
	public WishItem(String na, int comp, String not) {
		this.name = na;
		this.wishType = "Special";
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
	
	public String getWishType() {
		return wishType;
	}

	public void setWishType(String wishType) {
		this.wishType = wishType;
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
	
	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public String getCreatingDate() {
		return creatingDate;
	}

	public void setCreatingDate(String creatingDate) {
		this.creatingDate = creatingDate;
	}

	public String getExpEndDate() {
		return expEndDate;
	}

	public void setExpEndDate(String expEndDate) {
		this.expEndDate = expEndDate;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalEfforts() {
		return totalEfforts;
	}
	
	public String getTotalEffortsAsString() {
		return String.valueOf(totalEfforts);
	}

	public void setTotalEfforts(int totalEfforts) {
		this.totalEfforts = totalEfforts;
	}
	
}
