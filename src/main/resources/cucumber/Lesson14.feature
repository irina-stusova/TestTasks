Feature: Search on the Google page

  Scenario: Open the Google Search page, enter a query, click the first search result link
    Given I open url "https://www.google.com"
    When I enter the text "lisboa" into the Search input field
    When I click the Enter key
    Then I'm presented with the list of search results
    When I click the 0 search result link
    Then I get the page url opened and compare it to required link
