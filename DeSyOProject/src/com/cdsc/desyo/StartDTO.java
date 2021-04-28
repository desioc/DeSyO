package com.cdsc.desyo;

import java.util.Properties;
//import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Set;


public record StartDTO(Properties configuration, ResourceBundle resources) {

	@Override
	public String toString() {

		String description = configuration + "\n";
		
//		Enumeration<String> keys = resources.getKeys();
//		while(keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			String value = resources.getString(key);
//			description += key + "=" +value + "\n";			
//		}
		
		Set<String> keySet = resources.keySet();
		for (String key : keySet) {
			String value = resources.getString(key);
			description += key + "=" +value + "\n";		
		}
		return description;
	}

}
