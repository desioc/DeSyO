package com.cdsc.desyo;

import java.util.List;

public class StartAction {
	
	public StartDTO start() throws ConfigurationException {
		
		return StartFacade.getStartDTO();
	}

	public List<String> getProfileNames() {
		
		return StartFacade.getProfileNames();
	}
}
