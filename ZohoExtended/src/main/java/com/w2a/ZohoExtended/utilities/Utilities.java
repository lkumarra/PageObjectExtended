package com.w2a.ZohoExtended.utilities;

public class Utilities {
	
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
