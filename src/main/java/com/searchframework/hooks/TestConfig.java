package com.searchframework.hooks;

import com.searchframework.constants.ConfigConstants;
import com.searchframework.utilities.PropertiesUtils;
import com.searchframework.wrappers.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Log4j2
public class TestConfig {

    @Autowired
    public WebDriver webDriver;

    @Autowired
    public BrowserActions browserActions;

    @Value("${BROWSER}")
    public String browserName;

    @Before(order = 0)
    public void initialize() {
        webDriver.manage().window().maximize();
        browserActions.implicitWait();
        log.info("User launching " + browserName + " browser");
    }

    @After(order = 0)
    public void cleanUp() {
        browserActions.quitBrowser();
        System.out.println("browser closed successfully");
    }
}