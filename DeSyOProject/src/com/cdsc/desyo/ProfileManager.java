package com.cdsc.desyo;

import java.util.ArrayList;
import java.util.List;

public class ProfileManager {
	
	public Profile getProfile(String name) {
		// TODO
		// andare sull'harddisk e caricare il file XML con il nome 
		// specificato e rilanciare eventuali eccezioni (da creare ProfileException)
		// una volta caricato il file XML, estrarre i dati e creare un oggetto Profile 
		// con le sue risorse e restituirlo
		return null;
	}
	
	public static List<String> getProfileNames(){
		//TODO Raffaele
		//TODO test Andrea M.
		//MOCK
		List<String> profileNames = new ArrayList<>();
		profileNames.add("Python");
		profileNames.add("Divertimento");
		return profileNames;
	} 
	
	
}
