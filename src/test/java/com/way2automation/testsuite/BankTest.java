package com.way2automation.testsuite;

import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.pages.*;
import com.way2automation.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerPage bankManagerPage;
    CustomerLoginPage customerLoginPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerPage = new BankManagerPage();
        customerLoginPage = new CustomerLoginPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }

     @Test(groups = {"sanity","regression"})
     public void bankManagerShouldAddCustomerSuccessfully(){
         homePage.clickOnBankManagerLoginButton();
         addCustomerPage.clickOnAddCustomerButton();
         addCustomerPage.enterFirstName("Krish");
         addCustomerPage.enterLastName("Patel");
         addCustomerPage.enterPostCode("Ha3 8LU");
         addCustomerPage.clickOnAddCustomerButtonAfterEnterInformation();

         Assert.assertEquals(addCustomerPage.verifyReceivedTextFromPopup(),"Customer added successfully with customer id :6");
         addCustomerPage.clickOkOnPopup();
     }
@Test(groups = {"smoke","regression"})
public void bankManagerShouldOpenAccountSuccessfully()throws InterruptedException{
    homePage.clickOnBankManagerLoginButton();
    bankManagerPage.clickOnAddCustomerButton();

    addCustomerPage.enterFirstName("Krish");
    addCustomerPage.enterLastName("Patel");
    addCustomerPage.enterPostCode("Ha3 8LU");
    addCustomerPage.clickOnAddCustomerButtonAfterEnterInformation();
    addCustomerPage.clickOkOnPopup();

    homePage.clickOnHomeButton();
    Thread.sleep(1000);

    homePage.clickOnBankManagerLoginButton();
    openAccountPage.clickOnOpenAccount();
    openAccountPage.clickCustomerFromDropDown();
    openAccountPage.selectCurrencyPoundFromDropDown();
    openAccountPage.clickOnProcessButton();
    Assert.assertEquals(openAccountPage.getSuccessfulTextFromPopup(), "Account created successfully with account Number :1016");
    openAccountPage.clickOkOnPopup();

}
    @Test(groups = {"regression"})
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManagerPage.clickOnAddCustomerButton();
        Thread.sleep(2000);
        addCustomerPage.enterFirstName("Krish");
        addCustomerPage.enterLastName("Patel");
        addCustomerPage.enterPostCode("Ha3 8LU");
        addCustomerPage.clickOnAddCustomerButtonAfterEnterInformation();
        addCustomerPage.clickOkOnPopup();

        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourNameFromDropDown();
        customerLoginPage.clickOnLoginButton();
        Assert.assertEquals(customerLoginPage.verifyLogOutText(), "Logout");
        customerLoginPage.cliclOnLogoutButton();
        Assert.assertEquals(customerLoginPage.verifyYourNameText(), "Your Name :");
}
    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManagerPage.clickOnAddCustomerButton();
        Thread.sleep(2000);
        addCustomerPage.enterFirstName("Krish");
        addCustomerPage.enterLastName("Patel");
        addCustomerPage.enterPostCode("Ha3 8LU");
        addCustomerPage.clickOnAddCustomerButtonAfterEnterInformation();
        addCustomerPage.clickOkOnPopup();
        homePage.clickOnHomeButton();
        /**************************************************/
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectHarryPotterFromDropDown();
        //customerPage.selectYourNameFromDropDown();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountIntoDepositFeild("100");
        accountPage.clickOnDepositButtonAfterEnterAmount();
        Assert.assertEquals(accountPage.verifyDepositSuccessfulMessage(), "Deposit Successful");
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() {


        homePage.clickOnCustomerLoginButton();
        // customerPage.selectYourNameFromDropDown();
        customerLoginPage.selectHarryPotterFromDropDown();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountIntoDepositFeild("100");
        accountPage.clickOnDepositButtonAfterEnterAmount();
        homePage.clickOnHomeButton();

        /*****************************************************/
        homePage.clickOnCustomerLoginButton();
        //customerPage.selectYourNameFromDropDown();
        customerLoginPage.selectHarryPotterFromDropDown();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlButton();
        accountPage.enterAmountYouWishToWithdrawl("10");
        accountPage.clickOnWithdrawlButtonAfterEnterAmount();
        Assert.assertEquals(accountPage.verifyTransactionSuccessfulMessage(), "Transaction successful", "transaction unsuccessful");


    }
}
