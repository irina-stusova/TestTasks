Feature: Search and booking on the UkrZaliznytsya website

  Scenario: Open the UkrZaliznytsya Search page, enter a departure city and an arrival city, click the submit search button
    Given I open url "https://booking.uz.gov.ua/ru/"
    When I enter the text "Кие" into the From input field
#    Then The autocomplete list with id "ui-id-1" is shown
    Then I select the option matching my query "Киев" from list with id "ui-id-1"
    When I enter the text "Мел" into the To input field
#    Then The autocomplete list with id "ui-id-2" is shown
    Then I select the option matching my query "Мелитополь" from list with id "ui-id-2"
    When I click the Calendar field
#    When I click the Departure Day link
    When I click the Search Trains On button
    Then I'm presented with search results
#    When I click the 0 search result link
#    Then I get the page url opened and compare it to required link
#    Then I close all windows