package com.shady1997.page;

import com.shady1997.driver.DriverManager;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.shady1997.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
    }
}
