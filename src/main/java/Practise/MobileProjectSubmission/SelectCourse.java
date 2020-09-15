package Practise.MobileProjectSubmission;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SelectCourse {
	AndroidDriver<AndroidElement> driver;
	WebElement Edit;
	public SelectCourse(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	
	public void selectCourse() throws InterruptedException{
		Set<String> contextNames = driver.getContextHandles();
		 for (String contextName : contextNames) {
		     System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		 }
		System.out.println("In Method selectCourse");
		driver.context("NATIVE_APP");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='My courses']")).click();
		Thread.sleep(2000);
		
		if(driver.findElements(By.xpath("//*[@text='Get started']")).size()!=0){
		System.out.println("Get Started is visible");
		driver.findElement(By.xpath("//*[@text='Get started']")).click();
		//scroll down to course Graduate studies
		driver.findElement(By.xpath("//*[@text='Classes']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Graduate studies\"));");
		//clicked on Graduate studies
		driver.findElement(By.xpath("//*[@text='Graduate studies']")).click();
		//Scroll down to the course Computer programming
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computing\"));");
		//select the course Computer programming
		driver.findElement(By.xpath("//*[@text='Computer programming']")).click();
		}
		else{
			System.out.println("Edit is visible");
			Edit = driver.findElement(By.xpath("//*[@text='Edit']"));
			Edit.click();
			Thread.sleep(2000);
		}
		
		Thread.sleep(2000);
		//Click on Done
		driver.findElement(By.xpath("//*[@text='Done']")).click();
		String actualCourse = driver.findElement(By.xpath("//*[@text='Computer programming']")).getText();
		String expectedCourse = "Computer programming";
		Assert.assertEquals(actualCourse, expectedCourse);
	}

}
