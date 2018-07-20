Feature: Check activity of the links on the Login Page Footer

  Scenario: [FI-1230] Check activity of the Contact Us link on the Login Page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/contact-us"
    When I click the "Back" button
    Then I get the Login page shown "https://qa.fleetinsight.com/ssofiles/login.fcc"

  Scenario: [FI-1174-1] Check activity of the external links in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "gopenske.com" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.gopenske.com/
      """

  Scenario: [FI-1174-2] Check activity of the external links in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Used Trucks" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.penskeusedtrucks.com/
      """

  Scenario: [FI-1174-3] Check activity of the external links in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Penske News" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.gopenske.com/newsroom/
      """

  Scenario: [FI-1174-4] Check activity of the external links in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    Then I check if the "4REFUEL" link is present in footer



  Scenario: [FI-1248-1] Check activity of the external links in the footer of the Login page
    When I open url "https://qa.fleetinsight.com"
    And I click the "gopenske.com" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.gopenske.com/
      """

  Scenario: [FI-1248-2] Check activity of the external links in the footer of the Login page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Used Trucks" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.penskeusedtrucks.com/
      """

  Scenario: [FI-1248-3] Check activity of the external links in the footer of the Login page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Penske News" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.gopenske.com/newsroom/
      """

  Scenario: [FI-1519-1] Check activity of the Legalization Services link in the footer
    When I open url "https://qa.fleetinsight.com"
    And I click the "Legalization services" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.pensketruckleasing.com/for-customers/legalization-services/
      """

  Scenario: [FI-1519-2] Check activity of the Legalization Services link in the footer (logged in)
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Legalization Services" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://qa.pensketruckleasing.com/for-customers/legalization-services/
      """

  Scenario: [FI-1520-1] Check activity of the Safety Bulletins link in the footer
    When I open url "https://qa.fleetinsight.com"
    And I click the "Safety bulletins" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://www.pensketruckleasing.com/for-customers/safety-bulletins/
      """

  Scenario: [FI-1520-2] Check activity of the Safety Bulletins link in the footer (logged in)
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Safety Bulletins" link
    Then I check new browser tab is opened and "equals to" expected url:
      """
      https://qa.pensketruckleasing.com/for-customers/safety-bulletins/
      """

  Scenario: [FI-1248] Check activity of the Privacy Policy link in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Privacy Policy" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/policy"
    Then I close the "Privacy Policy" takeover

  Scenario: [FI-1250] Check activity of the Terms and Conditions link in the footer when a user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    When I click the "Terms and Conditions" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/terms-of-use"
    Then I close the "Terms and Conditions" takeover

  Scenario: [FI-2038] Check that the current year is shown in the Login page footer
    When I open url "https://qa.fleetinsight.com"
    And I check correctness of the copyright year

  Scenario: [Not in JIRA] I open the FleetInsight Login Page and check the phone number in the 24/7 Roadside Assistance section of the Footer
    When I open url "https://qa.fleetinsight.com"
    Then I check the Roadside Assistance Support phone number "1-800-526-0798"