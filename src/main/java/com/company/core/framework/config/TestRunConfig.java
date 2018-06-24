//package com.company.core.framework.config;
//
//public class TestRunConfig extends BaseConfig {
//    private static final String RUN_PROPERTIES_FILE = "src/test/resources/run.properties";
//    private static TestRunConfig instance = init();
//
//    private static TestRunConfig init() {
//        TestRunConfig runConfig = new TestRunConfig();
//        runConfig.initProperties(RUN_PROPERTIES_FILE);
//        return runConfig;
//    }
//
//    public static TestRunConfig getInstance() {
//        return instance;
//    }
//
//    //System properties names
//    public final boolean SKIP_DEFECTS() {
//        return Boolean.valueOf(getValuePipeline("skip.defects"));
//    }
//
//    public final boolean HOOKS_CLOSE_BROWSER() {
//        return Boolean.valueOf(getValuePipeline("hooks.close.browser"));
//    }
//
//    public final boolean KILL_BROWSER_PROCESS() {
//        return Boolean.valueOf(getValuePipeline("browser.kill.process"));
//    }
//}
