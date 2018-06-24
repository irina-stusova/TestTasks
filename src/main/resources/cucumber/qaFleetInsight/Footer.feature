Feature: Check activity of the links on the Login Page Footer

  Scenario: I open the FleetInsight Login Page and check activity of the Contact Us link in the Contact Info section of the Footer
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/contact-us"

  Scenario: I open the FleetInsight Login Page and check activity of the external links in the Contact Info section of the Footer
    When I open url "https://qa.fleetinsight.com"
    When I click the gopenske.com link
    Then I get the page opened in a new browser window and check correctness of the url "https://www.gopenske.com/"
    When I click the Used Trucks link
    Then I get the page opened in a new browser window and check correctness of the url "https://www.penskeusedtrucks.com/"
    When I click the Penske News link
    Then I get the page opened in a new browser window and check correctness of the url "https://www.gopenske.com/newsroom/"

  Scenario: I open the FleetInsight Login Page and check the phone number in the 24/7 Roadside Assistance section of the Footer
    When I open url "https://qa.fleetinsight.com"
    Then I check the Roadside Assistance Support phone number "18005260798"

  Scenario: I open the FleetInsight Login Page and check activity of the links in the For Customers section of the Footer
    When I open url "https://qa.fleetinsight.com"
    And I check the wording of "Legalization Services" link
    And I click the Legalization Services link
    Then I get the page opened in a new browser window and check correctness of the url "https://www.pensketruckleasing.com/for-customers/legalization-services/"
    When I check correctness of the wording of "Safety Bulletins" link
    And I click the Safety Bulletins link
    Then I get the page opened in a new browser window and check correctness of the url "https://www.pensketruckleasing.com/for-customers/safety-bulletins/"

  Scenario: I open the FleetInsight Login Page, check correctness of the copyright year and check activity of the links in the bottom section of the Footer
    When I open url "https://qa.fleetinsight.com"
    And I check correctness of the copyright year "2018"
    And I click the Privacy Policy link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/policy"
    Then I close the Privacy Policy takeover
    And I click the Terms and Conditions link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/terms-of-use"
    Then I close the Terms and Conditions takeover