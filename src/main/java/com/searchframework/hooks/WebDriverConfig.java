package com.searchframework.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class WebDriverConfig {

    @Value("#{'${list.of.browser.names}'.split(',')}")
    private List<String> supportedBrowsers;

    @Bean
    public WebDriver setBrowser(@Value("${browser.name: chrome}") String browserName) {
        if (!supportedBrowsers.contains(browserName.toLowerCase())) {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        WebDriver driver = null;

        //browserName = "chrome";
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
