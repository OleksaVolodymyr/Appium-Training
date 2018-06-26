package com.cdp;

import com.cdp.pageobject.web.GmailLoginPage;
import com.cdp.utils.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WebAppTest {

    @Test
    public void webAppTest() {
        GmailLoginPage gmailLoginPage = new GmailLoginPage();
        gmailLoginPage.enterLoginAndSubmit("****");
        gmailLoginPage.enterPasswordAndSubmit("****");
        gmailLoginPage.removeDisclaimer();
        Assert.assertTrue(gmailLoginPage.isLoggined("*******@gmail.com"));
    }

    @AfterTest
    public void close() {
        Driver.close();
    }
}
