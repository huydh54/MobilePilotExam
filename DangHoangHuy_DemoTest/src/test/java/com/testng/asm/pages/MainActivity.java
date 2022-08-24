package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainActivity extends BaseActivity {
    public MainActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtViewNameXpath = "//*[@text='%s']";

    public WebElement getViewNameElement(String viewName){
        return actionKeyword.findElementCustom(By.xpath(String.format(txtViewNameXpath, viewName)));
    }

    public ContentActivity navigateToContentActivity(String viewName) {
        scrollToElementByVisibleText(viewName);
        actionKeyword.click(getViewNameElement(viewName));
        return new ContentActivity(this.driver);
    }

    public PreferenceActivity navigateToPreferenceActivity(String viewName) {
        scrollToElementByVisibleText(viewName);
        actionKeyword.click(getViewNameElement(viewName));
        return new PreferenceActivity(this.driver);
    }

    public TextActivity navigateToTextActivity(String viewName) {
        scrollToElementByVisibleText(viewName);
        actionKeyword.click(getViewNameElement(viewName));
        return new TextActivity(this.driver);
    }

    public ViewsActivity navigateToViewsActivity(String viewName) {
        scrollToElementByVisibleText(viewName);
        actionKeyword.click(getViewNameElement(viewName));
        return new ViewsActivity(this.driver);
    }
}