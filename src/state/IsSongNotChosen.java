package state;

import core.GestionClient;

public class IsSongNotChosen implements State {

	@Override
	public void prev() {
		GestionClient.getMainWindow().setSt(new IsArtistNotChosen());
		GestionClient.getMainWindow().setContentPane(GestionClient.getMainWindow().getArtistChoice());
	}

	@Override
	public void next() {
		
	}

}
