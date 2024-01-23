package com.searchframework.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Log4j2
@Component
public class BrowserActions {

    public WebDriverWait webDriverWait;

    //@Value("${STANDARD_TIMEOUT_IN_SEC}")
    public int standardWaitTime = 10;

    @Autowired
    public WebDriver driver;

    public void openBrowser(String url) {
        driver.manage().window().maximize();
        implicitWait();
        log.info("User launched maximized browser window successfully");
        driver.navigate().to(url);
        log.info("User navigated to the given URL: " + url);
    }

    public void quitBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        log.info("All browser closed successfully");
    }

    public void implicitWait() {
        log.debug("Application waiting till standard wait time");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getStandardWaitTime()));
    }

    public int getStandardWaitTime(){
        return standardWaitTime;
    }

    public WebDriverWait waitTill() {
        log.debug("Application waits until time out in secs ");
        return waitTill(getStandardWaitTime());
    }

    public WebDriverWait waitTill(int timeOutInSec) {
        log.debug("Application waits until time out in secs " + timeOutInSec);
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
    }

    public WebElement waitForElementToVisible(WebElement webElement) {
        log.debug("Application waiting for the element " + webElement + " to be visible");
        webDriverWait = waitTill();
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForElementToClickable(WebElement webElement) {
        log.debug("Application waiting for the element " + webElement + " to be clickable");
        webDriverWait = waitTill();
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement fluentWait(final WebElement locatorElement){
        log.debug("Application waiting for the element " + locatorElement + "to be visible");

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(
                Duration.ofSeconds(Long.parseLong(String.valueOf(standardWaitTime))))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> locatorElement);
    }
}
