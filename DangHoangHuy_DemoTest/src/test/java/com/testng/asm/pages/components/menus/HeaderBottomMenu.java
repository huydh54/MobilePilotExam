package com.testng.asm.pages.components.menus;

import org.openqa.selenium.WebDriver;

public class HeaderBottomMenu extends BaseMenu{
    public HeaderBottomMenu(WebDriver driver){
        super(driver, "div#site_tools a");
    }
}