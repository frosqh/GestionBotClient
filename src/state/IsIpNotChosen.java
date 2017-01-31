package state;

import core.ClientThread;
import core.GestionClient;
import display.ArtistChoice;

public class IsIpNotChosen implements State {

	@Override
	public void prev() {

	}

	@Override
	public void next() {
		GestionClient.setClientThread(new ClientThread(GestionClient.getIp()));
		Thread t = new Thread(GestionClient.getClientThread());
		t.start();
		System.out.println("BITE");
		while(GestionClient.getMapSong()==null){
			System.out.println(GestionClient.getMapSong());
		}
		GestionClient.getMainWindow().setArtistChoice(new ArtistChoice(GestionClient.getMainWindow().getBack(),GestionClient.getMapSong()));
		GestionClient.getMainWindow().setContentPane(GestionClient.getMainWindow().getArtistChoice());
		GestionClient.getMainWindow().setSt(new IsArtistNotChosen());
		
	}

}
