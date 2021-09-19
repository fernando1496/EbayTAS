package UITests;

import Base.Base;
import PageObjects.HomePageObjects;
import PageObjects.ItemDetailsPageObject;
import PageObjects.NewUserLoginPageObjects;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class e2eTests extends Base {
    NewUserLoginPageObjects oNewUserLogin = null;
    HomePageObjects oHomePageObjects = null;
    ItemDetailsPageObject oItemDetailsPageObjects = null;

    AndroidDriver myDriver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        myDriver = baseCapabilities();
        oNewUserLogin = new NewUserLoginPageObjects(myDriver);
        oHomePageObjects = new HomePageObjects(myDriver);
        oItemDetailsPageObjects = new ItemDetailsPageObject(myDriver);
    }

    @Test()
    private void e2eTestOne() throws InterruptedException {
        oHomePageObjects.searchForAnItem("Samsung Galaxy s21 Refurbished"); //Unlocked Refurbished Silver G998B 256
        oItemDetailsPageObjects.verifyImages();
        oItemDetailsPageObjects.swipeImagesAndScrollDown(2);
        oItemDetailsPageObjects.clickOnBuyNow();
        //oItemDetailsPageObjects.selectProductDetails();
        oNewUserLogin.loginWithExistingUser();

    }
}
