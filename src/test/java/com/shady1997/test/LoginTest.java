package com.shady1997.test;

import com.shady1997.BaseWeb;
import com.shady1997.data.dynamic.LoginDataFactory;
import com.shady1997.page.purchasing.LoginPage;

import org.testng.annotations.Test;

public class LoginTest extends BaseWeb {

    @Test(priority = 1, description = "Login to SwagLabs Web Application with Valid Data")
    public void LoginWithValidCredentials() throws InterruptedException {
        var loginInformation = LoginDataFactory.createLoginData();

        var loginPage = new LoginPage();
        loginPage.fillEmail(loginInformation.email());
        loginPage.fillPassword(loginInformation.password());
        loginPage.clickLogin();


//        assertThat(detailPage.getAlertMessage())
//                .isEqualTo("Your reservation has been made and we will contact you shortly");
    }
}
