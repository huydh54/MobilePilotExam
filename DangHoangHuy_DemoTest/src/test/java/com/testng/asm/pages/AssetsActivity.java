package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AssetsActivity extends BaseActivity {
    public AssetsActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtViewNameXpath = "//*[@text='%s']";

    public WebElement getViewNameElement(String viewName){
        return actionKeyword.findElementCustom(By.xpath(String.format(txtViewNameXpath, viewName)));
    }

    public ReadAssetsActivity navigateToReadAssetsActivity(String viewName) {
        scrollToElementByVisibleText(viewName);
        actionKeyword.click(getViewNameElement(viewName));
        return new ReadAssetsActivity(this.driver);
    }
}