package com.searchframework.pages;

import com.searchframework.wrappers.WebElementActions;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

@Log4j2
@Component
public class BingSearchPage extends BasePage {

    @Autowired
    public WebDriver webDriver;

    @Autowired
    public WebElementActions WebElementActions;

    @FindBy(how = How.XPATH, using = "//textarea[@id='sb_form_q']")
    public WebElement txtBingSearch;

    @FindBy(how = How.XPATH, using = "(//input[@name='btnK'])[2]")
    public WebElement btnBingSearch;

    @FindBy(how = How.XPATH, using = "//label[contains(@class,'search icon')]")
    public WebElement btnBingSearch1;

    @FindBy(how = How.XPATH, using = "(//span[@class='sa_tm_text'])[2]")
    public WebElement ddlBingSearchSuggestion;

    @FindBy(how = How.XPATH, using = "//ol[@id='b_results']/li//a[@href]")
    public List<WebElement> lnkSearchResult;

    public void performBingSearch(String searchText) {
        Assert.isTrue(WebElementActions.isElementVisible(txtBingSearch), "bing search text box is not present");

        WebElementActions.clearAndType(txtBingSearch, searchText);

        try{
            WebElementActions.onClick(ddlBingSearchSuggestion);
        } catch (Exception e) {
            if (webDriver.getCurrentUrl().contains("bing.com")){
                WebElementActions.onClick(btnBingSearch1);
            }
        }
    }
}
