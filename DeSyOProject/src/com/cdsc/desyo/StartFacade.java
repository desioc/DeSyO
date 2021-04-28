package com.cdsc.desyo;

import java.util.List;

public class StartFacade {
	public static StartDTO getStartDTO() throws ConfigurationException {
		return StartService.getStartDTO();
	}

	public static List<String> getProfileNames() {
		return StartService.getProfileNames();
	}
}
