package display;

import java.util.ArrayList;
import java.util.Set;
import java.util.SortedMap;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ArtistChoice extends MainLabel {

	public ArtistChoice(ImageIcon back, SortedMap<String,ArrayList<String>> mapSong) {
		super(back);
		JComboBox<String> pos = new JComboBox<String>();
		System.out.println(mapSong);
		Set<String> B = mapSong.keySet();
		B.toArray();
		for (String s : mapSong.keySet()) {
				pos.addItem(s);
		}
		add(pos);
	}

}
