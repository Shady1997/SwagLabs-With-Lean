package com.shady1997.page.purchasing;

import com.shady1997.page.purchasing.common.NavigationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends NavigationPage {

    @FindBy(id = "user-name")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login;


    @Step
    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    @Step
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step
    public void clickLogin() {
        login.click();
    }

}
