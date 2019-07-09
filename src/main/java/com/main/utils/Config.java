package com.main.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {


	private static final Properties properties = new Properties();
	private static final String environmentPrefix;

	/* initialise data, the key defaults to this when none is specified at command line */
	static {
		initPropertiesFromFile();
		environmentPrefix = System.getProperty("environmentKey", "qa") + ".";

	}

	private static void initPropertiesFromFile() {
		try (InputStream stream =
				Config.class.getResourceAsStream("/propertyFiles/config.properties")) {
			properties.load(stream);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String getProperty(String s) {
		return properties.getProperty(environmentPrefix + s);
	}

	/* getters for environment properties */

	public static String getBaseURL() {
		return getProperty("baseurl");
	}
	
	
	public static String getUsername() {
		return getProperty("username");
	}

	public static String getPassword() {
		return getProperty("password");
	}

	

}

