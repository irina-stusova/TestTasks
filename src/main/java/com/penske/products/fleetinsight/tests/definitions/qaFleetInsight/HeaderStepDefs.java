package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Log;
import com.penske.products.fleetinsight.header.Header;
import cucumber.api.java.en.And;

public class HeaderStepDefs {
    private Header header = new Header();

    ////<editor-fold desc="When">
    ////</editor-fold>
    ////<editor-fold desc="And">
    @And("^I click the Left Panel Menu icon$")
    public void iClickTheLeftPanelMenuIcon() {
        header.clickLeftPanelMenu();
        Log.info("The Left Panel Menu Icon was clicked");
    }


    ////</editor-fold>
    ////<editor-fold desc="Then">
    ////</editor-fold>
}
