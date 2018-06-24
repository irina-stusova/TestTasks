//package com.company.core.framework;
//
//import com.company.core.helpers.StringHelper;
//import com.company.lessons.browser.Browser;
//import com.company.core.framework.config.TestRunConfig;
//import cucumber.api.Scenario;
//import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class BaseHooks {
//    private static boolean skipDefects = TestRunConfig.getInstance().SKIP_DEFECTS();
//    private static boolean closeBrowser = TestRunConfig.getInstance().HOOKS_CLOSE_BROWSER();
//
//    public void printScenarioName(Scenario scenario) {
//        int length = ("===SCENARIO: " + scenario.getName() + "===").length();
//        Log.info(StringUtils.repeat("=", length));
//        Log.info(String.format("===SCENARIO: %s===", scenario.getName()));
//        Log.info(StringUtils.repeat("=", length));
//    }
//
//    public void printVerdict(Scenario scenario) {
//        String verdict = scenario.getStatus().toUpperCase();
//        String line = String.format("===SCENARIO %s: " + scenario.getName() + "===", verdict);
//        int length = line.length();
//        Log.info(StringUtils.repeat("=", length));
//        Log.info(line);
//        Log.info(StringUtils.repeat("=", length) + "\n");
//    }
//
//    public void skipScenario(Scenario scenario) {
//        if (skipDefects) {
//            for (String tag : scenario.getSourceTagNames()) {
//                if (tag.equalsIgnoreCase("@defect(s)")) {
//                    List<String> defectIds = scenario.getSourceTagNames()
//                            .stream()
//                            .filter(s -> StringHelper.isStringMatched("@FI-\\d+", s))
//                            .map(s -> s.split("@")[1])
//                            .collect(Collectors.toList());
//                    Log.warn(String.format("SKIPPED: The scenario is skipped due to opened defect(s): %s.\n" +
//                            "Please check the defect(s) and remove the tag '@Defect(s)' and the tags '%s' to run the scenario.", defectIds, defectIds));
//                    throw new cucumber.api.PendingException(String.format("Scenario is skipped due to opened defect(s): %s", defectIds));
//                }
//            }
//        }
//    }
//
//    public void afterScenario() {
//        if (closeBrowser) {
//            Browser.close();
//        }
//    }
//
//    public void embedScreenshot(Scenario scenario) {
//        if (!isScenarioForApi(scenario) && scenario.isFailed()) {
//            final byte[] screenShot = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenShot, "image/png");
//        }
//    }
//
////    public void closeDbConnections(){
////        DbPool.getInstance().closeAllConnections();
////    }
//
//    private boolean isScenarioForApi(Scenario scenario) {
//        List<String> tagNames = new ArrayList<>(scenario.getSourceTagNames());
//        for (String tag : tagNames) {
//            if (tag.equalsIgnoreCase("@api")) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
