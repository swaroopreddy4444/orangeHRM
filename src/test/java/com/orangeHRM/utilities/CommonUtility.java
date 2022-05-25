package com.orangeHRM.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtility {

	public static String getProperty(String FileName, String Key) {

		try {
			FileInputStream fis = new FileInputStream(".\\testdata\\" + FileName + ".properties");

			Properties file = new Properties();
			file.load(fis);
			return file.getProperty(Key);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return null;
	}
}
