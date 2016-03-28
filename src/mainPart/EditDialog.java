package mainPart;

import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;

import supportPart.WishesChecker;

public class EditDialog extends EditView{

	/** GLOBAL VARIABLES **/
	/** JComponents */
	JPanel viewMainPanel;
	JComboBox<String> wishSelectComboBox;
	
	/** Outside Dependencies */
	WishesChecker wishListChecker;
	
	
	/** Constructor */
	public EditDialog(WishingList wishList) {
		
		this.setSize(200, 300);
		initJComponents();
		initVariables();
		layoutComponents();
		
		addComboBoxItems(wishList);
		
	}
	
	/**
	 * Initiate JComponents. 
	 */
	private void initJComponents() {
		viewMainPanel = super.getViewMainPanel();
		wishSelectComboBox = super.getWishSelectComboBox();
		
		
	}

	/**
	 * Initiate outside global variables.
	 */
	private void initVariables() {
		wishListChecker = new WishesChecker();
	}
	
	/**
	 * Layout the components on the EditDialog frame.
	 */
	protected void layoutComponents() {

	}
	
	/**
	 * Adding all content in the Combo Box.
	 * @param wishList the wishingList object.
	 */
	private void addComboBoxItems(WishingList wishList) {
		
		List<WishItem> wishes = wishList.getCurrentWishes(); 
		processChecking(wishes);
		
		for(WishItem aWish: wishes) {
			wishSelectComboBox.addItem(aWish.getName());
		}
		
	}
	
	/**
	 * Processing the checking and might do sth afterwards.
	 * @param wishList the wishingList object.
	 */
	private void processChecking(List<WishItem> wishList) {
		
		boolean isWishesNamesValid = false;
		isWishesNamesValid = wishListChecker.wishingListNameCheck(wishList);
		
		//If the wishes are invalid, then the Edit dialog will be closed automatically.
		if(!isWishesNamesValid) {
			JOptionPane.showMessageDialog(null, "Some Wishes are invalid!!", "Warning Message", JOptionPane.ERROR_MESSAGE);
			
			//closing event will be done by frame.dispatchEvent()..
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		
	}
	
}
