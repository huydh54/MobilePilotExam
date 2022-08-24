package com.testng.asm.pages.components.menus;

import com.testng.asm.keyword.ActionKeyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseMenu {
    public WebDriver driver;
    private String mnuMenuTabsLocator;
    private final String MNU_TAB_LOCATOR_BY_NAME = "//*[text()='%s']";
    ActionKeyword actionKeyword;

    public BaseMenu(WebDriver driver, String mnuMenuTabsLocator){
        this.driver = driver;
        actionKeyword = new ActionKeyword(driver);
        this.mnuMenuTabsLocator = mnuMenuTabsLocator;
    }

    public WebElement getMenuTabByName(String tabName){
        return actionKeyword.findElementCustom(By.xpath(String.format(MNU_TAB_LOCATOR_BY_NAME, tabName)));
    }

    public List<WebElement> getMenuTabList(){
        return actionKeyword.findElementsCustom(By.cssSelector(mnuMenuTabsLocator));
    }

    public WebElement getMenuTabByIndex(int index){
        return getMenuTabList().get(index);
    }
}
