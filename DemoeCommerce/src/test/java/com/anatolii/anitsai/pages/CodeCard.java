package com.anatolii.anitsai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CodeCard {
    private WebDriver driver;

    public CodeCard(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"Cvc\"]")
    private WebElement securityCodeField;

    @FindBy(id = "CVCSubmit")
    private WebElement submitBtn;

    public void inputSecurityCode(String code){
        securityCodeField.sendKeys(code);
    }

    public void submit(){
        submitBtn.click();
    }
}
