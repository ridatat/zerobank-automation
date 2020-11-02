package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#aa_accountId")
    public WebElement dropdown;

    public String dropdownSelected(){
        Select accountDropDown = new Select(dropdown);
        return accountDropDown.getFirstSelectedOption().getText();
    }

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactionsLink;

    @FindBy(xpath = "//button[contains(text(),'Find')]")
    public WebElement findButton;

    @FindBy(xpath = "//div//input[@type='text' and @id='aa_description']")
    public WebElement descriptionInputBox;

    public void writeDescriptionInputBox(String a){
       BrowserUtils.waitForClickablility(descriptionInputBox,5);
       new AccountActivityPage().descriptionInputBox.clear();
       descriptionInputBox.sendKeys(a);
    }

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> tableDescriptionInfo;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']")
    public WebElement tableDes;



    public boolean checkingContains(String text) throws InterruptedException {

       boolean flag=true;

       for (WebElement element : tableDescriptionInfo) {
           //BrowserUtils.waitForVisibility(tableDes,4);
           System.out.println(element.getText());
           if(!element.getText().contains(text)){
               flag=false;
               break;
           }
       }
       return flag;
    }

    @FindBy(css = "#ui-datepicker-div")
    public WebElement Calendar;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromCalendar;

    @FindBy(css = "#aa_toDate")
    public WebElement toCalendar;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")
    public List<WebElement> tableInfoCalendar;

    @FindBy(xpath = "(//div[@id='filtered_transactions_for_account']//tbody//tr//td[1])[1]")
    public WebElement tableInfoCal;

    //çalışmıyor amk
    public Boolean checkingCalendarResult(String str,String str2){

        ArrayList<Integer> a = new ArrayList<>();
        boolean marker=true;

        for (WebElement element : tableInfoCalendar) {
            System.out.println(element.getText());
            for (int i = 0; i < tableInfoCalendar.size(); i++) {
                a.add(i,Integer.parseInt(element.getText()));
            }

        }
        System.out.println(a.toString());
        Collections.sort(a); //ascending

        int fromDate=Integer.parseInt(str);
        int toDate=Integer.parseInt(str2);
        if(!(a.get(0) >= fromDate) || !(a.get(a.size()-1)<= toDate)){
            marker=false;
        }

        return marker;
    }

    public boolean getResultMatch(String description){
        boolean flag=true;

        for (WebElement result :tableDescriptionInfo ) {
            System.out.println("result.getText() = " + result.getText());
            if(!result.getText().contains(description)){
                flag=false;
                break;
            }}

        return flag;

    }

}
