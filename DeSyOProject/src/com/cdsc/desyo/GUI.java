package com.cdsc.desyo;

import java.util.List;

public class GUI {
	//private ProfileManager profileManager;
	private StartDTO startDTO;
	// GUI
	
	public GUI() {
		//profileManager = new ProfileManager();
		try {
			startDTO = new StartAction().start();
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
		}
		render();
	}

//	public List<Resource> getAllResources(Profile profile) {
//		return profileManager.getAllResources(profile);
//	}
	
	public void render() {
		System.out.println(startDTO);
//		String profileLabel = resourceBundle.getString("gui.profile");
//		System.out.println("Label profilo = " + profileLabel);
	}
}
