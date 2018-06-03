Feature: Search and booking on the UkrZaliznytsya website

  Scenario: Open the UkrZaliznytsya Search page, enter a departure city and an arrival city, click the submit search button
    Given I open url "https://booking.uz.gov.ua"
    When I enter the text "Киев" into the From input field
    When I enter the text "Мелитополь" into the To input field
    When I click the Day link
    When I click the Search Trains On button
#    Then I'm presented with the list of trains search results
#    When I click the 0 search result link
#    Then I get the page url opened and compare it to required link
#    Then I close all windows