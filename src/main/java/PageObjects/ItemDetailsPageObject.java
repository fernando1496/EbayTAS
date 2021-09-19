package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ItemDetailsPageObject {

    AndroidDriver<AndroidElement> myDriver;
    public ItemDetailsPageObject(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public void verifyImages() throws InterruptedException {
        TouchAction touchAction = new TouchAction(myDriver);
        Thread.sleep(4000);
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1271,757))).perform();
        myDriver.navigate().back();
    }

    public void swipeImagesAndScrollDown(int swipeTimes) throws InterruptedException {
        TouchAction touchAction = new TouchAction(myDriver);
        for (int i = 0; i <= swipeTimes; i++){
            touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(1023,1312)) .withDuration(Duration.ofSeconds(2))).moveTo(PointOption.point(26,1312)).release().perform();
            Thread.sleep(1000);
        }
        for (int i = 0; i <= 1; i++){
            touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(488,1320)) .withDuration(Duration.ofSeconds(2))).moveTo(PointOption.point(501,501)).release().perform();
            Thread.sleep(1000);
        }
    }

    public void clickOnBuyNow(){
        MobileElement mobileELement =  myDriver.findElementByXPath("//android.widget.Button[@text='Buy It Now']");
        Assert.assertTrue(mobileELement.isDisplayed() && mobileELement.isEnabled());
        mobileELement.click();
    }

    public void selectProductDetails(){
        MobileElement mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Select\")");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
            mobileELement =  myDriver.findElementByXPath("//android.widget.TextView[@text='Gray']");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
        mobileELement =  myDriver.findElementByClassName("android.widget.CheckBox");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
        mobileELement =  myDriver.findElementByXPath("//android.widget.Button[@text='Buy It Now']");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
        mobileELement =  myDriver.findElementByAndroidUIAutomator("text(\"Use email or username\")");
        Assert.assertTrue(mobileELement.isDisplayed());
        mobileELement.click();
    }

}
