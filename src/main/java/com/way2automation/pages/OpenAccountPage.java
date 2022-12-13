package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

   /* @CacheLookup
    @FindBy()
    WebElement*/
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccount;

    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement customerNameDropdown;


    @CacheLookup
    @FindBy(id = "currency")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement process;

    public void clickOnOpenAccount(){
        Reporter.log("Click on open account "+openAccount.toString());
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS,"clickOnOpenAccoun");
    }

    public void clickCustomerFromDropDown() {

        //selectOptionByIndex(customerNameDropdown,6);
        //selectOptionsByContainText(customerNameDropdown,"Krish Patel");
        Reporter.log("Select customer name from dropdown "+customerNameDropdown.toString());
        selectByVisibleTextFromDropDown(customerNameDropdown,"Krish Patel");
    }
    public void selectCurrencyPoundFromDropDown(){
        Reporter.log("Select currency from dropdown "+currency.toString());
        selectByVisibleTextFromDropDown(currency,"Pound");
    }

    public void clickOnProcessButton(){
        Reporter.log("Click on process button "+process.toString());
        clickOnElement(process);
    }
    public String getSuccessfulTextFromPopup(){
        //String[] arr = new String[2];
Reporter.log("Get text from alert");
        return getTextFromAlert();
    }

    public void clickOkOnPopup(){
        Reporter.log("Click ok fro alert");
        acceptAlert();
    }
}
