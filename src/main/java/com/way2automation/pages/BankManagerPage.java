package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccount;
    public void clickOnAddCustomerButton () {
        Reporter.log("Click on add customer "+addCustomer.toString());

        clickOnElement(addCustomer);
    }
    public void clickOnOpenAccount() {
        Reporter.log("Click on open Account"+openAccount.toString());
        clickOnElement(openAccount);
    }
}
