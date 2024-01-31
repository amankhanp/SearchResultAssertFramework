Feature: Search Results Assertion Framework

  Scenario Outline: Perform a search on <search_engine> with "<search_query>" and verify results
    Given I navigate to "<search_engine>" home page
    When I search "<search_query>" on <search_engine> Search Engine
    Then the "<search_engine>" results should contain the keyword "<expected_keyword>" then click on it

    Examples:
      | search_engine | search_query | expected_keyword |
      | Google        | clover       | clover           |
      | Google        | 123          | 123              |
      | Google        | @            | At sign          |
      | Bing          | selenium     | selenium         |
      | Bing          | 123          | 123              |
      | Bing          | #clover      | clover           |