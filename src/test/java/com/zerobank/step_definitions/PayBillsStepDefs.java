package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.Map;

public class PayBillsStepDefs {
    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.addNewPayeeTab,5);
        payBillsPage.addNewPayeeTab.click();


    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> newPayeeInfo) throws InterruptedException {
        System.out.println(newPayeeInfo);

        payBillsPage.fillAllBox(newPayeeInfo.get("Payee Name"),
                                newPayeeInfo.get("Payee Address"),
                                newPayeeInfo.get("Account"),
                                 newPayeeInfo.get("Payee details"));

    }


    @When("the user write {string} in name box")
    public void the_user_write_in_name_box(String string)  {
        BrowserUtils.waitForVisibility(payBillsPage.nameInputBox,4);
        payBillsPage.nameInputBox.sendKeys(string);


    }

    @When("the user write {string} in address box")
    public void the_user_write_in_address_box(String string)  {
        payBillsPage.fillTheBlankAddress(string);
    }

    @When("the user write {string} in account box")
    public void the_user_write_in_account_box(String string)  {
        payBillsPage.fillTheBlankAccount(string);
    }

    @When("the user write {string} in details box")
    public void the_user_write_in_details_box(String string) {
        payBillsPage.fillTheBlankDetails(string);

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        Boolean actualR= payBillsPage.alertMsg.getText().contains(payBillsPage.nameInputBox.getText());
        Boolean expectedR= true;
        Assert.assertEquals(expectedR,actualR);
    }



    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        BrowserUtils.waitForVisibility(payBillsPage.purchaseForeignCurrencyTab,8);
        payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> availableCurrency) throws InterruptedException {

        Thread.sleep(3000);
        Select dropbox = new Select(payBillsPage.currenyDropBox);
        for (int i = 0; i <availableCurrency.size(); i++) {
            dropbox.selectByVisibleText(availableCurrency.get(i));
            Assert.assertEquals(availableCurrency.get(i),dropbox.getFirstSelectedOption().getText());
            System.out.println(dropbox.getFirstSelectedOption().getText());
        }

    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitForClickablility(payBillsPage.calculateBox,5);
        payBillsPage.calculateBox.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() throws InterruptedException {
        Alert alert = Driver.get().switchTo().alert();
        String actualResult = alert.getText();

        alert.accept();
        String exceptedResult="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(exceptedResult,actualResult);

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() throws InterruptedException {
        BrowserUtils.waitForVisibility(payBillsPage.currenyDropBox,6);
        Select dropbox = new Select(payBillsPage.currenyDropBox);
        dropbox.selectByIndex(1);
        Thread.sleep(3000);
        payBillsPage.calculateBox.click();

    }



}
