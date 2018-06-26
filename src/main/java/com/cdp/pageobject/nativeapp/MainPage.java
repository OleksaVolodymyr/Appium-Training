package com.cdp.pageobject.nativeapp;

import com.cdp.pageobject.PageObject;
import com.cdp.utils.DriversType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageObject {

    @FindBy(xpath = "//android.widget.Button[contains(@resource-id,'permission_allow_button')]")
    private WebElement premisionButton;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'toolbar')]/android.widget.TextView")
    private WebElement toolbar;

    @FindBy(xpath = "//android.widget.ListView[contains(@resource-id,'list')]")
    private List<WebElement> internalSDCard;

    public MainPage() {
        super(DriversType.ANDROID);
    }

    public void allowPermission() {
        premisionButton.click();
    }

    public String getToolbarText() {
        return toolbar.getText();
    }

    public  void goToInternalCard(){
        internalSDCard.stream().forEach(s->System.out.println(s.getText()));
    }
}
