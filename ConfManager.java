package com.cdsc.desyo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfManager {
	public static Properties getConfiguration() throws ConfigurationException {
		Properties configuration = new Properties();
		loadProperties(configuration);
		return configuration;
	}
	
	public static void setConfiguration() throws ConfigurationException {
		//TODO
	}
	
	private static void storeProperties(Properties configuration) throws ConfigurationException {
		//TODO
	}
	
	private static void loadProperties(Properties configuration) throws ConfigurationException {
		try (FileInputStream inputStream = new FileInputStream("config.properties");) {
			configuration.load(inputStream);
		} catch (IOException e) {
			throw new ConfigurationException("Invalid Configuration", e);
		}
	}
}
