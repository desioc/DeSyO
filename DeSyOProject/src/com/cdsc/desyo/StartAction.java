package com.cdsc.desyo;

public class StartAction {
	
	public StartDTO start() throws ConfigurationException {
		
		return StartFacade.getStartDTO();
	}
}
