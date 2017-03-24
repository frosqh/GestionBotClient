package display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.GestionClient;

@SuppressWarnings("serial")
public class ArtistChoice extends MainLabel {
	private JPanel choix = new JPanel();
	private JPanel bouton = new JPanel();
	private JButton apply = new JButton("Valider");
	private JButton quit = new JButton("Retour");
	private JLabel playing = new JLabel("Aucune musique n'est jouée !");
	private JLabel waiting = new JLabel("Aucune musique dans la liste d'attente");
	private JPanel updatePanel = new JPanel();
	private JPanel coucou2 = new JPanel();
	private JPanel coucou3 = new JPanel();
	private JPanel coucou4 = new JPanel();
	private JLabel choixArtiste = new JLabel("Choix d'artiste : ");
	
	public ArtistChoice(ImageIcon back, SortedMap<String,ArrayList<String>> mapSong) {
		super(back);
		choix.setLayout(new FlowLayout());
		updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.PAGE_AXIS));
		bouton.setLayout(new FlowLayout());
		choix.setBackground(new Color(0,0,0,1));
		bouton.setBackground(new Color(0,0,0,1));
		updatePanel.setBackground(new Color(0,0,0,1));
		coucou2.setBackground(new Color(0,0,0,1));
		coucou3.setBackground(new Color(0,0,0,1));
		coucou4.setBackground(new Color(0,0,0,1));
		choixArtiste.setBackground(new Color(0,0,0,1));
		
		
		
		
		JComboBox<String> pos = new JComboBox<String>();
		System.out.println(mapSong);
		Set<String> B = mapSong.keySet();
		B.toArray();
		for (String s : mapSong.keySet()) {
				pos.addItem(s);
		}
		
		apply.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionClient.getMainWindow().setArtist((String) pos.getSelectedItem());
				GestionClient.getMainWindow().next();
			}
			
		});
		
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionClient.getMainWindow().getSt().prev();
			}
			
		});
		
		updatePanel.add(playing);
		updatePanel.add(waiting);
		
		choix.add(choixArtiste);
		choix.add(pos);
		
		bouton.add(apply);
		bouton.add(quit);
		
		add(updatePanel);
		add(choix);
		add(coucou3);
		add(bouton);
		add(coucou4);
		add(coucou2);
	}
	
	@Override
	public void updateInfo(String playingS, String waitingS){
		playing.setText(playingS);
		waiting.setText(waitingS);
		GestionClient.getMainWindow().revalidate();
		GestionClient.getMainWindow().repaint();
	}

}
