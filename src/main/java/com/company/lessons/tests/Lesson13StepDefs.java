package com.company.lessons.tests;

import com.company.lessons.lesson13.Enums;
import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import java.util.Date;
import java.util.List;

public class Lesson13StepDefs {

    private Enums.WeekDays enumValue;
    private String string;
    private Date date;
    private List<String> list1;
    private List<String> list2;
    private int number;

    ////<editor-fold desc="When">
    @When("^I pass enum value \"([^\"]*)\"$")
    public void iPassEnumValue(Enums.WeekDays enumValue) {
        this.enumValue = enumValue;
    }

    @When("^I pass the table then I print the table to console$")
    public void iPassTheTableThenIPrintTheTableToConsole(DataTable arg) {
        List<DataTableRow> rows = arg.getGherkinRows();
        for (DataTableRow row : rows) {
            List<String> cells = row.getCells();
            for (String cell : cells) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

//        List<List<String>> table = arg.asLists(String.class);
//        System.out.print(table.get(0).get(0) + " ");
//        System.out.print(table.get(0).get(1) + " ");
//        System.out.println(table.get(0).get(2) + " ");
//
//        System.out.print(table.get(1).get(0) + " ");
//        System.out.print(table.get(1).get(1) + " ");
//        System.out.println(table.get(1).get(2) + " ");
//        and so on  ...
    }

    @When("^I pass multi-line text$")
    public void iPassMultiLineText(String string) {
        this.string = string;
    }

    @When("^I pass the date (.+)$")
    public void iPassTheDate(@Format("dd-MM-yyyy") Date date) {
        this.date = date;
    }

    @When("^I pass the list (.+) and another list (.+)$")
    public void iPassTheList(List<String> list1, List<String> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @When("^I pass the number (\\d+)$")
    public void iPassTheNumber(int number) {
        this.number = number;
    }

    @When("^I pass the boolean \"?(true|false|null)\"?$")
    public void iPassTheBooleanTrue(String flag) {
        System.out.println(flag);
    }

    @When("^I pass (.+) as a list$")
    public void iPassTheList(List<String> list) {
        list1 = list;
    }
    ////</editor-fold>

    ////<editor-fold desc="Then">
    @Then("^I print the enum to console$")
    public void iPrintTheEnumToConsole() {
        Enums.printEnum(enumValue);
    }

    @Then("^I print the text to console$")
    public void iPrintTheTextToConsole() {
        System.out.println(string);
    }

    @Then("^I print the date to console$")
    public void iPrintTheDateToConsole() {
        System.out.println(date.toString());
    }

    @Then("^I print the list to console$")
    public void iPrintTheListToConsole() {
        for (String s : list1) {
            System.out.println(s + " ");
        }
    }

    @Then("^I print the number to console$")
    public void iPrintTheNumberToConsole() {
        System.out.println(number);
    }

    @Then("^I print two lists to console$")
    public void iPrintTwoListsToConsole() {
        System.out.println("List 1:");
        for (String s : list1) {
            System.out.println(s + " ");
        }

        System.out.println("List 2:");
        for (String s : list2) {
            System.out.println(s + " ");
        }
    }
    ////</editor-fold>
}
