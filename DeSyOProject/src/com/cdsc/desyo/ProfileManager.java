package com.cdsc.desyo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileManager {
	
	
	public Profile getProfile(String name) {
		// TODO
		// andare sull'harddisk e caricare il file XML con il nome 
		// specificato e rilanciare eventuali eccezioni (da creare ProfileException)
		
		// una volta caricato il file XML, estrarre i dati e creare un oggetto Profile 
		// con le sue risorse e restituirlo (vedi XPath)
		return null;
	}
	
	public static List<String> getProfileNames(){
		File profileFolder = new File("profiles");
		List<String> profileNames = new ArrayList<>();
		//if (!(profileFolder.exists() && profileFolder.isDirectory())) lancio eccezione
		File[] profileFiles = profileFolder.listFiles();
		for (File profileFile : profileFiles) {
			String profileName = profileFile.getName();
			profileNames.add(profileName.substring(0, profileName.lastIndexOf('.')));
		}
		//TODO test Andrea M.
		return profileNames;
	} 
	
	
}
