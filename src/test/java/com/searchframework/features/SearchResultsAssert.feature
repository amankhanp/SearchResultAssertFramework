Feature: Search Results Assertion Framework

  Scenario: Search text using google search engine
    Given I navigate to "https://www.google.com/" home page
    When I search "clover" on Google Search Engine
    Then the search results should contain the keyword "clover" then click on it

  Scenario: Search number using google search engine
    Given I navigate to "https://www.google.com/" home page
    When I search "123" on Google Search Engine
    Then the search results should contain the keyword "123" then click on it

  Scenario: Search number using google search engine
    Given I navigate to "https://www.google.com/" home page
    When I search "@" on Google Search Engine
    Then the search results should contain the keyword "At sign" then click on it

  Scenario: Search text using bing search engine
    Given I navigate to "https://www.bing.com/" bing page
    When I search "clover.com" on Bing Search Engine
    Then the bing results should contain the keyword "clover" then click on it

  Scenario: Search number using bing search engine
    Given I navigate to "https://www.bing.com/" bing page
    When I search "123" on Bing Search Engine
    Then the bing results should contain the keyword "123" then click on it

  Scenario: Search number using bing search engine
    Given I navigate to "https://www.bing.com/" bing page
    When I search "@clover" on Bing Search Engine
    Then the bing results should contain the keyword "clover" then click on it