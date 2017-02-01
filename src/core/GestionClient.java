package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;

import display.MainWindow;

public class GestionClient {
	//TODO Faire le TrayIcon ainsi que la minimisation à la fermeture
	//TODO Achever le choix de chanson, rendre le tout cohérent
	private static Thread t;
	private static String ip;
	private static MainWindow mainWindow;
	private static SortedMap<String,ArrayList<String>> mapSong;
	private static ClientThread clientThread;

	public static void main(String[] args) throws IOException{
		mainWindow = new MainWindow();
	}
	
	public static MainWindow getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(MainWindow mainWindow) {
		GestionClient.mainWindow = mainWindow;
	}

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		GestionClient.ip = ip;
	}

	public static SortedMap<String, ArrayList<String>> getMapSong() {
		return mapSong;
	}

	public static void setMapSong(SortedMap<String, ArrayList<String>> mapSong) {
		GestionClient.mapSong = mapSong;
	}

	public static ClientThread getClientThread() {
		return clientThread;
	}

	public static void setClientThread(ClientThread clientThread) {
		GestionClient.clientThread = clientThread;
	}

	public static Thread getT() {
		return t;
	}

	public static void setT(Thread t) {
		GestionClient.t = t;
	}

}
