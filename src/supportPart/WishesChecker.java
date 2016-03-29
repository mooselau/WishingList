package supportPart;

import java.util.List;

import mainPart.*;

public class WishesChecker {
	
	/** Constructor */
	public WishesChecker() {
		
	}
	
	/**
	 * Check Wishes in case any wish has invalid name.
	 * @param wishes WishItem List
	 * @return true if checking successed;
	 *			false if checking failed.
	 */
	public boolean wishingListNameCheck(List<WishItem> wishes) {
	
		boolean checkResult = NameCheckProcess(wishes);
		
		return checkResult;
	}
	
	private boolean NameCheckProcess(List<WishItem> wishes) {
		// Loop for traverse all wish items.
		try {
			
			for(WishItem aWish: wishes) {
				if(aWish.getName().isEmpty()) {
					throw new CommonExceptions("There is an invalid wish with empty name!!");
				}
			}
			
		} catch (CommonExceptions e) {
			//need logs..
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
