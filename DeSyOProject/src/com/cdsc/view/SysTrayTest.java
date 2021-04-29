package com.cdsc.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SysTrayTest {
	
	 	 
	 public static void main(String[] args) throws AWTException {
		 
		 // List String di profili MOCK
		 List<String> profili = new ArrayList<String>();
		 
		 // List di oggetti MenuItem per popolare popup menù
		 // con tutti i profili disponibili
		 List<MenuItem> profilo = new ArrayList<MenuItem>();
		 
		 // MOCK dei profili per test --
		 profili.add("Python");
		 profili.add("Formazione");
		 profili.add("Java");
		 profili.add("Divertimento");
		 Collections.sort(profili);
		 //---------------------------	--
		
		 
		 if (SystemTray.isSupported()) {
	            SystemTray tray = SystemTray.getSystemTray();
	            PopupMenu popupMenu = new PopupMenu();
	            
	            //Image image = Toolkit.getDefaultToolkit().getImage("img/desyo_st.png");
	            TrayIcon trayIcon = new TrayIcon(imageForTray(tray), "DeSyO", popupMenu);
	            
	            
	            MenuItem closeItem = new MenuItem("Close");
	            closeItem.addActionListener((e) -> System.exit(0));
	            
	            // Ciclo for per riempire la lista di MenuItem con il nome dei profili
	            // disponibili
	            for (int i= 0; i < profili.size(); i++) {
	            	String nomeProfiloMenuItem = profili.get(i);
	            	profilo.add(new MenuItem(nomeProfiloMenuItem));
	            	popupMenu.add(profili.get(i));
				}
	            
	            
	            MenuItem separator = new MenuItem("-");
	            
	            
	            MenuItem infoItem = new MenuItem("Info");
	            
	            
	            MenuItem gestioneProfiliItem = new MenuItem("Gestione Profili");
	            Font f = new Font("sans-serif", Font.BOLD, 12);
	            gestioneProfiliItem.setFont(f);
	           
	            
	            infoItem.addActionListener((e) -> trayIcon.displayMessage("SystemTrayExample",
	                    "If we want everything to remain as it is, everything must change.", TrayIcon.MessageType.INFO));
	            
	            popupMenu.add(separator);
	            popupMenu.add(gestioneProfiliItem);
	            popupMenu.add(infoItem);
	            
	            
	            popupMenu.add(closeItem);
	            tray.add(trayIcon);
	        }
	        
	        

}
	 
	 
	 // metodo che scala la dimensione dell'immagine icon, proporzionandola
	 // all'area disponibile nel systray
	 public static Image imageForTray(SystemTray theTray){

		    Image trayImage = Toolkit.getDefaultToolkit().getImage("img/desyo.png");
		    Dimension trayIconSize = theTray.getTrayIconSize();
		    trayImage = trayImage.getScaledInstance(trayIconSize.width, trayIconSize.height, Image.SCALE_SMOOTH);

		    return trayImage;
		}
}
