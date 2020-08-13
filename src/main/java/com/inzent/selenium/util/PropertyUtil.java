package com.inzent.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil
{
	private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

	// 설정파일의 full path name
	private static final String CONFIG_ROPERTY_FILE_NAME = System.getProperty("user.dir")
					+ "./conf/application.properties";

	// 읽어온 설정파일의 property 들을 저장할 Properties 객체
	private static Properties config_properties;

	/**
	 * 설정파일을 클래스 로딩시 단한번 읽어온다.
	 */
	static
	{
//		config_properties = load(CONFIG_ROPERTY_FILE_NAME);
	}

	/**
	 * 설정파일을 읽어 Properties 객체에 로드하여 반환한다.
	 * 
	 * @param propertyFileName
	 * @return Properties
	 */
	private static Properties load(String propertyFileName)
	{
		Properties properties = null;

		try
		{
			FileInputStream fileInputStream = new FileInputStream(propertyFileName);

			properties = new Properties();
			properties.load(new BufferedInputStream(fileInputStream));
		}
		catch (FileNotFoundException ex)
		{
			logger.debug("[" + propertyFileName + "] : FileNotFoundException");
			ex.printStackTrace(System.out);
		}
		catch (IOException ex)
		{
			ex.printStackTrace(System.out);
		}
		catch (Exception ex)
		{
			ex.printStackTrace(System.out);
		}

		return properties;
	}

	/**
	 * 설정파일(config.properties)의 해당 property 값을 key 값으로 조회하여 String 으로 반환.
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfigValue(String key)
	{
		config_properties = load(CONFIG_ROPERTY_FILE_NAME);
		return config_properties.getProperty(key);
	}

	public static void setConfigValue(String key, String value) throws FileNotFoundException, IOException
	{
		config_properties = load(CONFIG_ROPERTY_FILE_NAME);
		config_properties.setProperty(key, value);

		config_properties.store(new FileOutputStream(CONFIG_ROPERTY_FILE_NAME), null);
	}
	
	@SuppressWarnings("unused")
	private static String getPath(String propName)
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		if (classLoader == null)
			classLoader = ClassLoader.getSystemClassLoader();

		URL url = classLoader.getResource(propName);

		logger.debug("getPath():" + url.getPath());
		return url.getPath();
	}
}
