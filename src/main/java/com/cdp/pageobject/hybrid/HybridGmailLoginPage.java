package com.cdp.pageobject.hybrid;

import com.cdp.pageobject.PageObject;
import com.cdp.utils.DriversType;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HybridGmailLoginPage extends PageObject {

    private static final String LOGIN_INPUT_ID = "identifierId";
    private static final String BUTTON_NEXT_ID = "identifierNext";
    private static final String PASSWORD_INPUT_ID = "password";
    private static final String PASSWORD_BUTTON_ID = "passwordNext";
    private static final String DISCLAIMER_LINK_XPATH = "//android.view.View[@text='I am not interested']";
    private static final String MORE_BUTTON_XPATH = "//android.view.View[@text='more']";
    private static final String USER_INFO_ID = "og_t";
    private TouchAction action;

    @FindBy(id = LOGIN_INPUT_ID)
    private WebElement inputLogin;

    @FindBy(id = BUTTON_NEXT_ID)
    private WebElement loginNext;

    @FindBy(id = PASSWORD_INPUT_ID)
    private WebElement inputPassword;

    @FindBy(id = PASSWORD_BUTTON_ID)
    private WebElement passwordButton;

    @FindBy(xpath = DISCLAIMER_LINK_XPATH)
    private WebElement disclaimerButton;

    @FindBy(xpath = MORE_BUTTON_XPATH)
    private WebElement moreButton;

    @FindBy(id = USER_INFO_ID)
    private WebElement userInfo;

    public HybridGmailLoginPage() {
        super(DriversType.HYBRID);
        action = new TouchAction((MobileDriver) driver);
        // driver.get("http://mail.google.com/mail/");
    }

    public void enterLoginAndSubmit(String login) {
        inputLogin.sendKeys(login);
        loginNext.click();
        loginNext.click();
    }

    public void enterPasswordAndSubmit(String password) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id
                (PASSWORD_INPUT_ID)));
        inputPassword.sendKeys(password);
        passwordButton.click();
        passwordButton.click();
    }

    public void removeDisclaimer() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                (DISCLAIMER_LINK_XPATH)));
        disclaimerButton.click();

    }

    public boolean isLoggined(String login) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                (MORE_BUTTON_XPATH)));
        moreButton.click();
        return userInfo.getText().equalsIgnoreCase(login);
    }

}
