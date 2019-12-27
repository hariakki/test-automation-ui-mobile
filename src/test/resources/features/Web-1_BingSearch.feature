@Web
Feature: Web-1_BingSearch

  @Web-1
  Scenario: Bing Search
    Given I am on bing home page
    When Input something on search text field and hit search
    Then I can see the search result


