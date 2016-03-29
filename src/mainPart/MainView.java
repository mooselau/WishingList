package mainPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class MainView extends JFrame{
	
	/* Global Instances */
	private MainController mainController;
	private JPanel mainPanel;
	private JMenuBar topMenuBar;
	private JMenu newMenu, editMenu, aboutMenu;
	private JMenuItem addWishingMenuItem, printAllWishesMenuItem, editItemMenu;
	
	/* Constructor */
	public MainView() {
		
		final int WIDTH = 800, HEIGHT = 300;
		
		setTitle("@Moose A WishingList Reminder");
		setSize(WIDTH, HEIGHT);
//		setResizable(false);
		// set the UI at the center of the screen
		setLocationRelativeTo(null);
		// close the window when clicks on the close icon.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initialiseController();
		
		layoutComponents();
		
		addWindowListener();
		
	}

	/*Layout All necessary Components*/
	private void layoutComponents() {
		
		final int DEFAULT_PANEL_WIDTH = 100, DEFAULT_PANEL_HEIGHT = 5;
		
		this.setLayout(new BorderLayout());

		layoutMenuBar();
		
		mainPanel = new JPanel();
		JScrollPane mainViewScrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(mainViewScrollPane, BorderLayout.CENTER);
		
		mainViewScrollPane.setBackground(new Color(128,128,100));
		
		//Help to vertically layout components.
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(new Color(128,128,128));		
	 
	}
	
	/* Layout Menu Bar */
	private void layoutMenuBar() {
		
		final int MENU_WIDTH = 800, MENU_HEIGHT = 25;
		
		topMenuBar = new JMenuBar();
		topMenuBar.setSize(MENU_WIDTH, MENU_HEIGHT);
		this.add(topMenuBar, BorderLayout.NORTH);
		
		AddNewMenu(topMenuBar);
		AddEditMenu(topMenuBar);
		AddAboutMenu(topMenuBar);
	}
	
	/**
	 * Layout the Menu Items in New JMenu.
	 */
	private void AddNewMenu(JMenuBar topMenuBar) {
		
		newMenu = new JMenu();
		newMenu.setText("NEW");
		
		addWishingMenuItem = new JMenuItem();
		addWishingMenuItem.setText("Add Wishing!");
		addWishingMenuItem.addActionListener(mainController);
		// (QS)use action command ??
		//...
		newMenu.add(addWishingMenuItem);
		topMenuBar.add(newMenu);
	}
	
	/**
	 * Layout Menu Items in Edit Menu.
	 */
	private void AddEditMenu(JMenuBar topMenuBar) {
		
		editMenu = new JMenu();
		editMenu.setText("EDIT");
		
		editItemMenu = new JMenuItem();
		editItemMenu.setText("Edit A Wish");
		editItemMenu.setActionCommand("EDIT_A_WISH");
		editItemMenu.addActionListener(mainController);
		editMenu.add(editItemMenu);
		
		printAllWishesMenuItem = new JMenuItem();
		printAllWishesMenuItem.setText("Print ALl!");
		printAllWishesMenuItem.addActionListener(mainController);
		editMenu.add(printAllWishesMenuItem);
		topMenuBar.add(editMenu);
	}
	
	/**
	 * Layout Menu Items in About Menu.
	 */
	private void AddAboutMenu(JMenuBar topMenuBar) {
		
		aboutMenu = new JMenu();
		aboutMenu.setText("ABOUT");
		topMenuBar.add(aboutMenu);
	}
	
	/**
	 * Initialise Main Controller.
	 */
	private void initialiseController() {
		mainController = new MainController(this);
	}
	
	/** Add listeners for window events. */
	private void addWindowListener() {
		this.addWindowListener(mainController);
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	public JMenuItem getAddWishingMenuItem() {
		return addWishingMenuItem;
	}
	
	public JMenuItem getPrintAllWishesMenuItem() {
		return printAllWishesMenuItem;
	}
	
//	public JMenuItem getEditAWishMenuItem() {
//		
//	}
}
	
