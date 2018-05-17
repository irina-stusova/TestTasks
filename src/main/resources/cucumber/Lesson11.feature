Feature: Lesson for working with files

  Scenario: Read lines from file and replace two specified words in each line
    Given I read content from file "src\\main\\resources\\lessons\\lesson11\\TextOriginal.txt"
    When I replace 0 word and 2 words and use "\\s*(\\s|,|\\.|\\?)\\s*"
    Then I print Array to console
    Then I write modified List to file "src\\main\\resources\\lessons\\lesson11\\TextModified.txt"

  Scenario: Generate random integers and write to the new file. Sort the file ascending
    Given I write 10 randomly generated List to file "src\\main\\resources\\lessons\\lesson11\\InRandomIntegers.txt"
    When I read content with integers from file "src\\main\\resources\\lessons\\lesson11\\InRandomIntegers.txt"
    When I sort List ascending
    Then I write modified List with numbers to file "src\\main\\resources\\lessons\\lesson11\\OutRandomIntegers.txt"
    Then I print List to console and use " "

  Scenario: Read Java file, reverse characters in each line and write the content to a new file
    Given I read content from file "src\main\java\com\company\lessons\lesson8\StringLearn.java"
    When I reverse all characters in each line and use ""
    Then I print List to console and use ""
    Then I write modified List to file "src\\main\\resources\\lessons\\lesson11\\JavaFileTextReversed.txt"

  Scenario: Read lines from file, capitalize characters in each word longer than some characters
    Given I read content from file "src\\main\\resources\\lessons\\lesson11\\Damasio.txt"
    When I capitalize characters in each word longer than "3" characters and use "\\s*(\\s|,|\\.|\\?)\\s*"
    Then I print List to console and use " "
