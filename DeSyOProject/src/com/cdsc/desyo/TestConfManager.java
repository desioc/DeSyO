package com.cdsc.desyo;

import java.util.Properties;

public class TestConfManager {

	public static void main(String[] args) throws ConfigurationException {
		Properties configuration = ConfManager.getConfiguration();
		System.out.println(configuration);
		
		GUI gui = new GUI();
		gui.setup();
		
	}

}
