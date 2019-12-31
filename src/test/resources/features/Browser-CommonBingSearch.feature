@Browser-Web @Browser-AOS @Browser-IOS
Feature:

  Scenario: Browser Common Bing Search
    Given I am on bing home page
    When Input something on search text field and hit search
    Then I can see the search result
