package state;

import core.GestionClient;
import display.SongChoice;

public class IsArtistNotChosen implements State{

	@Override
	public void prev() {
		GestionClient.getMainWindow().setSt(new IsIpNotChosen());
		GestionClient.getMainWindow().setContentPane(GestionClient.getMainWindow().getIpChoice());
	}

	@Override
	public void next() {
		GestionClient.getMainWindow().setSt(new IsSongNotChosen());
		
		GestionClient.getMainWindow().setSongChoice(new SongChoice(GestionClient.getMainWindow().getBack()));
		
		
	}

}
