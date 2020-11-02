package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement usernameInputBox;

    @FindBy(css = "#user_password")
    public WebElement passwordInputBox;

    @FindBy(css = ".btn.btn-primary")
    public WebElement loginButton;

    public void login(String usernameStr, String passwordStr){
        usernameInputBox.sendKeys(usernameStr);
        passwordInputBox.sendKeys(passwordStr);
        loginButton.click();
    }

}
