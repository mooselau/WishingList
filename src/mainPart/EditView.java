package mainPart;

import java.awt.Color;
import javax.swing.*;


public abstract class EditView extends JFrame{
	
	/** GLOBAL VARIABLES */
	JPanel viewMainPanel;
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
		
		viewMainPanel = new JPanel();
		wishSelectComboBox = new JComboBox<String>();
	}

	/**
	 * Layout all necessary components.
	 */
	protected void viewLayoutComponents() {
		
		viewMainPanel.add(wishSelectComboBox);
		this.add(viewMainPanel);
		
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
	
}
