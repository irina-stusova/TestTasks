package com.penske.products.fleetinsight.tests.definitions.lessons;

import com.penske.lessons.lesson11.*;
import com.penske.lessons.utils.ArrayUtils;
import com.penske.lessons.utils.ListUtils;
import com.penske.lessons.utils.FileUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static com.penske.lessons.utils.FileUtils.writeListToFile;

public class Lesson11StepDefs {

    private List<String> initialStringList;
    private List<String> modifiedList;
    private List<Integer> initialIntsList;
    private String[][] array;

    ////<editor-fold desc="Given">
    @Given("^I read content from file \"([^\"]*)\"$")
    public void iReadContentFromFile(String fileName) {
        initialStringList = FileUtils.readFileAsList(fileName);
    }

    @Given("^I write (\\d+) randomly generated List to file \"([^\"]*)\"$")
    public void iWriteRandomlyGeneratedListToFile(int count, String fileName) throws IOException {
        RandomInts randomInts = new RandomInts();
        List<String> randomList = new ArrayList(randomInts.generateRandomList(count));
        writeListToFile(randomList, fileName);
    }

    ////</editor-fold>
    ////<editor-fold desc="When">
    @When("^I replace (\\d+) word and (\\d+) words and use delimiter \"([^\"]*)\"$")
    public void iReplaceWordAndWordsAndUseDelimiter(int index1, int index2, String delimiter) throws IOException {
        SwapWords swapWords = new SwapWords();
        array = ListUtils.convertListToArray(initialStringList, delimiter);
        array = swapWords.getArrayWithSwappedWords(array, index1, index2);
        modifiedList = ArrayUtils.convertArrayToList(array);
    }

    @When("^I read content with integers from file \"([^\"]*)\"$")
    public void iReadContentWithIntegersFromFile(String fileName) {
        initialIntsList = FileUtils.readIntsFromFile(fileName);
    }

    @When("^I sort List ascending$")
    public void iSortListAscending() {
        RandomInts randomInts = new RandomInts();
        modifiedList = randomInts.getSortedList(initialIntsList);
    }

    @When("^I reverse all characters in each line and use delimiter \"([^\"]*)\"$")
    public void iReverseAllCharactersInEachLineAndUseDelimiter(String delimiter) throws IOException {
        JavaFileReversed jfr = new JavaFileReversed();
        array = ListUtils.convertListToArray(initialStringList, delimiter);
        modifiedList = jfr.getTextReversed(array);
    }

    @When("^I capitalize characters in each word longer than \"([^\"]*)\" characters and use delimiter \"([^\"]*)\"$")
    public void iCapitalizeCharactersInEachWordLongerThanCharactersAndUseDelimiter (int num, String delimiter) throws IOException {
        CaseChange caseChange = new CaseChange();
        array = ListUtils.convertListToArray(initialStringList, delimiter);
        modifiedList = ArrayUtils.convertArrayToList(array);
        modifiedList = caseChange.toUpperCase(modifiedList, num);
    }

    ////</editor-fold>
    ////<editor-fold desc="Then">
    @Then("^I print Array to console$")
    public void iPrintArrayToConsole() {
        ArrayUtils.printArray(array);
    }

    @Then("^I write modified List to file \"([^\"]*)\"$")
    public void iWriteModifiedListToFile(String fileName) throws IOException {
        writeListToFile(modifiedList, fileName);
    }

    @Then("^I print List to console and use delimiter \"([^\"]*)\"$")
    public void iPrintListToConsoleAndUsDelimiter(String delimiter) {
        ListUtils.printList(modifiedList, delimiter);
    }

    @Then("^I write modified List with numbers to file \"([^\"]*)\"$")
    public void iWriteModifiedListWithNumbersToFile(String fileName) throws IOException {
        FileUtils.writeListToFile(modifiedList, fileName);
    }
    ////</editor-fold>
}