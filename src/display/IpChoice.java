package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.GestionClient;

@SuppressWarnings("serial")
public class IpChoice extends MainLabel{

	private JTextField ipInput = new JTextField("frosqh.ddns.net");
	private JLabel labe1 = new JLabel("IP : ");
	private JPanel textPanel = new JPanel();
	private JPanel bouton = new JPanel();
	private JPanel coucou = new JPanel();
	private JPanel coucou2 = new JPanel();
	private JPanel coucou3 = new JPanel();
	private JPanel coucou4 = new JPanel();
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
		textPanel.setBackground(new Color(0,0,0,1));
		labe1.setBackground(new Color(0,0,0,1));
		textPanel.add(ipInput);
		bouton.add(apply);
		bouton.add(quit);
		bouton.setBackground(new Color(0,0,0,1));
		coucou.setBackground(new Color(0,0,0,1));
		coucou2.setBackground(new Color(0,0,0,1));
		coucou3.setBackground(new Color(0,0,0,1));
		coucou4.setBackground(new Color(0,0,0,1));
		add(coucou);
		add(textPanel);
		add(coucou3);
		add(bouton);
		add(coucou2);
		add(coucou4);
		
		
	}

}
