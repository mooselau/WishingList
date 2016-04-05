package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import defaultPart.SomeUtilities;

public class EditMoreDialog extends EditView implements ActionListener {

	/** GLOBAL VARIABLES */
	JPanel viewMainPanel, dialogCenterPanel, dialogSouthPanel, 
			dialogCenter_NorthPanel, dialogCenter_CenterPanel, dialogCenter_SouthPanel;
	
	/**  */
	SomeUtilities toolBox;
	
	/** Constructor */
	public EditMoreDialog(WishingList wishList) {
		
		super(wishList);
		
		// Set Frame size.
		this.setSize(290, 700);
		this.setTitle("Edit More Dialog");
		
		//Set the window at the center of the screen.
		setLocationRelativeTo(null);
		initJComponents();
		initVariables(wishList);
		layoutComponents();
//		addComboBoxItems(wishList);
	}
	
	private void initJComponents() {
//		System.out.println("-_-");
		viewMainPanel = super.getViewMainPanel();
		dialogCenterPanel = new JPanel();
		dialogSouthPanel = new JPanel();
		dialogSouthPanel.setPreferredSize(new Dimension(280, 200));
		
		dialogCenter_NorthPanel = new JPanel();
		dialogCenter_NorthPanel.setPreferredSize(new Dimension(280, 180));
		dialogCenter_NorthPanel.setBackground(Color.pink);
		
		dialogCenter_CenterPanel = new JPanel();
		dialogCenter_CenterPanel.setPreferredSize(new Dimension(280, 150));
		dialogCenter_CenterPanel.setBackground(Color.cyan);
		
		dialogCenter_SouthPanel = new JPanel();
		dialogCenter_SouthPanel.setPreferredSize(new Dimension(280, 180));
		dialogCenter_SouthPanel.setBackground(Color.black);
	}
	
	private void initVariables(WishingList wishList) {
		toolBox = new SomeUtilities();
	}
	
	private void layoutComponents() {
		
		viewMainPanel.add(dialogCenterPanel, BorderLayout.CENTER);
		
		dialogCenterPanel.setLayout(new BorderLayout());
		dialogCenterPanel.add(dialogCenter_NorthPanel, BorderLayout.NORTH);
		dialogCenterPanel.add(dialogCenter_CenterPanel, BorderLayout.CENTER);
		dialogCenterPanel.add(dialogCenter_SouthPanel, BorderLayout.SOUTH);
		viewMainPanel.add(dialogSouthPanel, BorderLayout.SOUTH);
	}
	
//	private void addComboBoxItems(WishingList wishList) {
//		
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
