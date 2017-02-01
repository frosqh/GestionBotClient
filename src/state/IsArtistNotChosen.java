package state;

import javax.swing.JFrame;

import core.GestionClient;
import display.SongChoice;

public class IsArtistNotChosen implements State{

	@Override
	public void prev() {
		GestionClient.getT().stop();
		GestionClient.getMainWindow().setSt(new IsIpNotChosen());
		GestionClient.getMainWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GestionClient.getMainWindow().setContentPane(GestionClient.getMainWindow().getIpChoice());
		GestionClient.getMainWindow().getTray().remove(GestionClient.getMainWindow().getTray().getTrayIcons()[0]);
	}

	@Override
	public void next() {
		GestionClient.getMainWindow().setSt(new IsSongNotChosen());
		GestionClient.getMainWindow().setSongChoice(new SongChoice(GestionClient.getMainWindow().getBack(),GestionClient.getMainWindow().getArtist(), GestionClient.getMapSong()));
		GestionClient.getMainWindow().setContentPane(GestionClient.getMainWindow().getSongChoice());
		
		
	}

}
