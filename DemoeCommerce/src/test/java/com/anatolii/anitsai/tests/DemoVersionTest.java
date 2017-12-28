package com.anatolii.anitsai.tests;

import com.anatolii.anitsai.pages.CodeCard;
import com.anatolii.anitsai.pages.DemoSuccess;
import com.anatolii.anitsai.pages.EnterCard;
import com.anatolii.anitsai.pages.MainPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DemoVersionTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static EnterCard enterCard;
    private static CodeCard codeCard;
    private static DemoSuccess demoSuccess;

    private final String VALIDITY_CARD_MONTH = "12";
    private final String VALIDITY_CARD_YEAR = "2050";
    private final String EMAIL = "anatolii.anitsai@gmail.com";
    private final String SECURITY_CODE = "999";

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/anatolii/Downloads/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        enterCard = new EnterCard(driver);
        codeCard = new CodeCard(driver);
        demoSuccess = new DemoSuccess(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDemoVersion() {
        driver.get("https://ecconnect.com.ua/");
        mainPage.clickDemoButton();
        String numCardStr = mainPage.getNumFirstCard();
        mainPage.clickPayFirstSetButton();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        enterCard.selectExpCard();
        enterCard.inputCardNumber(numCardStr);
        enterCard.selectMonth(VALIDITY_CARD_MONTH);
        enterCard.selectYear(VALIDITY_CARD_YEAR);
        enterCard.inputUserEmail(EMAIL);
        enterCard.submit();
        codeCard.inputSecurityCode(SECURITY_CODE);
        codeCard.submit();
        Assert.assertEquals("Оплата товара прошла успешно", demoSuccess.getPageName());
    }

    @AfterClass
    public static void exit(){
        driver.quit();
    }
}
