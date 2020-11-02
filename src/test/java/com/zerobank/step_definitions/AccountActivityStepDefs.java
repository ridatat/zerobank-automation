package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class AccountActivityStepDefs {

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        String actualPageTitle = Driver.get().getTitle();
        String expectedPageTitle="Zero - Account Activity";
        Assert.assertEquals(expectedPageTitle,actualPageTitle);

    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        AccountActivityPage accountActivityPage= new AccountActivityPage();

        BrowserUtils.waitForVisibility(accountActivityPage.fromCalendar,5);
        accountActivityPage.fromCalendar.sendKeys(string);

        BrowserUtils.waitForVisibility(accountActivityPage.toCalendar,5);
        accountActivityPage.toCalendar.sendKeys(string2);

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
       BrowserUtils.waitForVisibility(new AccountActivityPage().tableInfoCal,5);
       new AccountActivityPage().checkingCalendarResult(string,string2);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

    }


    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedDropdownOptions) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        String actualDropdown = accountActivityPage.dropdownSelected();
        String expectedDropdown = expectedDropdownOptions;
        Assert.assertEquals(expectedDropdown,actualDropdown);
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().findTransactionsLink.click();
    }



    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForVisibility(new AccountActivityPage().findButton,5);
        new AccountActivityPage().findButton.click();
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.writeDescriptionInputBox(description);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String text) throws InterruptedException {



        BrowserUtils.waitFor(3);
        boolean flag=new AccountActivityPage().getResultMatch(text);
        Assert.assertFalse(flag);



    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(3);
        boolean flag=new AccountActivityPage().getResultMatch(string);
        Assert.assertFalse(flag);

    }


    @Given("refresh the page")
    public void refresh_the_page() {
        Driver.get().navigate().refresh();
    }




}
