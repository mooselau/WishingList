package mainPart;

import java.util.*;

public class WishingList {

	/** Global Variables */
	List<WishItem> wishingList = null;
	
	/** Constructor */
	public WishingList() {
		wishingList = new ArrayList<WishItem>();
	}
	
	/**
	 * Search for a wish with specific name.
	 * @param wishName
	 * @return null if wishing list is empty or the wish is not found;
	 * 		   otherwise a instance of WishItem will be returned.
	 */
	public WishItem searchAWish(String wishName) {
		
		if(wishingList.size()==0)
			return null;
		
		Iterator<WishItem> wishesItr = wishingList.iterator();
		
		while(wishesItr.hasNext()) {
			WishItem aWish = (WishItem)wishesItr.next();
			if(aWish.getName().equals(wishName)) {
				return aWish;
			}
		}
		
		return null;
	}
	
	//Temp use AddWish
	public List<WishItem> addAWish(String wishName, int completion) {
		WishItem newWish = new WishItem(wishName, completion);
		wishingList.add(newWish);
		return wishingList;
	}
	
	public List<WishItem> addAWish(String wishName, int completion, String notes) {
		WishItem newWish = new WishItem(wishName, completion, notes);
		wishingList.add(newWish);
		return wishingList;
	}
	
	
	/**
	 * Add a wish with Wish Object
	 * @param newWish the Wish Obj.
	 */
	public List<WishItem> addAWish(WishItem newWish) {
		wishingList.add(newWish);
		return wishingList;
	}
	
	/**
	 * Delete a wish with specific name.
	 * @param wishName the new wish name.
	 */
	public List<WishItem> deleteAWish(String wishName) {
		
		try{
			//Attention on Exceptions!!!
			WishItem delWish = searchAWish(wishName);
			if(delWish == null) {
				//throws an exception
				throw new NullPointerException("The Wishing list is empty!");
			}
			else {
				wishingList.remove(delWish);
				return wishingList;
			}
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Remove all wishes.
	 */
	public void deleteAllWishes() {
		wishingList.clear();
	}
	
	/**
	 * Return current wishing list.
	 * @return A list of wishes.
	 */
	public List<WishItem> getCurrentWishes() {
		return wishingList;
	}
	
	/**
	 * Display all wishes in a format.
	 */
	public void displayAllWishes() {
		System.out.println("\n********************************************");
		for(WishItem aWish: wishingList) {
			System.out.printf("Name: %s\tCompletion: %d%%\n", aWish.getName(), aWish.getCompletion());
		}
	}
	
}
