package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Log;
import com.penske.products.fleetinsight.header.LeftPanel;
import cucumber.api.java.en.And;

public class LeftPanelStepDefs {
    private LeftPanel leftPanel = new LeftPanel();

    ////<editor-fold desc="When">
    ////</editor-fold>
    ////<editor-fold desc="And">
    @And("^I click the \"([^\"]*)\" link in the Left Panel footer$")
    public void iClickTheLinkInTheLeftPanelFooter(String linkName) {
        leftPanel.clickFooterLink(linkName);
        Log.info(String.format("The '%s' link was clicked", linkName));
    }
    ////</editor-fold>
    ////<editor-fold desc="Then">
    ////</editor-fold>
}
