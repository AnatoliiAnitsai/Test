package com.anatolii.anitsai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoSuccess {
    private WebDriver driver;

    public DemoSuccess(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"middle-col\"]/h1")
    private WebElement pageName;

    public String getPageName(){
        return pageName.getText();
    }
}
