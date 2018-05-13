package com.company.lessons.tests;

import com.company.lessons.lesson11.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.lessons.lesson11.RandomInts.writeNumbersToFile;

public class Lesson11StepDefs {

    private List<String> initialFileContent;
    private List<String> modifiedFileContent;
    private List<Integer> originalFileContent;
    private String[][] array;

    ////<editor-fold desc="Given">
    @Given("^I read content from file \"([^\"]*)\"$")
    public void iReadContentFromFile(String fileName) {
        initialFileContent = FileUtils.readFileAsList(fileName);
    }

    @Given("^I write (\\d+) randomly generated List to file \"([^\"]*)\"$")
    public void iWriteRandomlyGeneratedListToFile(int count, String fileName) throws IOException {
        RandomInts randomInts = new RandomInts();
        List<String> randomList = new ArrayList(randomInts.generateRandomList(count));
        writeNumbersToFile(randomList, fileName);
    }

    ////</editor-fold>
    ////<editor-fold desc="When">
    @When("^I replace first word and last words$")
    public void iReplaceFirstWordAndLastWords() {
        SwapWords swapWords = new SwapWords();
        array = swapWords.convertListToArray(initialFileContent);
        array = swapWords.getArrayWithSwappedWords(array);
        modifiedFileContent = swapWords.convertArrayWithSwappedWordsToList(array);
    }

    @When("^I read content with integers from file \"([^\"]*)\"$")
    public void iReadContentWithIntegersFromFile(String fileName) {
        originalFileContent = new RandomInts().readFromFile(fileName);
    }

    @When("^I sort List ascending$")
    public void iSortListAscending() {
        RandomInts randomInts = new RandomInts();
        modifiedFileContent = randomInts.getSortedList(originalFileContent);
    }

    @When("^I reverse all characters in each line$")
    public void iReverseAllCharactersInEachLine() throws IOException {
        JavaFileReversed jfr = new JavaFileReversed();
        array = jfr.getListAsArray(initialFileContent);
        modifiedFileContent = jfr.getTextReversed(array);
    }

    @When("^I capitalize characters in each word longer than \"([^\"]*)\" characters$")
    public void iCapitalizeCharactersInEachWordLongerThanCharacters(int num) throws IOException {
        CaseChange caseChange = new CaseChange();
        array = caseChange.convertListToArray(initialFileContent);
        modifiedFileContent = caseChange.convertArrayToList(array);
        modifiedFileContent = caseChange.toUpperCase(modifiedFileContent, 3);
    }

    ////</editor-fold>
    ////<editor-fold desc="Then">
    @Then("^I print Array to console$")
    public void iPrintArrayToConsole() {
        FileUtils.printArray(array);
    }

    @Then("^I write modified List to file \"([^\"]*)\"$")
    public void iWriteModifiedListToFile(String fileName) throws IOException {
        FileUtils.writeToFile(modifiedFileContent, fileName);
    }

    @Then("^I print List to console$")
    public void iPrintListToConsole() {
        FileUtils.printList(modifiedFileContent);
    }

    @Then("^I write modified List with numbers to file \"([^\"]*)\"$")
    public void iWriteModifiedListWithNumbersToFile(String fileName) throws IOException {
        RandomInts.writeNumbersToFile(modifiedFileContent, fileName);
    }
    ////</editor-fold>
}