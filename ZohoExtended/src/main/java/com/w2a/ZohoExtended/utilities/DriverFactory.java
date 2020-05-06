package com.w2a.ZohoExtended.utilities;

public class DriverFactory {

	private static String configPropertyFile;
	private static String gridPath;
	private static boolean isRemote;

	public static boolean isRemote() {
		return isRemote;
	}

	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}

	public static String getConfigPropertyFile() {
		return configPropertyFile;
	}

	public static void setConfigPropertyFile(String configPropertyFile) {
		DriverFactory.configPropertyFile = configPropertyFile;
	}

	public static String getGridPath() {
		return gridPath;
	}

	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}

}
