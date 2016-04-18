package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;

import supportPart.WishesChecker;


public class EditView extends JFrame {
	
	/** GLOBAL VARIABLES */
	protected WishingList wishList;
	
	protected JPanel viewMainPanel, viewSelectorPanel;
	protected JComboBox<String> wishSelectComboBox;
	
	/** Outside Dependencies */
	protected WishesChecker wishListChecker;
	
	/** Constructor */
	public EditView(WishingList wishList) {

		initVariables(wishList);
		initJComponents();
		viewLayoutComponents();
		addComboBoxItems(wishList);
	}
	
	/**
	 * Initiate all necessary variables.
	 */
	private void initVariables(WishingList wishList) {
		
		this.wishList = wishList;
		this.wishListChecker = new WishesChecker();
	}
	
	
	/**
	 * Initiate all necessary components.
	 */
	private void initJComponents() {
		
		viewSelectorPanel = new JPanel();
		viewSelectorPanel.setPreferredSize(new Dimension(300,30));
		viewSelectorPanel.setOpaque(false);
		viewMainPanel = new JPanel();
		viewMainPanel.setLayout(new BorderLayout());
		viewMainPanel.setBackground(Color.gray);
		wishSelectComboBox = new JComboBox<String>();
		wishSelectComboBox.setPreferredSize(new Dimension(200,20));
	}

	/**
	 * Layout all necessary components.
	 */
	protected void viewLayoutComponents() {
		
		viewSelectorPanel.add(wishSelectComboBox);
		viewMainPanel.add(viewSelectorPanel, BorderLayout.NORTH);
		this.add(viewMainPanel);
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
		
		//use the auxiliary tool in support part to check wishes.
		isWishesNamesValid = wishListChecker.wishingListNameCheck(wishList);
		
		//If the wishes are invalid, then the Edit dialog will be closed automatically.
		if(!isWishesNamesValid) {
			JOptionPane.showMessageDialog(null, "Some Wishes are invalid!!", "Warning Message", JOptionPane.ERROR_MESSAGE);
			
			//closing event will be done by frame.dispatchEvent()..
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		
	}
	
	/**
	 * Return the Main Panel in this abstract class.
	 * @return the main JPanel
	 */
	protected JPanel getViewMainPanel() {
		return viewMainPanel;
	}
	
	/**
	 * Return the only combo box of selecting the wish.
	 * @return the only Combo Box.
	 */
	protected JComboBox<String> getWishSelectComboBox() {
		return wishSelectComboBox;
	}
	
	/**
	 * Return the necessary JLabel & JTextField.
	 * @return
	 */
	protected JLabel getANewJLabel() {
		return new JLabel();
	}
	
	protected JTextField getANewJTextField() {
		return new JTextField();
	}
	
	protected JTextArea getANewJTextArea() {
		return new JTextArea();
	}
	
}
