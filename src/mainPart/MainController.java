package mainPart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import defaultPart.SomeUtilities;

public class MainController implements ActionListener, WindowListener{

	/** Global Instances */
	private MainView mainView;
	private WishingList wishingList;
	private SomeUtilities toolBox;
	
	/** Constructor */
	public MainController(MainView mainView) {
		this.mainView = mainView;
		this.wishingList = new WishingList();
		toolBox = new SomeUtilities();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainView.getAddWishingMenuItem()) {
			addWishingOperation(toolBox.getAStringName());
		}
		else if(e.getSource() == mainView.getPrintAllWishesMenuItem()) {
			printAll();
		}

	}
	
	//print all wishes on console.
	private void printAll() {
		wishingList.displayAllWishes();
	}
	
	/**
	 * Add a new Wish in the View and wishing list;
	 * @param wishName
	 * @return
	 */
	private JPanel addAWish(String wishName) {
		
		final int DEFAULT_PANEL_WIDTH = 778, DEFAULT_PANEL_HEIGHT = 100;
		final Dimension sizeDimension = new Dimension(DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT);
		
		JPanel newWishingPanel = new JPanel();
		
		// SetPreferredSize() can make the JPanel unresizable.
		newWishingPanel.setPreferredSize(sizeDimension);
		newWishingPanel.setMaximumSize(sizeDimension);
		newWishingPanel.setBackground(toolBox.getARandomColor());
		
		JLabel newWishingNameLabel = new JLabel(wishName);
		JProgressBar newJPB = new JProgressBar();
		int percent = toolBox.getARandomPercentNumber();
		newJPB.setValue(percent);
		JLabel newWishingPercentLabel = new JLabel(String.valueOf(percent)+"%");
		newWishingPanel.add(newWishingNameLabel);
		newWishingPanel.add(newJPB);
		newWishingPanel.add(newWishingPercentLabel);
		
		wishingList.addAWish(wishName, percent);
		
		return newWishingPanel;
	}
	
	/** Add a new wish in the applicaiton. */
	private void addWishingOperation(String wishName) {
		
		JPanel newWishingPanel = addAWish(wishName);
		
		JPanel mainPanelInMainView = mainView.getMainPanel();
		mainPanelInMainView.add(newWishingPanel);
		
		//repaint the frame after revalidates all the components.
		mainView.revalidate();
		mainView.repaint();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Application is closing..");
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
