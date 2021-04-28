package com.cdsc.desyo;

import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class StartService {
	public static StartDTO getStartDTO() throws ConfigurationException {
		Properties configuration = ConfManager.getConfiguration();
		Locale locale = getLocale(configuration);
		ResourceBundle resourceBundle = I18NManager.getI18N(locale);
		return new StartDTO(configuration, resourceBundle);
	}

	/*
	 * Restituisce un locale configurato nel file di properties se presente,
	 * altrimenti il locale di default del sistema operativo
	 */
	private static Locale getLocale(Properties configuration) {
		Locale locale = Locale.getDefault();// restituisce la lingua del sistena operativo
		String languageKey = "language";
		String languageValue = (String) configuration.get(languageKey);
		if (languageValue != null) {
			locale = new Locale(languageValue);
		}
		return locale;
	}

	public static List<String> getProfileNames() {
		return ProfileManager.getProfileNames();
	}
}