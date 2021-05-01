package lockedMe;

import java.io.IOException;

public class GenericFeatures {
	
	private static final String welcomeMsg = 
			"#####################     Welcome to LockedMe.com     #####################" +
					"\n#####################       By Lockers Pvt. Ltd.      #####################";
	private static final String devDetails = 
			"#####################    Developed by Yogesh Ghorad   #####################" +
					"\n#####################  Email: yogeshghorad@gmail.com  #####################";
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(welcomeMsg);
		System.out.println(devDetails);
		PrimaryScreen menu = new PrimaryScreen();
		menu.showPrimaryMenu();
		
	}

}
