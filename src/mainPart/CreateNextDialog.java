package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import defaultPart.SomeUtilities;
import supportPart.InputsContainer;

public class CreateNextDialog extends JFrame implements ActionListener{

	/** GLOBAL VARIABLES */
	
	/** JComponents */
	private JTextField expEndDateTextField;
	private JTextArea wishDesTextArea;
	private JComboBox<String> wishTypeCombo;
	private JButton backButton, finishButton;
	private JPanel dialogMainPanel, dialogCenterPanel, dialogSouthPanel;
	
	/**Global Vairables*/
	CreateDialog previousCreateDialog;
	InputsContainer inputsContainer;
	private SomeUtilities toolBox = new SomeUtilities();
	
	/** Constructor */
	public CreateNextDialog(CreateDialog createDialog, String wishName) {
		
		// Set Frame size.
		this.setSize(450, 365);
		
		String frameTitle = String.format("Wish Details - %s", wishName);
		this.setTitle(frameTitle);
		
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		
		initVariables(createDialog);
		initJComponents();
		layoutComponents();
	}
	
	/**
	 * Initialize main variables.
	 */
	private void initVariables(CreateDialog createDialog) {
		previousCreateDialog = createDialog;
		inputsContainer = createDialog.getInputsContainer();
	}
	
	/** Initialise main JCompos. */
	private void initJComponents() {
		
		dialogMainPanel = new JPanel();
		dialogMainPanel.setLayout(new BorderLayout());
		dialogCenterPanel = new JPanel();
		dialogCenterPanel.setLayout(new BorderLayout());
		dialogSouthPanel = new JPanel();
		this.add(dialogMainPanel);
	}
	
	/** Layout main components. */
	private void layoutComponents() {
		
		layoutCenterComponents();
		layoutSouthComponents();
		dialogMainPanel.add(dialogCenterPanel, BorderLayout.CENTER);
		dialogMainPanel.add(dialogSouthPanel, BorderLayout.SOUTH);
	}
	
	private void layoutCenterComponents() {
		
		JPanel center_NorthPanel = new JPanel();
		// to make the north panel align left.
		center_NorthPanel.setBackground(Color.lightGray);
		center_NorthPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 3));
		JPanel centerWishTypePanel = new JPanel();
		centerWishTypePanel.setOpaque(false);
		centerWishTypePanel.setPreferredSize(new Dimension(200, 50));
		JLabel wishTypeLabel = new JLabel("Please choose a wish type:");
		wishTypeCombo = new JComboBox<String>();
		wishTypeCombo.addItem("General");
		wishTypeCombo.addItem("Special");
		// to make the wishTypePanel align left, otherwise compo will be at the center in this panel.
		centerWishTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerWishTypePanel.add(wishTypeLabel);
		centerWishTypePanel.add(wishTypeCombo);
		center_NorthPanel.add(centerWishTypePanel);
		dialogCenterPanel.add(center_NorthPanel, BorderLayout.NORTH);
		
		JPanel center_CenterPanel = new JPanel();
		center_CenterPanel.setBackground(Color.orange);
		center_CenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 3));
		JPanel centerWishDesPanel = new JPanel();
		centerWishDesPanel.setOpaque(false);
		centerWishDesPanel.setPreferredSize(new Dimension(430, 180));
		centerWishDesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel wishDesLabel = new JLabel("Wish Description:");
		wishDesTextArea = new JTextArea(9, 34);
		wishDesTextArea.setLineWrap(true);
		centerWishDesPanel.add(wishDesLabel);
		centerWishDesPanel.add(wishDesTextArea);
		center_CenterPanel.add(centerWishDesPanel);
		dialogCenterPanel.add(center_CenterPanel, BorderLayout.CENTER);
		
		JPanel center_SouthPanel = new JPanel();
		center_SouthPanel.setBackground(Color.cyan);
		center_SouthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel centerExpEndDatePanel = new JPanel();
		centerExpEndDatePanel.setOpaque(false);
		centerExpEndDatePanel.setPreferredSize(new Dimension(250, 50));
		centerExpEndDatePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 3));
		String tipText = "e.g.: 31/12/2016 (dd/mm/yyyy)";
		centerExpEndDatePanel.setToolTipText(tipText);
		JLabel wishExpEndDateLabel = new JLabel("Exp. End Date:");
		expEndDateTextField = new JTextField(16);
		expEndDateTextField.setToolTipText(tipText);
		centerExpEndDatePanel.add(wishExpEndDateLabel);
		centerExpEndDatePanel.add(expEndDateTextField);
		center_SouthPanel.add(centerExpEndDatePanel);
		dialogCenterPanel.add(center_SouthPanel, BorderLayout.SOUTH);
		
	}
	
	private void layoutSouthComponents() {
		
		dialogSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 3));
		backButton = new JButton("Go Back");
		backButton.addActionListener(this);
		finishButton = new JButton("Let's Finish");
		finishButton.addActionListener(this);
		dialogSouthPanel.add(backButton);
		dialogSouthPanel.add(finishButton);
	}
	
	/**
	 * Event handlers.
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			
			
			toolBox.printThis("You just pressed Back Button!");
			previousCreateDialog.setVisible(true);
//			this.setVisible(false);
			this.dispose();	// destroy itself.
		}
		
		else if (e.getSource() == finishButton) {
			toolBox.printThis("You just pressed Finish Button!");
			
			inputsCollector();
		}
	}

	/**
	 * Get a trimed String from a text field.
	 * @param textField
	 * @return a trimed String.
	 */
	private String getSafeTextFieldValue(JTextField textField) {
		return textField.getText().trim();
	}
	
	private void inputsCollector() {
		String wishName  = inputsContainer.pullInputValue("wishName");
		String totalCost = inputsContainer.pullInputValue("totalCost");
		String wishCostType = inputsContainer.pullInputValue("wishCostType");
		
		String wishType = String.valueOf(wishTypeCombo.getSelectedItem());
		String wishDescription = wishDesTextArea.getText();
		String expEndDate = getSafeTextFieldValue(expEndDateTextField);
		
		String msg = String.format("********************\nBelow is your inputs: \nnewName: %s\n"
				+ "newTotalCosts: %s\nwishCostType: %s\nwishType: %s\nwishDes: %s\nexpEndDate: %s", 
					wishName, totalCost, wishCostType, wishType, wishDescription, expEndDate);
		System.out.println(msg);
	}
	
	
}
