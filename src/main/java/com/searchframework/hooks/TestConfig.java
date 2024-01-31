package com.searchframework.hooks;

import com.searchframework.wrappers.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Log4j2
@PropertySource("classpath:application.properties")
public class TestConfig {

    @Autowired
    public WebDriver webDriver;

    @Autowired
    public BrowserActions browserActions;

    @Before
    public void initialize(@Value("${browser.name}") String browserName) {
        try {
            webDriver.manage().window().maximize();
            browserActions.implicitWait();
            log.info("User launching {} browser", browserName);
        } catch (Exception e) {
            log.error("Error during initialization: {}", e.getMessage());
            throw e;
        }
    }

    @After
    public void cleanUp() {
        try {
            browserActions.quitBrowser();
            log.info("Browser closed successfully");
        } catch (Exception e) {
            log.error("Error during cleanup: {}", e.getMessage());
        }
    }
}