package Practise.MobileProjectSubmission;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScenarioExecution extends Capability{
	public static AndroidDriver<AndroidElement> driver= null;
	SignInApp signIn;
	SelectCourse courseSelect;
	LaunchCourse courseLaunch;
	SignOut logOut;
	@Test(priority=1)
	public void openApp() throws IOException, InterruptedException{
		
		driver = DesiredCapability();
		signIn = new SignInApp(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		signIn.clickDismiss();
	}
	@Test(dependsOnMethods="openApp",priority=2)
	public void Signin() throws IOException, InterruptedException{
//		Scenario 1
		signIn.signIn();			
	}
	
	@Test(dependsOnMethods="Signin",priority=3)
	public void selectCourse() throws InterruptedException{
		courseSelect = new SelectCourse(driver);
		courseSelect.selectCourse();
	}
	
	//LaunchCourse
	@Test(dependsOnMethods="selectCourse",priority=4)
	public void selectLanguage() throws InterruptedException{
		courseLaunch = new LaunchCourse(driver);
		courseLaunch.launchCourse();
	}
	
	@Test(dependsOnMethods="selectLanguage",priority=5)
	public void logout() throws InterruptedException{
		logOut = new SignOut(driver);
		logOut.signOut();
	}
}
