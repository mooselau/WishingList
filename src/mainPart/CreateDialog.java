package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class CreateDialog extends JFrame implements ActionListener{

	/** GLOBAL VARIABLES */
	
	/** JComponents */
	private JTextField wishNameTextField, wishCostTextField;
	private JComboBox<String> wishCostTypeCombo;
	private JButton cancelButton, finishButton, nextButton;
	private JPanel dialogMainPanel, dialogCenterPanel, dialogSouthPanel, inputAreaPanel;
	
	/** other vairables */
	SomeUtilities toolBox = new SomeUtilities();
	
	/** Constructor */
	public CreateDialog() {
		
		// Set Frame size.
		this.setSize(450, 210);
		this.setTitle("Create a new Wish");
		
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		
		initJComponents();
		layoutComponents();
	}
	
	/**
	 * initialise main Panels & components.
	 */
	private void initJComponents() {
		
		dialogMainPanel = new JPanel();
		dialogMainPanel.setLayout(new BorderLayout());
		dialogCenterPanel = new JPanel();
		dialogSouthPanel = new JPanel();
		inputAreaPanel = new JPanel();
		inputAreaPanel.setLayout(new GridLayout(2, 1));
		this.add(dialogMainPanel);
	}
	
	/**
	 * Layout Main Components.
	 */
	private void layoutComponents() {
		
		layoutCenterComponents();
		layoutSouthComponents();
	}
	
	
	private void layoutCenterComponents() {
		
		layoutCenter_NamePanelCompo();
		layoutCenter_CostPanelCompo();
		dialogMainPanel.add(inputAreaPanel, BorderLayout.CENTER);
	}
	
	private void layoutCenter_NamePanelCompo() {
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.gray);
		JPanel nameInputPanel = new JPanel();
		nameInputPanel.setOpaque(false);
		nameInputPanel.setLayout(new GridLayout(2, 1));
		JLabel inputNameLabel = new JLabel();
		inputNameLabel.setText("Please input the New Wish Name below:");
		wishNameTextField =new JTextField(10);
		wishNameTextField.setPreferredSize(new Dimension(1, 30));
		nameInputPanel.add(inputNameLabel);
		nameInputPanel.add(wishNameTextField);
		namePanel.add(nameInputPanel);
		inputAreaPanel.add(namePanel);
	}
	
	private void layoutCenter_CostPanelCompo() {
		
		JPanel costPanel = new JPanel();
		costPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		costPanel.setBackground(Color.orange);
		JPanel costInputPanel = new JPanel();
		costInputPanel.setOpaque(false);
		costInputPanel.setLayout(new GridLayout(2, 1));
		JLabel inputCostLabel = new JLabel();
		inputCostLabel.setText("Input Wish Cost:");
		wishCostTextField = new JTextField(10);
		costInputPanel.add(inputCostLabel);
		costInputPanel.add(wishCostTextField);
		costPanel.add(costInputPanel);
		
		JPanel costTypePanel = new JPanel();
		costTypePanel.setOpaque(false);
		costTypePanel.setLayout(new GridLayout(2, 1));
		JLabel costTypeLabel = new JLabel();
		costTypeLabel.setText("Cost Type:");
		wishCostTypeCombo = new JComboBox<String>();
		wishCostTypeCombo.addItem("Days");
		wishCostTypeCombo.addItem("RMBs");
		costTypePanel.add(costTypeLabel);
		costTypePanel.add(wishCostTypeCombo);
		costPanel.add(costTypePanel);
		inputAreaPanel.add(costPanel);
	}
	
	private void layoutSouthComponents() {
		
		dialogSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		finishButton = new JButton("Finish");
		finishButton.addActionListener(this);
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		dialogSouthPanel.add(cancelButton);
		dialogSouthPanel.add(finishButton);
		dialogSouthPanel.add(nextButton);
		dialogMainPanel.add(dialogSouthPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Events handlers and performs.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cancelButton) {
			toolBox.printThis("You just pressed Cancel!");
		}
		
		else if(e.getSource() == finishButton) {
			toolBox.printThis("You just pressed Finish!");
			inputsCollector();
		}
		
		else if(e.getSource() == nextButton) {
			toolBox.printThis("You just Pressed Next!");
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
		String wishName  = this.getSafeTextFieldValue(wishNameTextField);
		String totalCost = this.getSafeTextFieldValue(wishCostTextField);
		String wishCostType = String.valueOf(wishCostTypeCombo.getSelectedItem());
		
		String msg = String.format("********************\nBelow is your inputs: \nnewName: %s\n"
				+ "newTotalEfforts: %s\nnewNotes: %s", wishName, totalCost, wishCostType);
		System.out.println(msg);
	}
	
}
