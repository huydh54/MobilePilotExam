package com.testng.asm.test;

import com.testng.asm.configuration.Configuration;
import com.testng.asm.keyword.ActionKeyword;
import com.testng.asm.pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EndToEndTest extends BaseTest{
    public ActionKeyword actionKeyword;

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest ran successfully!");
    }

    @BeforeMethod
    public void before() throws MalformedURLException {
        Configuration config = new Configuration("src/test/resources/config.properties");

        String filePath = config.getProperty("app");
        File file = new File(filePath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("device_name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("platform_name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getProperty("platform_version"));
        capabilities.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver<>(new URL(config.getProperty("url")), capabilities);
    }

    @Test
    public void testCase1() {
        MainActivity mainActivity = new MainActivity(driver);
        boolean isDisplayContent = mainActivity
                .navigateToContentActivity("Content")
                .navigateToAssetsActivity("Assets")
                .navigateToReadAssetsActivity("Read Asset")
                .isDisplayContentText("This text is stored in a raw Asset. It was read and placed into the TextView here.");
        Assert.assertTrue(isDisplayContent);
    }

    @Test
    public void testCase2() {
        MainActivity mainActivity = new MainActivity(driver);
        boolean isDisplayContent = mainActivity
                .navigateToTextActivity("Text")
                .navigateToLogTextBoxActivity("LogTextBox")
                .clickAddButton()
                .isDisplayNewText("This is a test");
        Assert.assertTrue(isDisplayContent);
    }

    @Test
    public void testCase3() {
        MainActivity mainActivity = new MainActivity(driver);
        boolean checkboxIsChecked = mainActivity
                .navigateToPreferenceActivity("Preference")
                .navigateToPreferenceXMLActivity("1. Preferences from XML")
                .clickCheckboxElement()
                .isCheckedCheckboxPreferences();
        Assert.assertTrue(checkboxIsChecked);
    }

    @Test
    public void testCase4() {
        MainActivity mainActivity = new MainActivity(driver);

        LaunchingPreferenceActivity launchingPreferenceActivity = mainActivity
                .navigateToPreferenceActivity("Preference")
                .navigateToLaunchingPreferenceActivity("2. Launching preferences");
        String count = launchingPreferenceActivity.getCount();

        AdvancedPreferenceActivity advancedPreferenceActivity = launchingPreferenceActivity
                .navigateToAdvancedPreferenceActivity("LAUNCH PREFERENCEACTIVITY");
        String count2 = advancedPreferenceActivity.getCount();

        Assert.assertTrue(advancedPreferenceActivity.isEqual(count, count2));

        advancedPreferenceActivity.multipleClickOnView("21", "My preference");
        String count3 = advancedPreferenceActivity.getCount();

        LaunchingPreferenceActivity launchingPreferenceActivity1 = advancedPreferenceActivity
                .goBackLaunchingPreferenceActivity();
        String count4 = launchingPreferenceActivity1.getCount();
        System.out.println(count3 + " " + count4);
        Assert.assertTrue(launchingPreferenceActivity1.isEqual(count3, count4));
    }

    @Test
    public void testCase5() {
        MainActivity mainActivity = new MainActivity(driver);
        FilterActivity filterActivity = mainActivity
                .navigateToViewsActivity("Views")
                .navigateToSearchViewActivity("Search View")
                .navigateToFilterActivity("Filter");

        int count = filterActivity
                .enterKeywordInSearchView("Ab")
                .countTheNumberOfResults();
        Assert.assertTrue(count == 4);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        driver.quit();
        System.out.println("AfterMethod ran successfully!");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test completed!");
    }
}
