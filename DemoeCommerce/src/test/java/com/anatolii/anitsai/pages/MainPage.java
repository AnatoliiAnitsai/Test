package com.anatolii.anitsai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "demo-btn")
    private WebElement demoButton;

    @FindBy(xpath = "//*[@id=\"popup-container\"]/table/tbody/tr[2]/td/table/tbody/tr/td/div[1]/ul/li[1]/span")
    private WebElement firstCardSpan;

    @FindBy(xpath = "//*[@id=\"buy\"]/table/tbody/tr/td[1]/form/input[12]")
    private WebElement payFirstSetButton;

    public void clickDemoButton(){
        demoButton.click();
    }

    public String getNumFirstCard(){
        String cardSpanText = firstCardSpan.getText();
        cardSpanText.trim();
        String[] arrayStr = cardSpanText.split(" ");
        return arrayStr[0];
    }

    public void clickPayFirstSetButton(){
        payFirstSetButton.click();
    }

}
