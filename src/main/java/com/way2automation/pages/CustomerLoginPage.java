package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement yourName;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logout;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameMessage;

    public void selectYourNameFromDropDown(){
        Reporter.log("Select option from dropdown"+yourName.toString());
        selectByVisibleTextFromDropDown(yourName,"Krish Patel");
    }
    public void selectHarryPotterFromDropDown(){
        Reporter.log("Seelect option from drop down");
        selectByVisibleTextFromDropDown(yourName,"Harry Potter");
    }
    public void clickOnLoginButton(){
        Reporter.log("Click on login button "+login.toString());
        clickOnElement(login);
    }
    public String verifyLogOutText(){
        Reporter.log("Verify logout text "+logout.toString());
        return getTextFromElement(logout);
    }
    public void cliclOnLogoutButton(){
        Reporter.log("Click on logout button "+logout.toString());
        clickOnElement(logout);
    }
    public String verifyYourNameText(){
        Reporter.log("Verify text "+yourNameMessage.toString());
        return getTextFromElement(yourNameMessage);
    }


}
