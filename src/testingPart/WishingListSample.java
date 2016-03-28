package testingPart;

import mainPart.*;

public class WishingListSample {
	
	WishingList wl;
	
	public WishingListSample() {

		wl = new WishingList();
		addingThreeWishes();
		
	}
	
	
	private void addingThreeWishes() {
		wl.addAWish("abc", 10);
		wl.addAWish("bcd", 20);
		wl.addAWish("cde", 30);
	}
	
	
	public WishingList getASampleWishingList() {
		return wl;
	}
	
}
