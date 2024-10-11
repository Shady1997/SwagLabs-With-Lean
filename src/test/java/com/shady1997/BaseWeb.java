package com.shady1997;

import com.shady1997.driver.DriverManager;
import com.shady1997.driver.TargetFactory;
import com.shady1997.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static com.shady1997.config.ConfigurationManager.configuration;
import static com.shady1997.util.Utility.executeCommand;
import static com.shady1997.util.Utility.replaceLinesInAllureReportHtmlFile;

public abstract class BaseWeb {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() throws IOException, InterruptedException {
        DriverManager.quit();
//        executeCommand("C:\\Pentest\\1-file-upload\\test_files\\allure-2.30.0\\allure-2.30.0\\bin\\allure generate --single-file target/allure-results");
//        replaceLinesInAllureReportHtmlFile(System.getProperty("user.dir") + "/allure-report/index.html");

    }

}
