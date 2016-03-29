package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


public class EditView extends JFrame{
	
	/** GLOBAL VARIABLES */
	JPanel viewMainPanel, viewSelectorPanel;
	JComboBox<String> wishSelectComboBox;
	
	
	/** Constructor */
	public EditView() {
		
		initJComponents();
		viewLayoutComponents();
	}
	
	/**
	 * Initiate all necessary components.
	 */
	private void initJComponents() {
		
		viewSelectorPanel = new JPanel();
		viewSelectorPanel.setPreferredSize(new Dimension(300,30));
		viewSelectorPanel.setBackground(Color.green);
		viewMainPanel = new JPanel();
		wishSelectComboBox = new JComboBox<String>();
	}

	/**
	 * Layout all necessary components.
	 */
	protected void viewLayoutComponents() {
		
		viewSelectorPanel.add(wishSelectComboBox);
		viewMainPanel.add(viewSelectorPanel);
		this.add(viewMainPanel, BorderLayout.NORTH);
		
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
