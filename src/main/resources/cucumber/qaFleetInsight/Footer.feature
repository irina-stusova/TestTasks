Feature: Check activity of the links on the Login Page Footer

  Scenario: FI-1230: Check activity of the Contact Us link on the Login Page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/contact-us"
    When I click the "BACK" button
    Then I get the Login page shown "https://qa.fleetinsight.com/ssofiles/login.fcc"


  Scenario: FI-1248 (1): Check activity of the external links in the footer of the Login page
    When I open url "https://qa.fleetinsight.com"
    And I click the "gopenske.com" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://www.gopenske.com/"


  Scenario: FI-1248 (2): Check activity of the external links in the footer of the Login page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Used Trucks" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://www.penskeusedtrucks.com/"


  Scenario: FI-1248 (3): Check activity of the external links in the footer of the Login page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Penske News" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://www.gopenske.com/newsroom/"


  Scenario: FI-1519: Check activity of the Legalization Services link in the footer
    When I open url "https://qa.fleetinsight.com"
#    And I check correctness of the wording "Legalization Services" for "Legalization Services" link
    And I click the "Legalization Services" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://www.pensketruckleasing.com/for-customers/legalization-services/"
    When I enter "random@test.com" into the "UserId" field
    And I enter "Pa55word" into the "Password" field
    And I click the "LOG IN" button
#    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/fleet"
    And I click the "Legalization Services-Global" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://qa.pensketruckleasing.com/for-customers/legalization-services/"


  Scenario: FI-1520: Check activity of the Safety Bulletins link in the footer
    When I open url "https://qa.fleetinsight.com"
#    And I check correctness of the wording "Safety Bulletins" for "Safety Bulletins" link
    And I click the "Safety Bulletins" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://www.pensketruckleasing.com/for-customers/safety-bulletins/"
    When I enter "random@test.com" into the "UserId" field
    And I enter "Pa55word" into the "Password" field
    And I click the "LOG IN" button
#    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/fleet"
    And I click the "Safety Bulletins-Global" link
#    Then I get the page opened in a new browser window and check correctness of the url "https://qa.pensketruckleasing.com/for-customers/safety-bulletins/"


  Scenario: [FI-1248] Check activity of the Privacy Policy link in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    When I enter "random@test.com" into the "UserId" field
    And I enter "Pa55word" into the "Password" field
    And I click the "LOG IN" button
#    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/fleet"
    And I click the "Privacy Policy-Global" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/policy"
    Then I close the "Privacy Policy" takeover


  Scenario: [FI-1250] Check activity of the Terms and Conditions link in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    When I enter "random@test.com" into the "UserId" field
    And I enter "Pa55word" into the "Password" field
    And I click the "LOG IN" button
#    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/fleet"
    When I click the "Terms and Conditions-Global" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/terms-of-use"
    Then I close the "Terms and Conditions" takeover

  Scenario: [FI-2038] Check that the current year is shown in the Login page footer
    When I open url "https://qa.fleetinsight.com"
    And I check correctness of the copyright year


  Scenario: [Not in JIRA] I open the FleetInsight Login Page and check the phone number in the 24/7 Roadside Assistance section of the Footer
    When I open url "https://qa.fleetinsight.com"
    Then I check the Roadside Assistance Support phone number "1-800-526-0798"