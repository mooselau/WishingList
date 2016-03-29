package mainPart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import defaultPart.SomeUtilities;

public class MainController implements ActionListener, WindowListener, MouseListener{

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
		else if(e.getActionCommand().equals("EDIT_A_WISH")) {
			EditDialog editDialog = new EditDialog(wishingList);
			editDialog.setVisible(true);
		}

	}
	
	//print all wishes on console.
	private void printAll() {
		wishingList.displayAllWishes();
	}
	
	//..
	private JPanel addAWishOnPanel(String wishName, int percent) {
		
		final int DEFAULT_PANEL_WIDTH = 778, DEFAULT_PANEL_HEIGHT = 100;
		final Dimension sizeDimension = new Dimension(DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT);
		
		JPanel newWishingPanel = new JPanel();
		
		// SetPreferredSize() can make the JPanel unresizable.
		newWishingPanel.setPreferredSize(sizeDimension);
		newWishingPanel.setMaximumSize(sizeDimension);
		newWishingPanel.setBackground(toolBox.getARandomColor());
		
		JLabel newWishingNameLabel = new JLabel(wishName);
		JProgressBar newJPB = new JProgressBar();
		newJPB.setValue(percent);
		JLabel newWishingPercentLabel = new JLabel(String.valueOf(percent)+"%");
		newWishingPanel.add(newWishingNameLabel);
		newWishingPanel.add(newJPB);
		newWishingPanel.add(newWishingPercentLabel);
		
		return newWishingPanel;
	}
	
	/**
	 * Add a new Wish in the View and wishing list;
	 * @param wishName
	 * @return
	 */
	private JPanel addAWish(String wishName) {
		
		//For adding on Wishing List.
		int percent = toolBox.getARandomPercentNumber();
		wishingList.addAWish(wishName, percent);		
		
		//Belows are for adding on JPanel.
		JPanel newWishingPanel = addAWishOnPanel(wishName, percent);
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
	
	
	//For windows listeners.
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

	
	//For mouse listeners.
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getClickCount()>=2) {
			toolBox.printThis("You just click the Panel 2 or more times!");
		}
		else if(SwingUtilities.isLeftMouseButton(e)) {
			toolBox.printThis("You just clicked the Left Button!!");
		}
		else if(SwingUtilities.isRightMouseButton(e)) {
			toolBox.printThis("You just clicked the Right Button!!");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
