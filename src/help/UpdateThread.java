package help;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.SocketException;

import core.GestionClient;

public class UpdateThread implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				update();
			} catch(SocketException e)  {
				e.printStackTrace();
				GestionClient.getMainWindow().displayMessage2("Serveur déconnecté");
				final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null) runnable.run();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	private void update() throws IOException {
		String playing[] = GestionClient.getClientThread().getPlaying();
		if (!playing[0].equals(GestionClient.getMainWindow().getAboutItem().getLabel()) && !playing[0].equals("Aucune musique n'est jouée !")){
			GestionClient.getMainWindow().displayMessage(playing[0]);
			GestionClient.getMainWindow().getAboutItem().setLabel(playing[0]);
		}
		if (GestionClient.getMainWindow().getArtistChoice() != null){
			GestionClient.getMainWindow().getArtistChoice().updateInfo(playing[0],playing[1]);
		}
		if (GestionClient.getMainWindow().getSongChoice() != null){
			GestionClient.getMainWindow().getSongChoice().updateInfo(playing[0],playing[1]);
		}
	}

}
