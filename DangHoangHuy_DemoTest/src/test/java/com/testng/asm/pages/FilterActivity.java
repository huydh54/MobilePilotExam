package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterActivity extends BaseActivity {
    public FilterActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String txtSearchViewId = "android:id/search_src_text";
    private String txtResultsClass = "android.widget.TextView";

    public WebElement getSearchViewElement(){
        return actionKeyword.findElementCustom(By.id(txtSearchViewId));
    }

    public FilterActivity enterKeywordInSearchView(String keyword){
        actionKeyword.setText(getSearchViewElement(), keyword);
        return new FilterActivity(this.driver);
    }

    public int countTheNumberOfResults(){
        return actionKeyword.findElementsCustom(By.className(txtResultsClass)).size() - 1;
    }

    public boolean isEqual(String number){
        return countTheNumberOfResults() == Integer.parseInt(number);
    }
}