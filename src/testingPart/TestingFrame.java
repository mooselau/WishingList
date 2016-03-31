package testingPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class TestingFrame extends JFrame{

	JPanel mainPanel, jp1, jp2, jp3, jp4, jp5, jppp;
	JButton jb;
	
	TestingFrame() {
	
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.gray);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jppp = new JPanel();
		
		jb = new JButton("HAHA~");
		
		layoutComp();
	}
	
	private void layoutComp() {
		
		this.setSize(400, 250);
		this.add(mainPanel);
		this.setLocationRelativeTo(null);
		
		mainPanel.setLayout(new BorderLayout());

		jp3.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(jp3, BorderLayout.NORTH);

		jp4.setBackground(Color.cyan);
		mainPanel.add(jp4, BorderLayout.SOUTH);

//		jp1.setSize(100, 50);
		jp1.setBackground(Color.pink);
		mainPanel.add(jp1, BorderLayout.WEST);

//		jp2.setSize(100, 50);
		jp2.setBackground(Color.darkGray);
		mainPanel.add(jp2, BorderLayout.EAST);
		
		jp5.setLayout(new BorderLayout());
		
		jb.setPreferredSize(new Dimension(100, 20));
		jb.setMaximumSize(new Dimension(100, 20));
		jppp.add(jb);
		
		jp5.add(jppp,  BorderLayout.CENTER);
		jp5.setBackground(Color.magenta);
		mainPanel.add(jp5, BorderLayout.CENTER);
		
	}
	
	
	
	public static void main(String[] args) {

		TestingFrame tf = new TestingFrame();
		tf.setVisible(true);
	}

}
