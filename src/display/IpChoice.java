package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.GestionClient;

public class IpChoice extends MainLabel{

	private JTextField ipInput = new JTextField("frosqh.ddns.net");
	private JLabel labe1 = new JLabel("IP : ");
	private JPanel textPanel = new JPanel();
	private JPanel bouton = new JPanel();
	private JButton apply = new JButton("Connecter");
	private JButton quit = new JButton("Quitter");
	
	public IpChoice(ImageIcon back) {
		super(back);
		
		apply.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionClient.setIp(ipInput.getText());
				GestionClient.getMainWindow().next();
			}
		});
		
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		textPanel.add(labe1);
		textPanel.add(ipInput);
		bouton.add(apply);
		bouton.add(quit);
		add(textPanel);
		add(bouton);
		
		
	}

}
