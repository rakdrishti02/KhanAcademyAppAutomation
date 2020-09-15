package Practise.MobileProjectSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignOut {
	AndroidDriver<AndroidElement> driver;
	WebElement selectProg,course1,course2;
	public SignOut(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	public void signOut() throws InterruptedException{
		driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Sign out']")).click();
		Thread.sleep(2000);
	}
}
