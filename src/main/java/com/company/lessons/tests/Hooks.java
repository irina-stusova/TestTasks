package com.company.lessons.tests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.logging.Log;

public class Hooks {
//    @Before(order = 10)
//    public void printScenarioName(Scenario scenario) {
//        ContextFI.initContext();
//        ContextFI.setScenarioName(scenario.getName());
//        new BaseHooks().printScenarioName(scenario);
//    }
//
//    @Before(order = 15)
//    public void printServersCheck() {
//        if (ReportPortalConfig.getInstance().RP_ENABLED()) {
//            Log.info("================Servers check================");
//            Log.info(String.format("The server 'rp.epam.com' is accessible: %s", ApiConfigHelper.isServerAccessible("rp.epam.com")));
//            Log.info("=============================================");
//        }
//    }

    @Before(order = 20)
    public void skipScenario(Scenario scenario) {
        new BaseHooks().skipScenario(scenario);
    }

    @After(order = 20)
    public void embedScreenshot(Scenario scenario) {
        new BaseHooks().embedScreenshot(scenario);
    }

    @After(order = 15)
    public void closeDbConnections() {
        new BaseHooks().closeDbConnections();
    }

    @After(order = 10)
    public void afterScenario() {
        new BaseHooks().afterScenario();
    }

    @After(order = 5)
    public void verdict(Scenario scenario) {
        new BaseHooks().printScenario(scenario);
    }

    @After(order = 2)
    public void destroyContext() {
        new ContextFI().destroyContext();
    }
}
