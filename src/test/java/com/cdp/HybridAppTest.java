package com.cdp;

import com.cdp.pageobject.hybrid.HybridGmailLoginPage;
import com.cdp.utils.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HybridAppTest {

    @Test
    public void hybridTest() {
        HybridGmailLoginPage hybridGmailLoginPage = new HybridGmailLoginPage();
        hybridGmailLoginPage.enterLoginAndSubmit("****");
        hybridGmailLoginPage.enterPasswordAndSubmit("****");
        hybridGmailLoginPage.removeDisclaimer();
        Assert.assertTrue(hybridGmailLoginPage.isLoggined("****@gmail.com"));
    }

    @AfterTest
    public void close(){
        Driver.close();
    }
}
