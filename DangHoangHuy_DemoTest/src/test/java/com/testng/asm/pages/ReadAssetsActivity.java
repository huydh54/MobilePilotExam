package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ReadAssetsActivity extends BaseActivity {
    public ReadAssetsActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtContentXpath = "//*[@text='%s']";

    public WebElement getContent(){
        return actionKeyword.findElementCustom(By.id("io.appium.android.apis:id/text"));
    }

    public boolean isDisplayContentText(String content) {
        return getContent().getText().replace("\n", "").replace(" ", "")
                .equals(content.replace("\n", "").replace(" ", ""));
    }
}