package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage{
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[1]")
    public WebElement savingLink;

    @FindBy(xpath = "//a[text()='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//a[text()='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[text()='Loan']")
    public WebElement loanLink;

    @FindBy(xpath = "//a[text()='Credit Card']")
    public WebElement creditCardlink;


    public WebElement moveToLink(String linkName){
        if (savingLink.getText().contains(linkName)){
            return savingLink;
        }else if(brokerageLink.getText().contains(linkName)){
            return brokerageLink;
        }else if(checkingLink.getText().contains(linkName)){
            return checkingLink;
        }else if (loanLink.getText().contains(linkName)){
            return loanLink;
        }else if (creditCardlink.getText().contains(linkName)){
            return creditCardlink;
        }
        return null;
    }




}
