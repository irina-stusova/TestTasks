package com.penske.core.framework.config;

public class BrowserConfig extends BaseConfig {

    private static final String BROWSER_PROPERTIES_FILE = "src/main/resources/browser.properties";
    private static BrowserConfig ourInstance = init();

    private static BrowserConfig init() {
        BrowserConfig browserConfig = new BrowserConfig();
        browserConfig.initProperties(BROWSER_PROPERTIES_FILE);
        return browserConfig;
    }

    public static BrowserConfig getInstance() {
        return ourInstance;
    }

    private BrowserConfig() {
    }

    //System properties names
    public final String BROWSER_NAME() {
        return getValuePipeline("browserName");
    }

    public final String CHROME_PROFILE_PATH() {
        return getValuePipeline("chromeProfilePath");
    }

    public final String BROWSER_RESOLUTION_WIDTH() {
        return getValuePipeline("resolutionWidth");
    }

    public final String BROWSER_RESOLUTION_HEIGHT() {
        return getValuePipeline("resolutionHeight");
    }

    public final String FIREFOX_DRIVER_WIN_64() {
        return getValuePipeline("firefoxDriver.Win64");
    }

    public final String FIREFOX_LOGFILE() {
        return getValuePipeline("firefox.logfile");
    }

    public final String CHROME_DRIVER_WIN() {
        return getValuePipeline("chromeDriver.Win");
    }

    public final String IE_DRIVER_WIN_32() {
        return getValuePipeline("IEDriverServer.Win32");
    }
}