package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LaunchingPreferenceActivity extends BaseActivity {
    public LaunchingPreferenceActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtContentXpath = "//*[@class='android.widget.TextView']";
    private String btnLaunchXpath = "//*[@text='%s']";

    public WebElement getContentElement(){
        return actionKeyword.findElementsCustom(By.xpath(txtContentXpath)).get(1);
    }

    public WebElement getLaunchButtonElement(String text){
        return actionKeyword.findElementCustom(By.xpath(String.format(btnLaunchXpath, text)));
    }

    public String getCount(){
        String elementText = getContentElement().getText();
        return elementText.substring(21);
    }

    public boolean isEqual(String textA, String textB){
        boolean isEqual = textA.equals(textB);
        return isEqual;
    }

    public AdvancedPreferenceActivity navigateToAdvancedPreferenceActivity(String text) {
        scrollToElementByVisibleText(text);
        actionKeyword.click(getLaunchButtonElement(text));
        return new AdvancedPreferenceActivity(this.driver);
    }
}