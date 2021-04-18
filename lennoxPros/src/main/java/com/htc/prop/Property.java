package com.htc.prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.htc.constants.Constants;

public class Property {
	
	
	public Properties getProp() {
		Properties	prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(Constants.PROPERTI_FILE_PATH);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
