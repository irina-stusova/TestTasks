package com.company.lessons.tests;

import com.company.lessons.lesson13.Enums;
import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Date;
import java.util.List;

public class Lesson13StepDefs {

    private Enums.WeekDays enumValue;
    private String string;
    private Date date;
    private List<String> list;
    private int number;

    ////<editor-fold desc="When">
    @When("^I pass enum value \"([^\"]*)\"$")
    public void iPassEnumValue(Enums.WeekDays enumValue) {
        this.enumValue = enumValue;
    }

    @When("^I pass the table then I print the table to console$")
    public void iPassTheTableThenIPrintTheTableToConsole(DataTable arg) {
        List<List<String>> table = arg.asLists(String.class);

        System.out.print(table.get(0).get(0) + " ");
        System.out.print(table.get(0).get(1) + " ");
        System.out.println(table.get(0).get(2) + " ");

        System.out.print(table.get(1).get(0) + " ");
        System.out.print(table.get(1).get(1) + " ");
        System.out.println(table.get(1).get(2) + " ");

        System.out.print(table.get(2).get(0) + " ");
        System.out.print(table.get(2).get(1) + " ");
        System.out.println(table.get(2).get(2) + " ");

        System.out.print(table.get(3).get(0) + " ");
        System.out.print(table.get(3).get(1) + " ");
        System.out.println(table.get(3).get(2) + " ");

        System.out.print(table.get(4).get(0) + " ");
        System.out.print(table.get(4).get(1) + " ");
        System.out.println(table.get(4).get(2) + " ");

        System.out.print(table.get(5).get(0) + " ");
        System.out.print(table.get(5).get(1) + " ");
        System.out.println(table.get(5).get(2) + " ");

        System.out.print(table.get(6).get(0) + " ");
        System.out.print(table.get(6).get(1) + " ");
        System.out.println(table.get(6).get(2) + " ");

        System.out.print(table.get(7).get(0) + " ");
        System.out.print(table.get(7).get(1) + " ");
        System.out.println(table.get(7).get(2) + " ");
    }

    @When("^I pass multi-line text$")
    public void iPassMultiLineText(String string) {
        this.string = string;
    }

    @When("^I pass the date (.+)$")
    public void iPassTheDate(@Format("dd.MM.yyyy") Date date) {
        this.date = date;
    }

    @When("^I pass the list (.+)$")
    public void iPassTheList(List<String> list) {
        this.list = list;
    }

    @When("^I pass the number (\\d+)$")
    public void iPassTheNumber(int number) {
        this.number = number;
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
        for (String s : list) {
            System.out.println(s + " ");
        }
    }

    @Then("^I print the number to console$")
    public void iPrintTheNumberToConsole() {
        System.out.println(number);
    }
    ////</editor-fold>
}
