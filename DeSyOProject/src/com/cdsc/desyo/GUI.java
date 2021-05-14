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
import javax.swing.JScrollPane;
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
	
	private JButton btnAddProfile;
	private JButton btnModProfile;
	private JButton btnDelProfile;
	
	private JButton btnAddResource;
	private JButton btnModResource;
	private JButton btnDelResource;
	
	
	private JScrollPane scrollPaneP;
	private JScrollPane scrollPaneF;
	
	
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
		btnAddProfile = new JButton(getLabel("gui.button.add"));
		btnModProfile = new JButton(getLabel("gui.button.mod"));
		btnDelProfile = new JButton(getLabel("gui.button.del"));
		
		btnAddResource = new JButton(getLabel("gui.button.add"));
		btnModResource = new JButton(getLabel("gui.button.mod"));
		btnDelResource = new JButton(getLabel("gui.button.del"));
		
		//List<String> profileNames = startAction.getProfileNames();
		listBoxP = new JList(profileNames.toArray());
		scrollPaneP = new JScrollPane();
		scrollPaneP.setViewportView(listBoxP);
		listBoxP.setLayoutOrientation(JList.VERTICAL);
		
		listBoxF = new JList();
		scrollPaneF = new JScrollPane();
		scrollPaneF.setViewportView(listBoxF);
		listBoxF.setLayoutOrientation(JList.VERTICAL);
		
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
		btnAddProfile.setBackground(Color.LIGHT_GRAY);
		btnAddProfile.setBounds(20, 377, 100, 30);
		btnModProfile.setBackground(Color.LIGHT_GRAY);
		btnModProfile.setBounds(140, 377, 100, 30);
		btnDelProfile.setBackground(Color.LIGHT_GRAY);
		btnDelProfile.setBounds(260, 377, 100, 30);
		
		btnAddResource.setBackground(Color.LIGHT_GRAY);
		btnAddResource.setBounds(379, 377, 100, 30);
		btnModResource.setBackground(Color.LIGHT_GRAY);
		btnModResource.setBounds(499, 377, 100, 30);
		btnDelResource.setBackground(Color.LIGHT_GRAY);
		btnDelResource.setBounds(619, 377, 100, 30);
		
		

		p.add(btnAddProfile);
		p.add(btnModProfile);
		p.add(btnDelProfile);
		
		p.add(btnAddResource);
		p.add(btnModResource);
		p.add(btnDelResource);

		// setup ListBox
		listBoxP.setBounds(20, 20, 339, 350);
		listBoxP.setBackground(Color.LIGHT_GRAY);
		
		scrollPaneP.setBounds(20, 20, 339, 350);
		scrollPaneP.setBackground(Color.LIGHT_GRAY);
						
		listBoxF.setBounds(379, 20, 339, 350);
		listBoxF.setBackground(Color.LIGHT_GRAY);
		
		scrollPaneF.setBounds(379, 20, 339, 350);
		scrollPaneF.setBackground(Color.LIGHT_GRAY);
				
		p.add(scrollPaneP);
		p.add(scrollPaneF);

		
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
