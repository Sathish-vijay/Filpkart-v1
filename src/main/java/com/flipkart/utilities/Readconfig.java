package com.flipkart.utilities;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Readconfig {

	public Properties pro;

	public Readconfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileReader fis = new FileReader(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {

			System.out.println("Exception is " + e.getMessage());

		}

	}

	public String geturl() {

		String url = pro.getProperty("baseurl");

		return url;

	}

	public String chromepath() {

		String path = pro.getProperty("chromepath");

		return path;

	}

	public String mozilapath() {

		String mozilapath = pro.getProperty("mozilapath");

		return mozilapath;

	}

	public String getusername() {

		String username = pro.getProperty("username");

		return username;

	}

	public String getpassword() {

		String password = pro.getProperty("password");

		return password;

	}

	public String getbrowsertype() {

		String browser = pro.getProperty("browser");

		return browser;
	}

}
