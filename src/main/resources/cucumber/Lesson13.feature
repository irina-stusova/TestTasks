Feature: Passing different data types as arguments into steps

  Scenario: Pass ENUM as an argument into the step and print the value
    When I pass enum value "MONDAY"
    Then I print the enum to console

  Scenario: Pass TABLE as an argument into the step and print the table
    When I pass the table then I print the table to console
      | Name      | IsWeekend | DayOfWeek |
      | Monday    | false     | 1         |
      | Tuesday   | false     | 2         |
      | Wednesday | false     | 3         |
      | Thursday  | false     | 4         |
      | Friday    | false     | 5         |
      | Saturday  | true      | 6         |
      | Sunday    | true      | 7         |

  Scenario: Pass MULTI-LINE TEXT as an argument into the step and print the text
    When I pass multi-line text
    """
    Yesterday is history,
    tomorrow is a mystery,
    today is a gift of God,
    which is why we call it the present.
    """
    Then I print the text to console

  Scenario: Pass DATE as an argument into the step and print the value
    When I pass the date 26-08-1982
    Then I print the date to console

  Scenario: Pass LISTS as arguments into the step and print the lists
    When I pass the list 1,2,3 and another list 3,5,8
    Then I print two lists to console

  Scenario: Pass LIST as an argument into the step and print the list
    When I pass June, July, August as a list
    Then I print the list to console

  Scenario: Pass NUMBER as an argument into the step and print the number
    When I pass the number 7
    Then I print the number to console

  Scenario: Pass BOOLEAN as an argument into the step and print the Boolean
    When I pass the boolean true
    When I pass the boolean false