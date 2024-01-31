package com.searchframework.steps;

import com.searchframework.hooks.WebDriverConfig;
import com.searchframework.pages.BingSearchPage;
import com.searchframework.pages.GoogleSearchPage;
import com.searchframework.wrappers.BrowserActions;
import com.searchframework.wrappers.WebElementActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@CucumberContextConfiguration
@ContextConfiguration(classes={WebDriverConfig.class, BrowserActions.class, WebElementActions.class, GoogleSearchPage.class, BingSearchPage.class})
public class SearchSteps {

    @Autowired
    public GoogleSearchPage googleSearchPage;

    @Autowired
    public BingSearchPage bingSearchPage;

    @Given("I navigate to {string} home page")
    public void iNavigateToHomePage(String browserName) {
        googleSearchPage.navigateToSearchPage(browserName);
    }

    @When("I search {string} on Google Search Engine")
    public void iSearchOnGoogleSearchEngine(String searchKeyword) {
        googleSearchPage.performGoogleSearch(searchKeyword);
    }

    @When("I search {string} on Bing Search Engine")
    public void iSearchOnBingSearchEngine(String searchKeyword) {
        bingSearchPage.performBingSearch(searchKeyword);
    }

    @Then("the {string} results should contain the keyword {string} then click on it")
    public void validateAndClickSearchResult(String searchEngine, String keyword) {
        List<WebElement> textResults = getSearchResults(searchEngine);

        assertTrue("The expected text is not present in search results",
                textResults.stream().anyMatch(result -> {
                    if (result.getText().toLowerCase().contains(keyword.toLowerCase())) {
                        result.click();
                        return true;
                    }
                    return false;
                }));
    }

    private List<WebElement> getSearchResults(String searchEngine) {
        switch (searchEngine.toLowerCase()) {
            case "google":
                return googleSearchPage.lnkSearchResult;
            case "bing":
                return bingSearchPage.lnkSearchResult;
            default:
                throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
        }
    }
}
