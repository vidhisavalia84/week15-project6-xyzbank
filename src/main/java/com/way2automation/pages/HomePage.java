package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePage extends Utility {
   @CacheLookup
   @FindBy(xpath = "//button[text()='Bank Manager Login']")
    WebElement bankManagerLogin;

   @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;

   @CacheLookup
    @FindBy(xpath = "//label[text()='Your Name :']")
    WebElement yourNameText;

   @CacheLookup
   @FindBy(xpath = "//button[contains(text(),'Home')]")
   WebElement homeButton;

    public void clickOnCustomerLoginButton() {
        Reporter.log("Click on customer login button "+customerLogin.toString());
        clickOnElement(customerLogin);
    }
    public String verifyYourNameText() {
        Reporter.log("Verify text "+yourNameText.toString());
        return getTextFromElement(yourNameText);
    }
    public void clickOnBankManagerLoginButton(){
        Reporter.log("Click on bank manager login button "+bankManagerLogin.toString());
        clickOnElement(bankManagerLogin);
    }
    public void clickOnHomeButton(){
        Reporter.log("Click on home button "+homeButton.toString());
        clickOnElement(homeButton);
    }

}
