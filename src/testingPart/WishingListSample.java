package testingPart;

import mainPart.*;

public class WishingListSample {
	
	WishingList wl;
	
	public WishingListSample() {

		wl = new WishingList();
		addingThreeWishes();
		
	}
	
	
	private void addingThreeWishes() {
		String note = "This is a fake note for %s, the note will determine wether the TextArea will display in a proper way. "
				+ "I dont know the answer, Let's see!";
		
		wl.addAWish("abc123456789", 10, String.format(note, "abc123456789"));
		wl.addAWish("bcd123456789", 20, String.format(note, "bcd123456789"));
		wl.addAWish("cde456123123", 30, String.format(note, "cde456123123"));
	}
	
	
	public WishingList getASampleWishingList() {
		return wl;
	}
	
}
