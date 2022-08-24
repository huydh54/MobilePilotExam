package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewsActivity extends BaseActivity {
    public ViewsActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtViewNameXpath = "//*[@text='%s']";

    public WebElement getViewNameElement(String viewName){
        return actionKeyword.findElementCustom(By.xpath(String.format(txtViewNameXpath, viewName)));
    }

    public SearchViewsActivity navigateToSearchViewActivity(String viewName) {
        scrollToElementByVisibleText(viewName);
        actionKeyword.click(getViewNameElement(viewName));
        return new SearchViewsActivity(this.driver);
    }
}