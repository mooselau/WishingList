package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputDialog extends EditView implements ActionListener{
	
	/** GLOBAL VARIABLES */
	String comboPreviousSelectedItem;
	
	/** GLOBAL COMPONENTS */
	JPanel viewMainPanel;
	JPanel dialogCenterPanel, dialogSouthPanel;
	JButton okayButton, cancelButton;
	JTextField effortsTextField, costTypeTextField;
	JComboBox<String> wishSelectComboBox;
	
	/** Constructor */
	public InputDialog(WishingList wishList) {
	
		super(wishList);
		
		this.setSize(280, 160);
		this.setTitle("Input Efforts Dialog");
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		initVariables();
		initMainComponents();
		layoutComponents();
	}
	
	/**
	 * Initialise all necessary variables.
	 */
	private void initVariables() {
		
		comboPreviousSelectedItem = "";
	}
	
	/**
	 * Initialise all Main Panels and super's components.
	 */
	private void initMainComponents() {
		
		viewMainPanel = super.getViewMainPanel();
		wishSelectComboBox = super.getWishSelectComboBox();
		wishSelectComboBox.addActionListener(this);
		
		dialogCenterPanel = new JPanel();
		dialogCenterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 10));
		dialogCenterPanel.setBackground(Color.lightGray);
		
		dialogSouthPanel = new JPanel();
		dialogSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 2));
		dialogSouthPanel.setBackground(Color.orange);
		dialogSouthPanel.setPreferredSize(new Dimension(280, 30));
	}
	
	/**
	 * Layout all components on the main Panel.
	 */
	private void layoutComponents() {
		
		layoutCenterComponents();
		layoutSouthComponents();
	}
	
	// Layout compos in the center part.
	private void layoutCenterComponents() {
		
		viewMainPanel.add(dialogCenterPanel, BorderLayout.CENTER);
		
		JPanel effortsInputPanel = new JPanel();
		effortsInputPanel.setOpaque(false);
		effortsInputPanel.setLayout(new GridLayout(2, 1));
		JLabel effortsLabel = new JLabel("Input Efforts: ");
		effortsTextField = new JTextField(14);
		effortsInputPanel.add(effortsLabel);
		effortsInputPanel.add(effortsTextField);
		dialogCenterPanel.add(effortsInputPanel);
		
		JPanel costTypePanel = new JPanel();
		costTypePanel.setOpaque(false);
		costTypePanel.setLayout(new GridLayout(2, 1));
		JLabel costTypeLabel = new JLabel("Cost Type: ");
		costTypeTextField = new JTextField(6);
		costTypeTextField.setEditable(false);
		costTypePanel.add(costTypeLabel);
		costTypePanel.add(costTypeTextField);
		dialogCenterPanel.add(costTypePanel);
	}

	// Layout compos in the south part.
	private void layoutSouthComponents() {
		
		viewMainPanel.add(dialogSouthPanel, BorderLayout.SOUTH);

		okayButton = new JButton("OK");
		okayButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		dialogSouthPanel.add(okayButton);
		dialogSouthPanel.add(cancelButton);
		
	}

	/**
	 * Every time when the comboBox selects an item, then the fields
	 * will be changed.
	 * @param wishList
	 */
	private void autoFillFields(String wishName) {
		
		WishItem selectedWish= wishList.searchAWish(wishName);
		costTypeTextField.setText(selectedWish.getCostType());
	}
	
	/**
	 * Action Performed for different events.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == wishSelectComboBox) {
			
			String newSelectedItem = String.valueOf(wishSelectComboBox.getSelectedItem());
			if(!comboPreviousSelectedItem.equals(newSelectedItem)) {
				autoFillFields(newSelectedItem);
				comboPreviousSelectedItem = newSelectedItem;
			}
			System.out.println(newSelectedItem);
		}
		
		else if(e.getSource() == okayButton) {
			inputsCollector();
			System.out.println("You just pressed Okay Button!");
		}
		
		else if(e.getSource() == cancelButton) {
			System.out.println("You just pressed Cancel Button!");
		}
	}
	
	private void inputsCollector() {
		String efforts = effortsTextField.getText();
		String msg = String.format("********************\nBelow is your inputs: \nEfforts: %s", efforts);
		System.out.println(msg);
	}
	
}
