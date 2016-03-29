package mainPart;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;

import supportPart.WishesChecker;

public class EditDialog extends EditView{

	/** GLOBAL VARIABLES **/
	/** JComponents */
	JLabel nameLabel, completionLabel, descriptionLabel;
	JTextField nameTextField, completionTextField;
	JTextArea descriptionTextArea;
	JPanel editDialogPanel;
	JComboBox<String> wishSelectComboBox;
	
	/** Outside Dependencies */
	WishesChecker wishListChecker;
	
	
	/** Constructor */
	public EditDialog(WishingList wishList) {
		
		super();
		
		this.setSize(380, 310);
		this.setTitle("Edit Dialog");
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		initJComponents();
		initVariables();
		
		layoutComponents();
		
		addComboBoxItems(wishList);
		
	}
	
	/**
	 * Initiate JComponents. 
	 */
	private void initJComponents() {
		
		editDialogPanel = new JPanel();
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
		
		editDialogPanel.setLayout(new GridLayout(2, 3));
		nameLabel = new JLabel("Wish Name: ");
		editDialogPanel.add(nameLabel);
		nameTextField = new JTextField();
		editDialogPanel.add(nameTextField);
		completionLabel = new JLabel("Completion: ");
		editDialogPanel.add(completionLabel);
		completionTextField = new JTextField();
		editDialogPanel.add(completionTextField);
		descriptionLabel = new JLabel("Wish Description: ");
		editDialogPanel.add(descriptionLabel);
		descriptionTextArea = new JTextArea();
		editDialogPanel.add(descriptionTextArea);
		
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
