package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdvancedPreferenceActivity extends BaseActivity {
    public AdvancedPreferenceActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtViewNameXpath = "//*[@text='%s']";
    private String txtCountId = "io.appium.android.apis:id/mypreference_widget";

    public WebElement getViewNameElement(String viewName){
        return actionKeyword.findElementCustom(By.xpath(String.format(txtViewNameXpath, viewName)));
    }

    public void multipleClickOnView(String count, String viewName){
        int countInt = Integer.parseInt(count);
        for (int i = 0; i < countInt; i++) {
            actionKeyword.click(getViewNameElement(viewName));
        }
    }

    public String getCount(){
        return actionKeyword.findElementCustom(By.id(txtCountId)).getText();
    }

    public boolean isEqual(String textA, String textB){
        boolean isEqual = textA.equals(textB);
        return isEqual;
    }

    public LaunchingPreferenceActivity goBackLaunchingPreferenceActivity() {
        driver.navigate().back();
        return new LaunchingPreferenceActivity(this.driver);
    }
}