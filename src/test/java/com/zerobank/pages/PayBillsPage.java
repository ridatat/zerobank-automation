package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayBillsPage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(),this);
    }


  @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement addNewPayeeTab;


  @FindBy(xpath = "//input[@id='np_new_payee_name']")
  public WebElement  nameInputBox;

  @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement addressInputBox;

  @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement accountInputBox;

  @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement detailInputBox;


  @FindBy(xpath = "//label[contains(@for,'np_new_payee')]")
    public List<WebElement> ınputBoxNames;

  @FindBy(xpath = "//input[@id='add_new_payee']")
  public WebElement addButton;

  @FindBy(xpath = "//div[@id='alert_content']")
  public WebElement alertMsg;






 public void fillAllBox(String PayeeName, String PayeeAddress , String Account , String PayeeDetail) throws InterruptedException {
     BrowserUtils.waitForVisibility(nameInputBox,6);
     nameInputBox.sendKeys(PayeeName);
     BrowserUtils.waitForVisibility(addressInputBox,6);
     addressInputBox.sendKeys(PayeeAddress);
     BrowserUtils.waitForVisibility(accountInputBox,6);
     accountInputBox.sendKeys(Account);
     BrowserUtils.waitForVisibility(detailInputBox,6);
     detailInputBox.sendKeys(PayeeDetail);
     addButton.click();

 }

    public void fillTheBlankName(String name){

    }
    public void fillTheBlankAddress(String address){
        BrowserUtils.waitForVisibility(addressInputBox,4);
        addressInputBox.sendKeys(address);
    }
    public void fillTheBlankAccount(String account){
        BrowserUtils.waitForVisibility(accountInputBox,4);
        accountInputBox.sendKeys(account);
    }
    public void fillTheBlankDetails(String detail){
        BrowserUtils.waitForVisibility(detailInputBox,4);
        detailInputBox.sendKeys(detail);
    }

    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement purchaseForeignCurrencyTab;



    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currenyDropBox;


    @FindBy(xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculateBox;













}
