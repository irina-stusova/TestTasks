//package com.company.core.framework;
//
//import com.company.core.helpers.FileHelper;
//import com.company.products.fleetinsight.context.ContextFI;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.log4j.*;
//import java.io.File;
//import java.util.logging.Logger;
//
//public class Log {
//    private static org.apache.log4j.Logger log;
//    private static String scenarioName = "";
//    private static final String FILE_APPENDER_NAME = "file";
//    private static final String BASE_LOG_PATH;
//    private static final String BASE_LOG_NAME;
//    private static final String LOG_EXTENSION;
//    public static String logFileName;
//
//    static {
//        Appender appender = org.apache.log4j.Logger.getRootLogger().getAppender(FILE_APPENDER_NAME);
//        if (appender instanceof FileAppender) {
//            FileAppender fileAppender = ((FileAppender) appender);
//            String oldFileName = fileAppender.getFile();
//            BASE_LOG_PATH = FilenameUtils.getPath(oldFileName);
//            BASE_LOG_NAME = FilenameUtils.getBaseName(oldFileName);
//            LOG_EXTENSION = FilenameUtils.getExtension(oldFileName);
//        } else {
//            BASE_LOG_PATH = "";
//            BASE_LOG_NAME = "";
//            LOG_EXTENSION = "";
//        }
//    }
//
//    public static void info(Object message) {
//        String name = getCallerClassName();
//        org.apache.log4j.Logger log = getLog(name);
//        log.info(message);
//    }
//
//    public static void error(Object message) {
//        String name = getCallerClassName();
//        org.apache.log4j.Logger log = getLog(name);
//        log.error(message);
//    }
//
//    public static void warn(Object message) {
//        String name = getCallerClassName();
//        org.apache.log4j.Logger log = getLog(name);
//        log.warn(message);
//    }
//
//    public static void debug(String message) {
//        String name = getCallerClassName();
//        org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(name);
//        log.debug(message);
//    }
//
//    private static String getCallerClassName() {
//        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
//        String className = stElements[3].getClassName();
//        try {
//            return Class.forName(className).getName();
//        } catch (ClassNotFoundException e) {
//            Log.error(e.getMessage());
//            return null;
//        }
//    }
//
//    private static void intializeLogger() {
//        changeFileNameInFileAppenderOfRootLogger(scenarioName);
//    }
//
//    private static void changeFileNameInFileAppenderOfRootLogger(String scenarioName) {
//        Appender appender = org.apache.log4j.Logger.getRootLogger().getAppender(FILE_APPENDER_NAME);
//        if (appender instanceof FileAppender) {
//            FileAppender fileAppender = ((FileAppender) appender);
//            String fileName = new File(FilenameUtils.concat(BASE_LOG_PATH, scenarioName + "." + LOG_EXTENSION)).getAbsolutePath();
//            logFileName = fileName;
//            fileAppender.setFile(fileName);
//            fileAppender.activateOptions();
//        } else {
//            System.out.println(String.format("Appender %s does not extend %s class", appender.getName(), FileAppender.class));
//        }
//    }
//
//    private static String getLogFileName() {
//        String logFileName = BASE_LOG_NAME;
//        try {
//            String scenarioName = ContextFI.getScenarioName();
//            logFileName = scenarioName == null ? logFileName : scenarioName;
//        } catch (NullPointerException e) {
//            System.out.println(String.format("At this stage scenario name does not defined. '%s.log' will be used.", logFileName));
//        }
//        return FileHelper.normalizeFileName(logFileName);
//    }
//
//    private static org.apache.log4j.Logger getLog(String name) {
//        String scenarioNameNew = getLogFileName();
//        if (!scenarioName.equals(scenarioNameNew)) {
//            scenarioName = scenarioNameNew;
//            intializeLogger();
//        }
//        return org.apache.log4j.Logger.getLogger(name);
//    }
//}