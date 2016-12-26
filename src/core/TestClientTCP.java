package core;

import java.net.*;
import java.io.*;

public class TestClientTCP {
  final static int port = 2302;

  public static void main(String[] args) {

    Socket socket;
    
    try {
      InetAddress serveur = InetAddress.getByName("localhost");
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
      //System.out.println(s.length());
      }
      //System.out.println("BITE");
      out.println("vlalachanson Adrenaline");
      System.out.println(in.readLine());
      while(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}