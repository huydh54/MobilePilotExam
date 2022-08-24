package com.testng.asm.pages.components.menus;

import org.openqa.selenium.WebDriver;

public class HeaderMenu extends BaseMenu{
    public HeaderMenu(WebDriver driver) {
        super(driver, "div#top_nav a");
    }
}
