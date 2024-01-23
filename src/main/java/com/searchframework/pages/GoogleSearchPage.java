package com.searchframework.pages;

import com.searchframework.wrappers.BrowserActions;
import com.searchframework.wrappers.WebElementActions;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

@Log4j2 @Component
public class GoogleSearchPage extends BasePage {

    @Autowired
    public BrowserActions browserActions;

    @Autowired
    public WebElementActions WebElementActions;

    @FindBy(how = How.XPATH, using = "//textarea[@title='Search']")
    public WebElement txtGoogleSearch;

    @FindBy(how = How.XPATH, using = "(//input[@name='btnK'])[2]")
    public WebElement btnGoogleSearch;

    @FindBy(how = How.XPATH, using = "(//div[@class='pcTkSc'])[1]")
    public WebElement ddlGoogleSearchSuggestion;

    @FindBy(how = How.CSS, using = "h3")
    public List<WebElement> lnkSearchResult;

    public void navigateToGoogleHomePage(String browserName) {
        browserActions.openBrowser(browserName);
    }

    public void performGoogleSearch(String searchText) {
        Assert.isTrue(WebElementActions.isElementVisible(txtGoogleSearch), "google search text box is not present");

        WebElementActions.clearAndType(txtGoogleSearch, searchText);

        WebElementActions.onClick(ddlGoogleSearchSuggestion);
        //WebElementActions.onClick(btnGoogleSearch);
    }
}
