package com.cdsc.desyo;

public class StartAction {
	
	public I18NDTO start() {
		I18NManager manager = new I18NManager();
		I18NDTO i18nDTO = manager.getI18NDTO();
		return i18nDTO;
	}
}
