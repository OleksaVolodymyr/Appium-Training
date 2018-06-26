package com.cdp.pageobject.web;

import com.cdp.pageobject.PageObject;
import com.cdp.utils.DriversType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends PageObject {
    private static final String LOGIN_INPUT_ID = "identifierId";
    private static final String BUTTON_NEXT_ID = "identifierNext";
    private static final String PASSWORD_INPUT_ID = "password";
    private static final String DISCLAIMER_LINK_XPATH = "//div[@class = 'Yq']";
    private static final String MENU_BUTTON_CSS = "div[aria-label = 'Menu']";
    private static final String LOGIN_INFO_XPATH = "//div[@class = 'V Y UA Yg']";
    private static final String MORE_BUTTON_XPATH = "//div[@class = 'og_t']";
    private static final String USER_INFO_CSS = "#og_t";

    @FindBy(id = LOGIN_INPUT_ID)
    private WebElement inputLogin;

    @FindBy(id = BUTTON_NEXT_ID)
    private WebElement loginNext;

    @FindBy(name = PASSWORD_INPUT_ID)
    private WebElement inputPassword;

    @FindBy(css = MENU_BUTTON_CSS)
    private WebElement menuButton;

    @FindBy(xpath = DISCLAIMER_LINK_XPATH)
    private WebElement disclaimerButton;

    @FindBy(xpath = LOGIN_INFO_XPATH)
    private WebElement loginInfo;

    @FindBy(xpath = MORE_BUTTON_XPATH)
    private WebElement moreButton;

    @FindBy(css = USER_INFO_CSS)
    private WebElement userInfo;

    public GmailLoginPage() {
        super(DriversType.BROWSER);
        driver.get("http://mail.google.com/mail/");
    }

    public void enterLoginAndSubmit(String login) {
        inputLogin.sendKeys(login);
        loginNext.click();
    }

    public void enterPasswordAndSubmit(String password) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name
                (PASSWORD_INPUT_ID)));
        inputPassword.sendKeys(password + Keys.RETURN);
    }

    public void removeDisclaimer() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                (DISCLAIMER_LINK_XPATH)));
        disclaimerButton.click();
    }

    public boolean isLoggined(String login) {
//        JavascriptExecutor scroll = (JavascriptExecutor) driver;
//        scroll.executeScript("window.scrollBy(0,250)", "");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
//                (MENU_BUTTON_CSS)));
//        menuButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath
               (MORE_BUTTON_XPATH)));
        moreButton.click();
        return userInfo.getText().equals(login);
    }

}
