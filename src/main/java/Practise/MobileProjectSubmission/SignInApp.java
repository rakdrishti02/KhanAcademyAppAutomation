package Practise.MobileProjectSubmission;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInApp{
	AndroidDriver<AndroidElement> driver;
	WebElement Dismiss,Dismiss2,SignIn,ContinueWith;
	public SignInApp(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	
	public void clickDismiss() throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Click on Dismiss
		Dismiss = driver.findElement(By.xpath("//*[@text='Dismiss']"));
		Dismiss.click();
		Thread.sleep(2000);
		// Click on Dismiss again
		Dismiss2= driver.findElement(By.xpath("//*[@text='Dismiss']"));
		Dismiss2.click();
	}
	
	public void signIn(){
		SignIn = driver.findElement(By.xpath("//*[@text='Sign in']"));
		SignIn.click();
		
		//Click on Continue with Google
		ContinueWith =  driver.findElement(By.xpath("//*[@text='Sign in']"));
		ContinueWith.click();
		
		//mailid and password
		driver.findElement(MobileBy.AccessibilityId("Enter an e-mail address or username")).sendKeys("raunak.tiwari@gmail.com");
		driver.findElement(MobileBy.AccessibilityId("Password")).sendKeys("Abcd@1234");
		driver.findElement(MobileBy.AccessibilityId("Sign in")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//click on setting
		driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
		//extract text of login name
		String actualName = driver.findElement(By.xpath("//*[@text='Raunak Tiwari']")).getText();
		String expectedName = "Raunak Tiwari";
		Assert.assertEquals(actualName, expectedName);
		//If the login name match than click on back, else click on sign out
		if(actualName.contentEquals(expectedName)){
			driver.findElement(By.className("android.widget.ImageView")).click();
		}
		else{
			driver.findElement(By.xpath("//*[@text='Sign out']")).click();
		}
		driver.findElement(By.xpath("//*[@text='My courses']")).click();
	}

}
