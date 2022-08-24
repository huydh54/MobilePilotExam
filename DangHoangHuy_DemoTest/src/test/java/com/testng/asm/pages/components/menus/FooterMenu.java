package com.testng.asm.pages.components.menus;

import org.openqa.selenium.WebDriver;

public class FooterMenu extends BaseMenu{
    public FooterMenu(WebDriver driver) {
        super(driver, "div#site_tools a");
    }
}
