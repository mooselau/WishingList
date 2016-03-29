package testingPart;

import mainPart.*;

public class WishingListSample {
	
	WishingList wl;
	
	public WishingListSample() {

		wl = new WishingList();
		addingThreeWishes();
		
	}
	
	
	private void addingThreeWishes() {
		wl.addAWish("abc123456789", 10);
		wl.addAWish("bcd123456789", 20);
		wl.addAWish("cde456123123", 30);
	}
	
	
	public WishingList getASampleWishingList() {
		return wl;
	}
	
}
