package com.qa.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;

public class Cfg {
	
	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg() {
	 Map<String, Object> prefs = new HashMap<String, Object>();
	 ChromeOptions cOptions = new ChromeOptions();
	  
	 // Settings
	 prefs.put("profile.default_content_setting_values.cookies", 2);
	 prefs.put("network.cookie.cookieBehavior", 2);
	 prefs.put("profile.block_third_party_cookies", true);

	 // Create ChromeOptions to disable Cookies pop-up
	 cOptions.setExperimentalOption("prefs", prefs);

	 return cOptions;
	 }
}