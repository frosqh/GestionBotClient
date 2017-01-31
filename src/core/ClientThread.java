package core;

import java.io.BufferedReader;
import help.ListHashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.SortedMap;

public class ClientThread implements Runnable{
	
	final static int port = 2302;
	private Socket socket;
	private InetAddress serveur;
	
	public ClientThread(String ip){
		try {
			serveur = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		try {
			System.out.println(serveur);
			socket = new Socket(serveur, port);
			
		    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintStream out = new PrintStream(socket.getOutputStream());
		      
			out.println("coucou");
		    String receivedData = "";
		    String s ="";
		    
		    while(!receivedData.equals("\\cfini")){
		    	while((receivedData = in.readLine())==null){
		        }
		    	s+=receivedData + "\n";
		    }
		    
		    String stringFile = s;
		    
		    SortedMap<String,ArrayList<String>> mapSong = ListHashMap.ListToHash(ListHashMap.recupList(stringFile));
		    GestionClient.setMapSong(mapSong);
		    synchronized(this){
		    	wait();
		    }
		    
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
