package com.cdsc.desyo;

import java.util.List;

public class GUI {
	private ProfileManager profileManager;
	private I18NDTO i18nDTO;
	// GUI
	
	public GUI() {
		profileManager = new ProfileManager();
		i18nDTO = new StartAction().start();
		render();
	}

	public List<Resource> getAllResources(Profile profile) {
		return profileManager.getAllResources(profile);
	}
	
	public void render() {
		System.out.println(i18nDTO);
	}
}
