package com.cdp.pageobject;

import com.cdp.utils.Driver;
import com.cdp.utils.DriversType;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {

    protected WebDriver driver;


    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public PageObject(DriversType driversType) {
        this(Driver.getDriver(driversType));
    }
}
