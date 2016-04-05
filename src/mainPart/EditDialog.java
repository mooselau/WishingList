package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import mainPart.*;
import supportPart.WishesChecker;

public class EditDialog extends EditView implements ActionListener {

	/** GLOBAL VARIABLES **/
	String comboPreviousSelectedItem;
	WishingList	wishList;
	
	/** JComponents */
	JButton okButton, cancelButton, moreButton;
	JLabel nameLabel, totalEffortsLabel, descriptionLabel;
	JTextField nameTextField, completionTextField;
	JTextArea descriptionTextArea;
	JScrollPane descripTextAreaScrollPane;
	JPanel viewMainPanel, dialogCenterPanel, dialogSouthPanel, dialogCenterNamePanel, 
			dialogCenterCompPanel, dialogSouthButtonsPanel, dialogCenterSubPanel;
	JComboBox<String> wishSelectComboBox;
	
	/** Outside Dependencies */
	WishesChecker wishListChecker;
	
	
	/** Constructor */
	public EditDialog(WishingList wishList) {
		
		super(wishList);
		
		// Set Frame size.
		this.setSize(290, 370);
		this.setTitle("Edit Dialog");
		
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		initJComponents();
		initVariables(wishList);
		layoutComponents();
//		addComboBoxItems(wishList);
	}
	
	/**
	 * Initiate JComponents. 
	 */
	private void initJComponents() {
		
		dialogCenterNamePanel = new JPanel();
//		dialogCenterNamePanel.setOpaque(false);
		dialogCenterCompPanel = new JPanel();
//		dialogCenterCompPanel.setOpaque(false);
		
		dialogCenterSubPanel = new JPanel();
		dialogCenterSubPanel.setOpaque(false);
		dialogCenterPanel = new JPanel();
		// make the JPanel transparent.
		dialogCenterPanel.setOpaque(false);
		
		dialogSouthPanel = new JPanel();
		dialogSouthPanel.setOpaque(false);
		dialogSouthButtonsPanel = new JPanel();
		dialogSouthButtonsPanel.setOpaque(false);
		
		viewMainPanel = super.getViewMainPanel();
		//set main panel size.
		viewMainPanel.setPreferredSize(new Dimension(380,350));
		//set a border for good looking..
		viewMainPanel.setBorder(BorderFactory.createTitledBorder("Edit A Wish"));
		wishSelectComboBox = super.getWishSelectComboBox();
		wishSelectComboBox.addActionListener(this);
	}

	/**
	 * Initiate outside global variables.
	 */
	private void initVariables(WishingList wishList) {
		comboPreviousSelectedItem = "";
		this.wishList = wishList;
		wishListChecker = new WishesChecker();
	}
	
	/**
	 * Layout the components on the EditDialog frame.
	 */
	protected void layoutComponents() {
	
		layoutCenterComponents();
		layoutSouthComponents();
		
		viewMainPanel.add(dialogCenterPanel, BorderLayout.CENTER);
		viewMainPanel.add(dialogSouthPanel, BorderLayout.SOUTH);
	}
	
	//leave it empty for this time..
	private void layoutNorthComponents() {}
	
	private void layoutCenterComponents() {
		
		dialogCenterSubPanel.setLayout(new GridLayout(3, 1, 3, 3));
		
		//Layout Name Components.
		nameLabel = new JLabel("Wish Name: ");
		dialogCenterNamePanel.add(nameLabel);
		nameTextField = new JTextField(10);
		dialogCenterNamePanel.add(nameTextField);
		dialogCenterSubPanel.add(dialogCenterNamePanel);
		
		//layout completion components.
		totalEffortsLabel = new JLabel("Total Efforts: ");
		dialogCenterCompPanel.add(totalEffortsLabel);
		completionTextField = new JTextField(10);
		dialogCenterCompPanel.add(completionTextField);
		dialogCenterSubPanel.add(dialogCenterCompPanel);
		
		// Wish description labels
		descriptionLabel = new JLabel("Wish Description: ");
		dialogCenterSubPanel.add(descriptionLabel);
		
		descriptionTextArea = new JTextArea(8, 16);
		// wrap lines automatically
		descriptionTextArea.setLineWrap(true);
		descripTextAreaScrollPane = new JScrollPane(descriptionTextArea);
		
		//Add in the center panel.
		dialogCenterPanel.setLayout(new BorderLayout());
		dialogCenterPanel.add(dialogCenterSubPanel, BorderLayout.NORTH);
		dialogCenterPanel.add(descripTextAreaScrollPane, BorderLayout.SOUTH);
	}
	
	
	private void layoutSouthComponents() {
		
		dialogSouthButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		okButton = new JButton("Okay");
		okButton.setActionCommand("OKAY");
		okButton.addActionListener(this);
		dialogSouthButtonsPanel.add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("CANCEL");
		cancelButton.addActionListener(this);
		dialogSouthButtonsPanel.add(cancelButton);
		
		moreButton = new JButton("More>>");
		moreButton.setActionCommand("MORE");
		moreButton.addActionListener(this);
		dialogSouthButtonsPanel.add(moreButton);

		dialogSouthPanel.add(dialogSouthButtonsPanel, BorderLayout.SOUTH);
	}
	
	
//	/**
//	 * Adding all content in the Combo Box.
//	 * @param wishList the wishingList object.
//	 */
//	private void addComboBoxItems(WishingList wishList) {
//		
//		List<WishItem> wishes = wishList.getCurrentWishes(); 
//		processChecking(wishes);
//		
//		for(WishItem aWish: wishes) {
//			wishSelectComboBox.addItem(aWish.getName());
//		}
//	}
//	
//	/**
//	 * Processing the checking and might do sth afterwards.
//	 * @param wishList the wishingList object.
//	 */
//	private void processChecking(List<WishItem> wishList) {
//		
//		boolean isWishesNamesValid = false;
//		
//		//use the auxiliary tool in support part to check wishes.
//		isWishesNamesValid = wishListChecker.wishingListNameCheck(wishList);
//		
//		//If the wishes are invalid, then the Edit dialog will be closed automatically.
//		if(!isWishesNamesValid) {
//			JOptionPane.showMessageDialog(null, "Some Wishes are invalid!!", "Warning Message", JOptionPane.ERROR_MESSAGE);
//			
//			//closing event will be done by frame.dispatchEvent()..
//			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
//		}
//		
//	}
	
	/**
	 * Every time when the comboBox selects an item, then the fields
	 * will be changed.
	 * @param wishList
	 */
	private void autoFillFields(String wishName) {
		
		WishItem selectedWish= wishList.searchAWish(wishName);
		nameTextField.setText(selectedWish.getName());
		completionTextField.setText(selectedWish.getCompletionAsString());
		descriptionTextArea.setText(selectedWish.getNotes());
		
	}
	
	/**
	 * Action performed when action listener is activated.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == wishSelectComboBox) {
			String newSelectedItem = String.valueOf(wishSelectComboBox.getSelectedItem());
			if(!comboPreviousSelectedItem.equals(newSelectedItem)) {
				autoFillFields(newSelectedItem);
			}
			System.out.println(newSelectedItem);
		}
		
		else if(e.getSource() == okButton) {
			System.out.println("You just pressed OK!!");
		}
		
		else if(e.getSource() == cancelButton) {
			System.out.println("You just pressed Cancel!!");
		}
		
		else if(e.getSource() == moreButton) {
			System.out.println("You just pressed More!!");
		}
		
		
	}
	
}
