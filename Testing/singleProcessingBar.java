import java.awt.Color;

import javax.swing.*;


public class singleProcessingBar extends JFrame{
	
	public singleProcessingBar() {
		// TODO Auto-generated constructor stub
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	jf.add(jp);
	
	jp.setBackground(new Color(123456));
	//Exit the program when click on the icon.
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
	jf.setSize(600, 600);
//	jf.setLocationRelativeTo(null);
	
	JProgressBar jpb = new JProgressBar();
	jpb.setValue(65);
	jp.add(jpb);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singleProcessingBar spb = new singleProcessingBar();

	}

}
