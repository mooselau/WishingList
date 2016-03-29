package testingPart;

import javax.swing.*;
import mainPart.*;

public class TestingMain {

	public static void main(String[] args) {
		
		WishingListSample wls = new WishingListSample();
		WishingList wl = wls.getASampleWishingList();
		
		EditDialog ed = new EditDialog(wl);
		ed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ed.setVisible(true);
		
	}

}
