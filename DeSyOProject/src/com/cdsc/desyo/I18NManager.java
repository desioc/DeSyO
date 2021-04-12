package com.cdsc.desyo;

import java.util.Properties;

public class I18NManager {
	public I18NDTO getI18NDTO() {
		//return null;//TODO
		Properties properties = new Properties();
		properties.put("pippo", "pluto");
		properties.put("archimede", "clarabella");
		return new I18NDTO("IT", properties);
	}
}
