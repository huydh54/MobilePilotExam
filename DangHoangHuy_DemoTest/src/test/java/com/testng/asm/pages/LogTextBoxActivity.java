package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LogTextBoxActivity extends BaseActivity {
    public LogTextBoxActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String btnAddId = "io.appium.android.apis:id/add";
    private String txtNewTextId = "io.appium.android.apis:id/text";

    public WebElement getNewTextElement(){
        return actionKeyword.findElementCustom(By.id(txtNewTextId));
    }

    public WebElement getAddButtonElement(){
        return actionKeyword.findElementCustom(By.id(btnAddId));
    }

    public LogTextBoxActivity clickAddButton(){
        actionKeyword.click(getAddButtonElement());
        return new LogTextBoxActivity(this.driver);
    }

    public boolean isDisplayNewText(String content) {
        return getNewTextElement().getText().replace("\n", "").replace(" ", "")
                .equals(content.replace("\n", "").replace(" ", ""));
    }
}