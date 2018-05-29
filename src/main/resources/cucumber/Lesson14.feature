Feature: Search on the Google page

  Scenario: Open the Google Search page, enter a query, click the first search result link
    Given I open url "https://www.google.com"
    When I enter the text "lisboa" into the Search input field
    Then I click the Enter key
    Then I do the most insane things I have ever done
#    Then I'm presented with the list of search results
#    When I click the 1 search result link
#    Then The url is opened
#    Then I get page url