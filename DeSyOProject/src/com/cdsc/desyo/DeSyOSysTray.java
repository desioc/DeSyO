package com.cdsc.desyo;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cdsc.areoswing.ActiveWall;

public class DeSyOSysTray implements ActiveWall {

	private List<String> profileNames;
	private List<MenuItem> profileItems;
	private MenuItem closeItem;
	private PopupMenu popupMenu;
	private SystemTray tray;
	private MenuItem separator;
	private MenuItem profileManagerItem;

	public DeSyOSysTray() {
		initSysTray();
		init();
	}

	@Override
	public void setLayouts() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setup() {
		for (MenuItem profileItem : profileItems) {
			popupMenu.add(profileItem);
		}
		popupMenu.add(separator);
		popupMenu.add(profileManagerItem);
		popupMenu.add(closeItem);
	}

	@Override
	public void addDetails() {
		profileManagerItem.setFont(new Font("sans-serif", Font.BOLD, 12));

	}


	
	@Override
	public void registerListeners() {
		profileManagerItem.addActionListener((e) -> new GUI());
		//profileManagerItem.addActionListener(this::apriGUI); //reference a metodo
		
		// classe anonima
//		profileManagerItem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println();
//				if 
//				
//				new GUI();
//				
//			}
//		});
		closeItem.addActionListener((e) -> System.exit(0));
	}

	private void initSysTray() {
		if (SystemTray.isSupported()) {
			loadPopupMenu();
			loadSysTray();
		} else {
			System.err.println("System Tray non supportata");// TODO i18n
			System.exit(0);
		}
	}

	private void loadSysTray() {
		tray = SystemTray.getSystemTray();
		try {
			tray.add(loadScaledSysTrayIcon());
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private TrayIcon loadScaledSysTrayIcon() {
		Image trayImage = Toolkit.getDefaultToolkit().getImage("img/desyo.png");
		Dimension trayIconSize = tray.getTrayIconSize();
		trayImage = trayImage.getScaledInstance(trayIconSize.width, trayIconSize.height, Image.SCALE_SMOOTH);

		TrayIcon trayIcon = new TrayIcon(trayImage, "DeSyO", popupMenu);
		return trayIcon;
	}

	private void loadPopupMenu() {
		loadProfileNames();
		for (String profileName : profileNames) {
			profileItems.add(new MenuItem(profileName));
		}
		closeItem = new MenuItem("Close");// TODO i18n
		separator = new MenuItem("-");
		profileManagerItem = new MenuItem("Gestione Profili");// TODO i18n
	}

	private void loadProfileNames() {
		profileNames = new ArrayList<>();
		profileItems = new ArrayList<>();
		popupMenu = new PopupMenu();
		profileNames.add("Python");
		profileNames.add("Formazione");
		profileNames.add("Java");
		profileNames.add("Divertimento");
		Collections.sort(profileNames);
	}
}
//public void apriGUI(ActionEvent a) {
////System.out.println();
////if...
//new GUI();
//}