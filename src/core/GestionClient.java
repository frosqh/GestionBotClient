package core;

import java.io.IOException;

import display.MainWindow;

public class GestionClient {

	private static String ip;
	private static MainWindow mainWindow;

	public static void main(String[] args) throws IOException{
		mainWindow = new MainWindow();
	}
	
	public static MainWindow getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(MainWindow mainWindow) {
		GestionClient.mainWindow = mainWindow;
	}

	public String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		GestionClient.ip = ip;
	}

}
