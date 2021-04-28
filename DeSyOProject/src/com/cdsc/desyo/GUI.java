package com.cdsc.desyo;

import java.awt.Color;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cdsc.areoswing.ActiveWall;
import com.cdsc.areoswing.Wall;

public class GUI implements ActiveWall {
	// private ProfileManager profileManager;
	private StartDTO startDTO;
	// GUI
	private JPanel p;
	private JFrame frame;
	private JButton saveButton;
	private JButton btnAggiungi;
	private JButton btnScegli;
	private JButton btnCreaProfilo;
	private JList listBoxP;
	private JList listBoxF;
	private String[] ar = { "Formazione", "Produzione" };

	public GUI() {
		// profileManager = new ProfileManager();
		try {
			startDTO = new StartAction().start();
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
		}
		render();
		frame = new JFrame("DeSyO");
		p = new JPanel();
		saveButton = new JButton("Salva");
		btnAggiungi = new JButton("Aggiungi + ");
		btnScegli = new JButton("Scegli");
		listBoxP = new JList(ar);
		listBoxF = new JList();
		init();
	}

	public void setup() {
		// setup frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 759, 453);

		// setPanel
		p.setBackground(new Color(255, 255, 255));
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setLayout(null);// Layout Absolute
		frame.add(p);

		// setup button
		saveButton.setBackground(Color.LIGHT_GRAY);
		saveButton.setBounds(50, 300, 100, 30);
		btnAggiungi.setBackground(Color.LIGHT_GRAY);
		btnAggiungi.setBounds(450, 300, 100, 30);
		btnScegli.setBackground(Color.LIGHT_GRAY);
		btnScegli.setBounds(600, 300, 100, 30);

		p.add(saveButton);
		p.add(btnAggiungi);
		p.add(btnScegli);

		// setup ListBox
		listBoxP.setBounds(50, 50, 200, 200);
		listBoxP.setBackground(Color.LIGHT_GRAY);
		listBoxF.setBounds(450, 50, 255, 200);
		listBoxF.setBackground(Color.LIGHT_GRAY);
		p.add(listBoxP);
		p.add(listBoxF);

		frame.setVisible(true);
	}
//	public List<Resource> getAllResources(Profile profile) {
//		return profileManager.getAllResources(profile);
//	}

	public void render() {
		System.out.println(startDTO);
//		String profileLabel = resourceBundle.getString("gui.profile");
//		System.out.println("Label profilo = " + profileLabel);
	}

	@Override
	public void setLayouts() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerListeners() {
		// TODO Auto-generated method stub
		
	}
}
