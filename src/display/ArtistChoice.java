package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.GestionClient;

@SuppressWarnings("serial")
public class ArtistChoice extends MainLabel {
	private JPanel choix;
	private JPanel bouton;
	private JButton apply = new JButton("Valider");
	private JButton quit = new JButton("Retour");
	private JPanel coucou = new JPanel();
	private JPanel coucou2 = new JPanel();
	private JPanel coucou3 = new JPanel();
	private JPanel coucou4 = new JPanel();
	private JLabel choixArtiste = new JLabel("Choix d'artiste : ");
	public ArtistChoice(ImageIcon back, SortedMap<String,ArrayList<String>> mapSong) {
		super(back);
		choix.setBackground(new Color(0,0,0,1));
		bouton.setBackground(new Color(0,0,0,1));
		coucou.setBackground(new Color(0,0,0,1));
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
		
		choix.add(choixArtiste);
		choix.add(pos);
		
		bouton.add(apply);
		bouton.add(quit);
		
		
		add(choix);
		add(bouton);
	}

}
