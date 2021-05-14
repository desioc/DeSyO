package com.cdsc.desyo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cdsc.areoswing.ActiveWall;


public class GUI implements ActiveWall {
	
	// Unica istanza della classe - Resa classe singleton 210514 - AG
	private static GUI instance = null; 
	
	
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
	
	private List<String> profileNames;
	
	private ResourceBundle resources;
	
	// Resa classe singleton 210514 - AG
	public static GUI getInstance(List<String> list, StartDTO startDTO) {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
        	
            instance = new GUI(list, startDTO);
        }
        return instance;
    }
 
	
	
	// Costruttore invisibile - Resa classe singleton 210514 - AG
	private GUI(List<String> profileNames, StartDTO startDTO) {
		
		this.profileNames = profileNames;
		this.startDTO = startDTO;

		resources = startDTO.resources();
		//String language = startDTO.configuration().getProperty("language");
		log();
		frame = new JFrame("DeSyO");
		p = new JPanel();
		saveButton = new JButton(getLabel("gui.button.save"));
		btnAggiungi = new JButton("Aggiungi + ");
		btnScegli = new JButton("Scegli");
		//List<String> profileNames = startAction.getProfileNames();
		listBoxP = new JList(profileNames.toArray());
		listBoxF = new JList();
		init();
	}



	public void setup() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screen.getWidth() - (screen.getWidth()) /2);
		int y = (int) (screen.getHeight() -(screen.getHeight()) /2);
		int dimXFrame = 759;
		int dimYFrame = 453;
		
		
		// setup frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds((x-(dimXFrame/2)), (y-(dimYFrame/2)), dimXFrame, dimYFrame);
		frame.setDefaultCloseOperation(2);
		
	

		// setPanel
		p.setBackground(new Color(255, 255, 255));
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setLayout(null);// Layout Absolute
		//p.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT); //set X alignment center
		//p.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT); //set Y alignment center
		frame.add(p);

		// setup button
		saveButton.setBackground(Color.LIGHT_GRAY);
		saveButton.setBounds(20, 380, 100, 30);
		btnAggiungi.setBackground(Color.LIGHT_GRAY);
		btnAggiungi.setBounds(450, 380, 100, 30);
		btnScegli.setBackground(Color.LIGHT_GRAY);
		btnScegli.setBounds(600, 380, 100, 30);

		p.add(saveButton);
		p.add(btnAggiungi);
		p.add(btnScegli);

		// setup ListBox
		listBoxP.setBounds(20, 20, 339, 350);
		listBoxP.setBackground(Color.LIGHT_GRAY);
		listBoxF.setBounds(379, 20, 339, 350);
		listBoxF.setBackground(Color.LIGHT_GRAY);
		p.add(listBoxP);
		p.add(listBoxF);

		
		// Aggiunto listener con override di windowClosing
		// in modo tale che intercettando l'evdnto di chiusura
		// imposti instance nuovamente a null per permettere
		// la riapertura della GUI alla prossima richiesta da parte 
		// della DeSyOSysTray
		frame.addWindowListener(new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent e) {
	            super.windowClosing(e); 
	            //JOptionPane.showConfirmDialog(null,"Are sure to close!");
	            instance=null;
	        }

	        
	    });

		frame.setVisible(true);
	}
//	public List<Resource> getAllResources(Profile profile) {
//		return profileManager.getAllResources(profile);
//	}

	public void log() {
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
	


	
	private String getLabel(String key) {
		return resources.getString(key);
	}
}
