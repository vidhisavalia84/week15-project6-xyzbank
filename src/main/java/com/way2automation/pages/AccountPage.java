package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement deposit;
   // By deposit = By.xpath("//button[@ng-click='deposit()']");

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;
   // By depositAmount = By.xpath("//input[@placeholder='amount']");

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement finalDeposit;
   // By finalDeposit = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]");


    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfulMessage;
   // By depositSuccessfulMessage=By.xpath("//span[contains(text(),'Deposit Successful')]");

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawlButton ;
   // By withdrawlButton=By.xpath("//button[@ng-click='withdrawl()']");

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountWithdrawlField;
   // By amountWithdrawlField=By.xpath("//input[@placeholder='amount']");

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Withdraw')and@type='submit']")
    WebElement withdrawButton1;
   // By withdrawButton1=By.xpath("//button[contains(text(),'Withdraw')and@type='submit']");

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionMessage;
    //By transactionMessage=By.xpath("//span[contains(text(),'Transaction successful')]");

    public void clickOnDepositButton() {
        Reporter.log("click on deposit button "+deposit.toString());
        clickOnElement(deposit);
    }
    public void enterAmountIntoDepositFeild(String num) {
        Reporter.log("Enter amount : "+depositAmount.toString());
        sendTextToElement(depositAmount, num);
    }
    public void clickOnDepositButtonAfterEnterAmount() {
        Reporter.log("Click on deposit button "+finalDeposit.toString());
        clickOnElement(finalDeposit);
    }
    public String verifyDepositSuccessfulMessage(){
        Reporter.log("Verify message : "+depositSuccessfulMessage.toString());
        return getTextFromElement(depositSuccessfulMessage);
    }

    public void clickOnWithdrawlButton(){
        Reporter.log("Click on withdrawl button "+withdrawlButton.toString());
        clickOnElement(withdrawlButton);
    }
    public void enterAmountYouWishToWithdrawl(String amount){
        Reporter.log("Enter amount "+amountWithdrawlField.toString());
        sendTextToElement(amountWithdrawlField,amount);
    }

    public void clickOnWithdrawlButtonAfterEnterAmount(){
        Reporter.log("click on withdrawl Button "+withdrawButton1.toString());
        clickOnElement(withdrawButton1);
    }

    public String verifyTransactionSuccessfulMessage(){
        Reporter.log("Transaction message "+transactionMessage.toString());
        return getTextFromElement(transactionMessage);
    }


}
