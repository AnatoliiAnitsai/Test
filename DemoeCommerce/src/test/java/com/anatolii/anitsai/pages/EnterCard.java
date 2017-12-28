package com.anatolii.anitsai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EnterCard {
    private WebDriver driver;

    public EnterCard(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"cardForm\"]/table/tbody/tr[8]/td/table/tbody/tr[2]/td[1]")
    private WebElement paymentTypeCardRadio;

    @FindBy(id = "CardNumber")
    private WebElement cardNumberField;

    @FindBy(id = "ExpMonth")
    private WebElement cardValidityMonSelect;

    @FindBy(id = "ExpYear")
    private  WebElement cardValidityYearSelect;

    @FindBy(id = "Email")
    private WebElement userEmailField;

    @FindBy(id = "cardDataSubmit")
    private WebElement cardDataSubmit;

    public void selectExpCard(){
        paymentTypeCardRadio.click();
    }

    public void inputCardNumber(String numberStr){
        cardNumberField.sendKeys(numberStr);
    }

    public void selectMonth(String month){
        Select select = new Select(cardValidityMonSelect);
        select.selectByVisibleText(month);
    }

    public void selectYear(String year){
        Select select = new Select(cardValidityYearSelect);
        select.selectByVisibleText(year);
    }

    public void inputUserEmail(String email){
        userEmailField.sendKeys(email);
    }

    public void submit(){
        cardDataSubmit.click();
    }

}
