package com.cdsc.desyo;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class StartManager {
	public static StartDTO getStartDTO() throws ConfigurationException {
		Properties configuration = ConfManager.getConfiguration();
		Locale locale = getLocale(configuration);
		ResourceBundle resourceBundle = I18NManager.getI18N(locale);
		return new StartDTO(configuration, resourceBundle);
	}
	
	private static Locale getLocale(Properties configuration) {
		Locale locale = Locale.getDefault();
		String languageKey = "language";
		String languageValue = (String) configuration.get(languageKey);
		if (languageValue != null) {
			locale = new Locale(languageValue);
		}
		return locale;
	}
}