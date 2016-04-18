package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteDialog extends EditView implements ActionListener {

	/** GLOBAL VARIABLES */
	
	/** JComponents */
	private JLabel deleteMessage;
	private JButton yesButton, noButton;
	private JPanel viewMainPanel, dialogMainPanel, dialogButtonPanel;
	private JComboBox<String> wishSelectComboBox;
	
	public DeleteDialog(WishingList wishList) {
		
		super(wishList);	
		
		// Set Frame size.
		this.setSize(290, 160);
		this.setTitle("Delete Dialog");
		
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		
		initJComponents();
		layoutComponents();
	}
	
	/**
	 * Initiate Main JComponents. 
	 */
	private void initJComponents() {
		
		viewMainPanel = super.getViewMainPanel();
		dialogMainPanel = new JPanel();
		dialogButtonPanel = new JPanel();
		wishSelectComboBox = super.getWishSelectComboBox();
	}
	
	/**
	 * Layout the components on the Delete Dialog frame.
	 */
	private void layoutComponents() {
		
		dialogMainPanel.setBackground(Color.orange);
		viewMainPanel.add(dialogMainPanel, BorderLayout.CENTER);
		
		deleteMessage = new JLabel("Are you sure to delete this WISH ??");
		dialogMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 20));
		dialogMainPanel.add(deleteMessage);
		
		yesButton = new JButton("Yes, I am sure.");
		yesButton.addActionListener(this);
		noButton = new JButton("No, I am not.");
		noButton.addActionListener(this);
		dialogButtonPanel.add(yesButton);
		dialogButtonPanel.add(noButton);
		dialogButtonPanel.setOpaque(false);
		dialogMainPanel.add(dialogButtonPanel);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == yesButton) {
			String selectedWish = String.valueOf(wishSelectComboBox.getSelectedItem());
			System.out.println("Yes to delete this wish: " + selectedWish);
		}
		
		else if(event.getSource() == noButton) {
			String selectedWish = String.valueOf(wishSelectComboBox.getSelectedItem());
			System.out.println("No to delete this wish: " + selectedWish);
		}
		
	}
}
