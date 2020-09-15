package Practise.MobileProjectSubmission;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LaunchCourse {
	AndroidDriver<AndroidElement> driver;
	WebElement selectProg,course1,course2;
	public LaunchCourse(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	
	public void launchCourse() throws InterruptedException{
		//Scrolling to the selected course and clicking on it
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computer programming\"));");
				selectProg = driver.findElement(By.xpath("//*[@text='Computer programming']"));
				selectProg.click();
				Thread.sleep(20000);
				
				//Switching to web view
				Set<String> contextNames = driver.getContextHandles();
				 for (String contextName : contextNames) {
				     System.out.println(contextName);
				 }
				
				driver.context("WEBVIEW_chrome");
				
				//Selecting the course in web view
				course1 = driver.findElement(By.xpath("//h3[text()='Intro to JS: Drawing & Animation']"));
				course1.click();
				Thread.sleep(15000);
				//Clicking on video
				course2 = driver.findElement(By.xpath("//span[text()='What is Programming?']"));
				course2.click();
				Thread.sleep(40000);
				//Coming back to native app
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				Thread.sleep(5000);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				Thread.sleep(5000);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				Thread.sleep(5000);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				Thread.sleep(5000);
				
				driver.context("NATIVE_APP");

				
	}
}
