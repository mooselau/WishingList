package testingPart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.*;

import mainPart.*;

public class TestingMain {

	public static void main(String[] args) {
		
		WishingListSample wls = new WishingListSample();
		WishingList wl = wls.getASampleWishingList();
		
		//1. edit dialog
//		EditDialog ed = new EditDialog(wl);
//		ed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ed.setVisible(true);
		
		//2. edit more dialog
		EditMoreDialog em = new EditMoreDialog(wl);
		em.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		em.setVisible(true);
		
		//99. testing date and time
//		Date d = new Date();
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Calendar ca = Calendar.getInstance();
//		Date c = ca.getTime();
//		System.out.println(df.format(c));
//		ca.add(Calendar.YEAR, 100);
//		System.out.println(df.format(ca.getTime()));
	}

}

