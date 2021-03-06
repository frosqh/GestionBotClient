package state;

import java.io.IOException;

import core.ClientThread;
import core.GestionClient;
import display.ArtistChoice;
import help.UpdateThread;

public class IsIpNotChosen implements State {
	private int bite;

	@Override
	public void prev() {

	}

	@Override
	public void next() {
		GestionClient.setClientThread(new ClientThread(GestionClient.getIp()));
		Thread t = new Thread(GestionClient.getClientThread());
		t.start();
		try {
			GestionClient.getMainWindow().setSystemTray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(GestionClient.getMapSong()==null){
			System.out.print("");
		}
		GestionClient.getMainWindow().setArtistChoice(new ArtistChoice(GestionClient.getMainWindow().getBack(),GestionClient.getMapSong()));
		GestionClient.getMainWindow().setContentPane(GestionClient.getMainWindow().getArtistChoice());
		GestionClient.getMainWindow().setSt(new IsArtistNotChosen());
		GestionClient.getMainWindow().setNotExitable();
		Thread t2 = new Thread(new UpdateThread());
		GestionClient.setT(t2);
		t2.start();
	}

}
