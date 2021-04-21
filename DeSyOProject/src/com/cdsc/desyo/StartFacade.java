package com.cdsc.desyo;

public class StartFacade {
	public static StartDTO getStartDTO() throws ConfigurationException {
		
		return StartManager.getStartDTO();
	}
}
