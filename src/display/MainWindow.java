package display;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import core.GestionClient;
import state.IsIpNotChosen;
import state.State;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	private State st;
	private String artist;
	private MainLabel ipChoice;
	private MainLabel ArtistChoice;
	private MainLabel songChoice;
	private ImageIcon back;
	private PopupMenu popup;
	private MenuItem aboutItem;
	private SystemTray tray;
	
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

	public void setSystemTray() throws IOException {
		if (!SystemTray.isSupported()){
			System.out.println("System Tray is not supported");
		}
		else{
			popup = new PopupMenu();
			BufferedImage a = ImageIO.read(getClass().getResource("/resources/musique.jpg"));
			Image b = (Image) a;
			TrayIcon trayIcon = new TrayIcon(b);
			tray = SystemTray.getSystemTray();
			
			aboutItem = new MenuItem("WichPlaying");
			MenuItem pausePlayItem = new MenuItem("Pause/Play");
			MenuItem nextItem = new MenuItem("Next");
			MenuItem exitItem = new MenuItem("Exit");
			
			CheckboxMenuItem cb = new CheckboxMenuItem("Afficher les notifications");
			
			
			popup.add(aboutItem);
			popup.addSeparator();
			popup.add(cb);
			popup.addSeparator();
			popup.add(pausePlayItem);
			popup.add(nextItem);
			popup.add(exitItem);
			
			trayIcon.setPopupMenu(popup);
			
			aboutItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(true);
					
				}
				
			});
			
			pausePlayItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						GestionClient.getClientThread().playPause();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
			});
			
			nextItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						GestionClient.getClientThread().next();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			});
			
			exitItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
				
			});
			
			try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void setNotExitable(){
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
			}
		});
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

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getArtist(){
		return artist;
	}

	public void setSongChoice(SongChoice songChoice2) {
		songChoice = songChoice2;		
	}

	public MainLabel getIpChoice() {
		return ipChoice;
	}

	public void setIpChoice(MainLabel ipChoice) {
		this.ipChoice = ipChoice;
	}

	public SystemTray getTray() {
		return tray;
	}

	public MainLabel getSongChoice() {
		return songChoice;
	}

	public void setSongChoice(MainLabel songChoice) {
		this.songChoice = songChoice;
	}
	
	public void displayMessage(String msg){
		tray.getTrayIcons()[0].displayMessage("Musique jouée", msg, TrayIcon.MessageType.INFO);
}

	public MenuItem getAboutItem() {
		return aboutItem;
	}
}
