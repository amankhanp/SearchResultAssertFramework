package com.searchframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BasePage {

    @Autowired
    public WebDriver webDriver;

    @PostConstruct
    public void initializeElements() {
        PageFactory.initElements(new DefaultElementLocatorFactory(webDriver), this);
    }
}
