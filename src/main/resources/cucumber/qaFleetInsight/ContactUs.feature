Feature: Check functionality of the Contact Us Form

  Scenario: [Not in JIRA] I open the Contact Us Form and check correctness of the Customer Service phone number
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/contact-us"
    Then I check correctness of the "CUSTOMER_SERVICE" phone "(844) 426-4555"

  Scenario: [Not in JIRA] I open the Contact Us Form and check correctness of the Road Assistance phone number
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    Then I check correctness of the "ROAD_ASSISTANCE" phone "(800) 526-0798"

  Scenario: [FI-2043] Check that SELECT is a default value for all dropdowns on the Contact Us takeover (user is logged in)
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Contact Us" link
    Then I check that "SELECT" is shown as a placeholder for the "SALUTATION" dropdown
    Then I check that "SELECT" is shown as a placeholder for the "Best Time To Reach you?" dropdown
    Then I check that "SELECT" is shown as a placeholder for the "Reason for contact?" dropdown

  Scenario: [FI-1175] Check that fields are not pre-populated if the Contact Us takeover was invoked from the Login Page
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    Then I check that "First name" is shown as a placeholder for the "FIRST NAME" input field
    And I check that "Last name" is shown as a placeholder for the "LAST NAME" input field
    And I check that "Email" is shown as a placeholder for the "EMAIL" input field
    And I check that "Email" is shown as a placeholder for the "ALTERNATIVE EMAIL" input field
    And I check that "Telephone" is shown as a placeholder for the "TELEPHONE" input field

  Scenario: [Find in JIRA] Check that input fields are pre-populated if the Contact Us takeover was invoked after user logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the Left Panel Menu icon
    And I click the "My Profile" link in the Left Panel footer
    Then I get the current user basic information
    When I click the "Contact Us" link
    Then I check that input fields are pre-populated with current user data available

  Scenario: I open the Contact Us Form and check options of the Salutation dropdown
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    When I click the dropdown control for "SALUTATION" dropdown
    And I get "SALUTATION" dropdown options as a list
    Then I compare the actual options list with the expected options list
      | MR.  |
      | MRS. |
      | MS.  |
      | DR.  |

  Scenario: I open the Contact Us Form and check options of the Best Time To Reach You dropdown
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    When I click the dropdown control for "Best Time To Reach you?" dropdown
    And I get "Best Time To Reach you?" dropdown options as a list
    Then I compare the actual options list with the expected options list
      | MORNING 8AM - 12 PM EST  |
      | AFTERNOON 12PM - 4PM EST |
      | EVENING 4PM - 8PM EST    |
      | ANYTIME 8AM - 8PM EST    |

  Scenario: I open the Contact Us Form and check options of the Reason For Contact dropdown
    When I open url "https://qa.fleetinsight.com"
    And I click the "Contact Us" link
    When I click the dropdown control for "Reason for contact?" dropdown
    And I get "Reason for contact?" dropdown options as a list
    Then I compare the actual options list with the expected options list
      | QUESTION ABOUT A UNIT    |
      | PREVENTATIVE MAINTENANCE |
      | BILLING                  |
      | 24/7 ROAD SERVICE        |
      | SAFETY                   |
      | FUEL FINDER              |
      | OTHER INQUIRY            |
      | FEEDBACK                 |

  Scenario: [FI-1227] Check that a user can select the way to be contacted on the Contact Us takeover if the user is logged in
    When I open url "https://qa.fleetinsight.com"
    And I login to the App with UserId "random@test.com" and Password "Pa55word"
    And I click the "Contact Us" link
    Then I check the "Phone" radio button is preselected by default
    Then I select the "Email" radio button
    Then I select the "Phone" radio button