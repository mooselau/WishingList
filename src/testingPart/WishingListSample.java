package testingPart;

import mainPart.*;

public class WishingListSample {
	
	WishingList wl;
	
	public WishingListSample() {

		wl = new WishingList();
		addingOtherFullInfoWishes();
		
	}
	
//	String na, String wishType, String costType, int totalCost, String creatingDa, String expEndDa, String descrip
	
	private void addingThreeWishes() {
		
		String note = "This is a fake note for %s, the note will determine wether the TextArea will display in a proper way. "
				+ "I dont know the answer, Let's see!";
		wl.addAWish("abc123456789", 10, String.format(note, "abc123456789"));
		wl.addAWish("bcd123456789", 20, String.format(note, "bcd123456789"));
		wl.addAWish("cde456123123", 30, String.format(note, "cde456123123"));
	}
	
	private void addingOtherFullInfoWishes() {
		
		String note = "This is a fake note for %s, the note will determine wether the TextArea will display in a proper way. "
				+ "I dont know the answer, Let's see!";
		
		WishItem aWish, bWish, cWish, dWish;
		aWish = new WishItem("Wish A", "General", "RMBs", 1000, "2016-04-12", "2016-05-12", String.format(note, "Wish A"));
		bWish = new WishItem("Wish B", "General", "Days", 60, "2016-04-12", "2016-06-12", String.format(note, "Wish B"));
		cWish = new WishItem("Wish C", "Special", "Days", 180, "2016-04-12", "2016-10-12", String.format(note, "Wish C"));
		dWish = new WishItem("Wish D", "Special", "RMBs", 5000, "2016-04-12", "2016-10-01", String.format(note, "Wish D"));
		
		aWish.setTotalEfforts(50);
		bWish.setTotalEfforts(30);
		cWish.setTotalEfforts(80);
		dWish.setTotalEfforts(10);
		
		wl.addAWish(aWish);
		wl.addAWish(bWish);
		wl.addAWish(cWish);
		wl.addAWish(dWish);
	}
	
	public WishingList getASampleWishingList() {
		return wl;
	}
	
}
