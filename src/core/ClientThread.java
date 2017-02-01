package core;

import java.io.BufferedReader;
import help.ListHashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.SortedMap;

public class ClientThread implements Runnable{
	
	final static int port = 2302;
	private Socket socket;
	private BufferedReader in = null;
	private PrintStream out = null;
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
			socket.setSoTimeout(30000);
			
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    out = new PrintStream(socket.getOutputStream());
		      
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
		    
		} catch (SocketException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void playPause() throws IOException {
		String receivedData;
		out.println("playPause");
	}
	
	public void next() throws IOException{
		String receivedData;
		out.println("next");
	}
	
	public void vlaLaChanson(String song) throws IOException{
		String receivedData;
		out.println("vlalachanson"+song);
		while((receivedData = in.readLine())==null);
	}

	public String[] getPlaying() throws IOException {
		String[] playing = new String[2];
		String receivedData;
		out.println("givemeinfo");
		while((receivedData = in.readLine())==null){
			
		}
		playing[0] = receivedData;
		while((receivedData = in.readLine())==null){
			
		}
		playing[1] = receivedData;
		return playing;
	}

}
