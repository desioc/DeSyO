package com.cdsc.desyo;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NManager {
	
	public static ResourceBundle getI18N(Locale locale) throws ConfigurationException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.DeSyO", locale);
		return resourceBundle;
	}
		
}
