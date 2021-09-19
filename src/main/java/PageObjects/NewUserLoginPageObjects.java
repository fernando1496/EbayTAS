package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class NewUserLoginPageObjects {

    AndroidDriver<AndroidElement> myDriver;
    public NewUserLoginPageObjects(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public void loginWithExistingUser() throws InterruptedException {
        MobileElement mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Use email or username\")");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
        mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Email or username\")");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.sendKeys("testingappium2021@gmail.com");
        mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Password\")");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.sendKeys("testing2021");
        mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Sign in\")");
        Assert.assertTrue(mobileELement.isDisplayed());
        Thread.sleep(2000);
    }
}
