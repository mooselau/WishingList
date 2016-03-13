package mainPart;

import java.awt.event.*;
import javax.swing.*;
import defaultPart.SomeUtilities;

public class MainController implements ActionListener, WindowListener{

	/** Global Instances */
	private MainView mainView;
	
	/** Constructor */
	public MainController(MainView mainView) {
		this.mainView = mainView;
		SomeUtilities toolbox = new SomeUtilities();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainView.getAddWishingMenuItem()) {
			addWishingOperation();
			System.out.println("An item is added..");
		}

	}
	
	/** Add a new wish in the applicaiton. */
	private void addWishingOperation() {
		
		final int DEFAULT_PANEL_WIDTH = 790, DEFAULT_PANEL_HEIGHT = 100;
		
		JPanel newWishingPanel = new JPanel();
		newWishingPanel.setSize(DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT);
		JProgressBar newJPB = new JProgressBar();
		newJPB.setValue(80);
		newWishingPanel.add(newJPB);
		
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
