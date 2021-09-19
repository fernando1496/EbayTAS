package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePageObjects {

    AndroidDriver<AndroidElement> myDriver;
    public HomePageObjects(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public void goToCart(){
        MobileElement mobileELement =  myDriver.findElementByName("Cart 1 item Tab 3 of 4");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
    }

    public void searchForAnItem(String searchValue) throws InterruptedException {
        MobileElement mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Search for anything\")");
        mobileELement.click();
        mobileELement.sendKeys(searchValue);
        myDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"When you save a search, we'll let you know when a new item is listed\")");
        mobileELement.click();
        List<AndroidElement> mobileELements = myDriver.findElementsByAndroidUIAutomator("text(\"Free shipping\")");
        mobileELements.get(0).click();

    }
}
