package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import supportPart.WishesChecker;
import defaultPart.SomeUtilities;

public class EditMoreDialog extends EditView implements ActionListener {

	/** GLOBAL VARIABLES */
	String comboPreviousSelectedItem;

	/** Global Components */
	JButton okButton, cancelButton;
	JLabel nameLabel, totalEffortsLabel, descriptionLabel;
	JTextField nameTextField, endDateTextField, startDateTextField, totalCostTextField, totalEffortsTextField;
	JTextArea descriptionTextArea;
	JScrollPane descripTextAreaScrollPane;
	JComboBox<String> wishSelectComboBox, wishTypeCombo, costTypeCombo;
	JPanel viewMainPanel, dialogCenterPanel, dialogSouthPanel, 
			dialogCenter_NorthPanel, dialogCenter_CenterPanel, dialogCenter_SouthPanel,
			 namePanel, descriptionPanel;
	
	/** others */
	SomeUtilities toolBox;
	
	/** Constructor */
	public EditMoreDialog(WishingList wishList) {
		
		super(wishList);
		
		this.setSize(280, 540);	// Set Frame size.
		this.setResizable(false);
		this.setTitle("Edit More Dialog");
		
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		initMainComponents();
		initVariables(wishList);
		layoutComponents();
	}
	
	/**
	 * Initialise all Main Panels and super's components.
	 */
	private void initMainComponents() {

		viewMainPanel = super.getViewMainPanel();
		wishSelectComboBox = super.getWishSelectComboBox();
		wishSelectComboBox.addActionListener(this);
		dialogCenterPanel = new JPanel();
		
		dialogCenter_NorthPanel = new JPanel();
		dialogCenter_NorthPanel.setPreferredSize(new Dimension(280, 235));
		dialogCenter_NorthPanel.setBackground(Color.pink);
		
		dialogCenter_CenterPanel = new JPanel();
		dialogCenter_CenterPanel.setPreferredSize(new Dimension(280, 100));
		dialogCenter_CenterPanel.setBackground(Color.cyan);
		
		dialogCenter_SouthPanel = new JPanel();
		dialogCenter_SouthPanel.setPreferredSize(new Dimension(280, 120));
		dialogCenter_SouthPanel.setBackground(Color.ORANGE);

		dialogSouthPanel = new JPanel();
		dialogSouthPanel.setPreferredSize(new Dimension(280, 30));
	}
	
	/**
	 * Initialise all variables.
	 * @param wishList
	 */
	private void initVariables(WishingList wishList) {
		
		toolBox = new SomeUtilities();
		comboPreviousSelectedItem = "";
	}
	
	/**
	 * Layout all components on the main Panel.
	 */
	private void layoutComponents() {
		
		layooutCenterComponents();
		layoutSouthComponents();
		layoutMainPanelComponents();
	}
	
