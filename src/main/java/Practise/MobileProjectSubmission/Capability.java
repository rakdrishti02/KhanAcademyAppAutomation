package Practise.MobileProjectSubmission;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability {
	protected static String appPackage;
	protected static String appActivity;
	protected static String chromeDriverExecutable;
	protected static String deviceName;
	
	public static AndroidDriver<AndroidElement> DesiredCapability() throws IOException {
		// I am trying to get the path of APK which reside in src path
//		File f = new File("src");
//		File fs = new File("src/ApiDemos-debug.apk");
		FileReader fr = new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
		Properties prop= new Properties();
		prop.load(fr);
		DesiredCapabilities cap = new DesiredCapabilities();
		appPackage = prop.getProperty("AppPackage");
		appActivity= prop.getProperty("AppActivity");
		chromeDriverExecutable=prop.getProperty("ChromeDriverExecutable");
		deviceName=prop.getProperty("DeviceName");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriverExecutable);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		return driver;
		
	}

}
