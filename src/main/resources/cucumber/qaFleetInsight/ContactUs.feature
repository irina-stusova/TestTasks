Feature: Check functionality of the Contact Us Form

  Scenario: I open the Contact Us Form and check correctness of the Customer Service phone number
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    Then I get the page opened in the same browser window and check correctness of the url "https://qa.fleetinsight.com/fiportal/public/contact-us"
    Then I check correctness of the Customer Service phone "8444264555"

  Scenario: I open the Contact Us Form and check correctness of the Road Assistance phone number
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    Then I check correctness of the Road Assistance phone "8005260798"

  Scenario: I open the Contact Us Form and check that "SELECT" is shown as a placeholder for the Salutation, Best Time To Reach You, Reason For Contact dropdowns
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    Then I check that "SELECT" is shown as a placeholder for the "SALUTATION" dropdown
    Then I check that "SELECT" is shown as a placeholder for the "Best Time To Reach you?" dropdown
    Then I check that "SELECT" is shown as a placeholder for the "Reason for contact?" dropdown

  Scenario: I open the Contact Us Form and check the placeholders shown for Input fields
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    Then I check that "First name" is shown as a placeholder for the "firstName" input field
    And I check that "Last name" is shown as a placeholder for the "lastName" input field
    And I check that "Email" is shown as a placeholder for the "email" input field
    And I check that "Email" is shown as a placeholder for the "emailAlternate" input field
    And I check that "Telephone" is shown as a placeholder for the "phone" input field

  Scenario: I open the Contact Us Form and check options of the Salutation dropdown
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    When I click the dropdown control for "combobox__1"
    And I get dropdown options as a list using locator ".//ul[@aria-labelledby='combobox__1']/li[%s]"
    Then I compare the actual options list with the expected options list
      | MR.  |
      | MRS. |
      | MS.  |
      | DR.  |

  Scenario: I open the Contact Us Form and check options of the Best Time To Reach You dropdown
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    When I click the dropdown control for "combobox__2"
    And I get dropdown options as a list using locator ".//ul[@aria-labelledby='combobox__2']/li[%s]"
    Then I compare the actual options list with the expected options list
      | MORNING 8AM - 12 PM EST  |
      | AFTERNOON 12PM - 4PM EST |
      | EVENING 4PM - 8PM EST    |
      | ANYTIME 8AM - 8PM EST    |

  Scenario: I open the Contact Us Form and check options of the Reason For Contact dropdown
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    When I click the dropdown control for "combobox__3"
    And I get dropdown options as a list using locator ".//ul[@aria-labelledby='combobox__3']/li[%s]"
    Then I compare the actual options list with the expected options list
      | QUESTION ABOUT A UNIT    |
      | PREVENTATIVE MAINTENANCE |
      | BILLING                  |
      | 24/7 ROAD SERVICE        |
      | SAFETY                   |
      | FUEL FINDER              |
      | OTHER INQUIRY            |
      | FEEDBACK                 |

  Scenario: I open the Contact Us Form and check ability to toggle between the Contact Types
    When I open url "https://qa.fleetinsight.com"
    And I click the Contact Us link
    Then I check the Phone radio button is preselected by default
    Then I select the Email radio button
    Then I select the Phone radio button