package com.searchframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class BasePage {

    @Autowired
    public WebDriver webDriver;

    @Value("${google.url}")
    public String googleURL;

    @Value("${bing.url}")
    public String bingURL;

    @PostConstruct
    public void initializeElements() {
        PageFactory.initElements(new DefaultElementLocatorFactory(webDriver), this);
    }

    public void navigateToSearchPage(String searchEngine) {
        if (searchEngine.equalsIgnoreCase("google")) {
            webDriver.get(googleURL);
        } else if (searchEngine.equalsIgnoreCase("bing")) {
            webDriver.get(bingURL);
        }
    }
}
