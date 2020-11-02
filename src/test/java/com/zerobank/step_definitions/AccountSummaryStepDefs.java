package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AccountSummaryStepDefs {



    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkName) {


        new AccountSummaryPage().moveToLink(linkName).click();

    }

    @Given("the user navigate to {string}")
    public void the_user_navigate_to(String tabName) {
        new AccountSummaryPage().navigateToTab(tabName);
    }


}