	private void layoutMainPanelComponents() {
		
		viewMainPanel.add(dialogCenterPanel, BorderLayout.CENTER);
		dialogCenterPanel.setLayout(new BorderLayout());
		dialogCenterPanel.add(dialogCenter_NorthPanel, BorderLayout.NORTH);
		dialogCenterPanel.add(dialogCenter_CenterPanel, BorderLayout.CENTER);
		dialogCenterPanel.add(dialogCenter_SouthPanel, BorderLayout.SOUTH);
		viewMainPanel.add(dialogSouthPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Layout components in the Center Panel.
	 */
	private void layooutCenterComponents() {
		
		layoutCenterSubNorthComp();
		layoutCenterSubCenterComp();
		layoutCenterSubSouth();
	}
	
	private void layoutCenterSubNorthComp() {
		
		JPanel nameAndDescripPanel = new JPanel();
		nameAndDescripPanel.setOpaque(false);
		nameAndDescripPanel.setLayout(new GridLayout(3, 1, 0, -20));
		namePanel = new JPanel();
		namePanel.setOpaque(false);
		nameLabel = new JLabel("Wish Name: ");
		nameTextField = new JTextField(10);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		nameAndDescripPanel.add(namePanel);
		
		JPanel wishTypePanel = new JPanel();
		wishTypePanel.setOpaque(false);
		// set flow layout with hgagp=15, vgap=5, laying out from LEFT.
		wishTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 9));
		JLabel wishTypeLabel = new JLabel("Wish Type: ");
		wishTypeCombo = new JComboBox<String>();
		wishTypeCombo.addItem("General");
		wishTypeCombo.addItem("Special");
		wishTypePanel.add(wishTypeLabel);
		wishTypePanel.add(wishTypeCombo);
		nameAndDescripPanel.add(wishTypePanel);
		
		descriptionLabel = new JLabel("Descriptions:");
		nameAndDescripPanel.add(descriptionLabel);
		
		descriptionTextArea = new JTextArea(7, 18);
		descriptionTextArea.setLineWrap(true);
		descripTextAreaScrollPane = new JScrollPane(descriptionTextArea);
		
		// Use Flow Layout as default.
		dialogCenter_NorthPanel.setBorder(BorderFactory.createTitledBorder("Edit Basics"));
		dialogCenter_NorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, -3));
		dialogCenter_NorthPanel.add(nameAndDescripPanel);
		dialogCenter_NorthPanel.add(descripTextAreaScrollPane);
	}
	
	private void layoutCenterSubCenterComp() {
		
		JPanel endDatePanel = new JPanel();
		endDatePanel.setOpaque(false);
		JLabel endDateLabel = new JLabel("Expected EndDate:");
		endDateTextField = new JTextField(8);
		endDatePanel.add(endDateLabel);
		endDatePanel.add(endDateTextField);
		
		JPanel startDatePanel = new JPanel();
		startDatePanel.setOpaque(false);
		JLabel startDateLabel = new JLabel("Wish Start Date: ");
		startDateTextField = new JTextField(10);
		startDatePanel.add(startDateLabel);
		startDatePanel.add(startDateTextField);
		
		dialogCenter_CenterPanel.setLayout(new GridLayout(2, 1, 0, -10));
		dialogCenter_CenterPanel.add(endDatePanel);
		dialogCenter_CenterPanel.add(startDatePanel);
		dialogCenter_CenterPanel.setBorder(BorderFactory.createTitledBorder("Edit Dates"));
	}
	
	private void layoutCenterSubSouth() {
		
		JPanel costTypeComboPanel = new JPanel();
		costTypeComboPanel.setOpaque(false);
		JLabel costTypeLabel = new JLabel("Cost Type: ");
		costTypeCombo = new JComboBox<String>();
		costTypeCombo.addItem("RMBs");
		costTypeCombo.addItem("Days");
		costTypeComboPanel.add(costTypeLabel);
		costTypeComboPanel.add(costTypeCombo);
		
		JPanel totalCostPanel = new JPanel();
		totalCostPanel.setOpaque(false);
		JLabel totalCostLabel = new JLabel("Total Cost: ");
		totalCostTextField = new JTextField(9);
		totalCostPanel.add(totalCostLabel);
		totalCostPanel.add(totalCostTextField);
		
		JPanel totalEffortsPanel = new JPanel();
		totalEffortsPanel.setOpaque(false);
		JLabel totalEffortsLabel = new JLabel("Total Efforts: ");
		totalEffortsTextField = new JTextField(8);
		totalEffortsPanel.add(totalEffortsLabel);
		totalEffortsPanel.add(totalEffortsTextField);
		
		dialogCenter_SouthPanel.setBorder(BorderFactory.createTitledBorder("Edit Cost"));
		dialogCenter_SouthPanel.setLayout(new GridLayout(3, 1, 0, -8));
		dialogCenter_SouthPanel.add(costTypeComboPanel);
		dialogCenter_SouthPanel.add(totalCostPanel);
		dialogCenter_SouthPanel.add(totalEffortsPanel);
		
	}
	
	private void layoutSouthComponents() {
		
		dialogSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));
		okButton = new JButton("Ok");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		dialogSouthPanel.add(okButton);
		dialogSouthPanel.add(cancelButton);
	}
	
	/**
	 * Every time when the comboBox selects an item, then the fields
	 * will be changed.
	 * @param wishList
	 */
	private void autoFillFields(String wishName) {
		
		WishItem selectedWish= wishList.searchAWish(wishName);
		nameTextField.setText(selectedWish.getName());
		String wishType = selectedWish.getWishType();
		wishTypeCombo.setSelectedItem(wishType);
		descriptionTextArea.setText(selectedWish.getNotes());
		endDateTextField.setText(selectedWish.getExpEndDate());
		startDateTextField.setText(selectedWish.getCreatingDate());
		String costType = selectedWish.getCostType();
		costTypeCombo.setSelectedItem(costType);
		totalCostTextField.setText(String.valueOf(selectedWish.getTotalCost()));
		totalEffortsTextField.setText(String.valueOf(selectedWish.getTotalEfforts()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() ==  wishSelectComboBox) {
			String newSelectedItem = String.valueOf(wishSelectComboBox.getSelectedItem());
			if(!comboPreviousSelectedItem.equals(newSelectedItem)) {
				autoFillFields(newSelectedItem);
				comboPreviousSelectedItem = newSelectedItem;
			}
			System.out.println(newSelectedItem);
		}
		
		else if(e.getSource() == okButton) {
			inputsCollector();
			System.out.println("You just pressed OK!!");
		}
		
		else if(e.getSource() == cancelButton) {
			System.out.println("You just pressed Cancel!!");
		}
	}

	private void inputsCollector() {
		String newName  = nameTextField.getText();
		String newEndDate = endDateTextField.getText();
		String newStartDate = startDateTextField.getText();
		String newTotalCost = totalCostTextField.getText();
		String newTotalEfforts =totalEffortsTextField.getText();
		String newNotes = descriptionTextArea.getText();
		String newCostType = String.valueOf(costTypeCombo.getSelectedItem());
		String newWishType = String.valueOf(wishTypeCombo.getSelectedItem());
		
		String msg = String.format("********************\nBelow is your inputs: \newName: %s\n"
				+ "newEndDate: %s\nnewStartDate: %s\nnewTotalCost: %s\nnewTotalEfforts: %s\nnewNotes: %s\nnewCostType: %s\nnewWishType: %s\n",
				newName, newEndDate, newStartDate, newTotalCost, newTotalEfforts, newNotes, newCostType, newWishType);
		System.out.println(msg);
	}
	
}
