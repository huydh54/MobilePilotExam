package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PreferenceXMLActivity extends BaseActivity {
    public PreferenceXMLActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtCheckboxsXpath = "//*[@class='android.widget.CheckBox']";

    public WebElement getCheckboxElement(){
        return actionKeyword.findElementsCustom(By.xpath(txtCheckboxsXpath)).get(0);
    }

    public PreferenceXMLActivity clickCheckboxElement(){
        actionKeyword.click(getCheckboxElement());
        return new PreferenceXMLActivity(this.driver);
    }

    public boolean isCheckedCheckboxPreferences() {
        boolean isChecked = getCheckboxElement().getAttribute("checked").equals("true");
        return isChecked;
    }
}