package display;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import state.IsIpNotChosen;
import state.State;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	private State st;
	private MainLabel ipChoice;
	private MainLabel ArtistChoice;
	private ImageIcon back;
	
	public MainWindow() throws IOException{
		setSt(new IsIpNotChosen());
		
		setResizable(true);
		setSize(900,600);
		setTitle("Bot Paikea");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		back = new ImageIcon(ImageIO.read(getClass().getResource("/resources/patate.jpeg")));
		ipChoice = new IpChoice(back);
		this.setContentPane(ipChoice);
		setIconImage(ImageIO.read(getClass().getResource("/resources/musique.jpeg")));
		
		setVisible(true);

	}

	public State getSt() {
		return st;
	}

	public void setSt(State st) {
		this.st = st;
	}

	public void next() {
		st.next();
	}
	
	public void prev() {
		st.prev();
	}

	public MainLabel getArtistChoice() {
		return ArtistChoice;
	}

	public void setArtistChoice(MainLabel artistChoice) {
		ArtistChoice = artistChoice;
	}

	public ImageIcon getBack() {
		return back;
	}

}
