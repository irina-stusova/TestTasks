//package com.company.products.fleetinsight.context;
//
//import com.company.core.framework.Log;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class ContextFI {
//    public ContextFI() {
//    }
//    private static String scenarioName;
//
//    public static String getScenarioName() {
//        return scenarioName;
//    }
//
//    public static void setScenarioName(String scenarioName) {
//        ContextFI.scenarioName = scenarioName;
//    }
//
//    private static Map<String, Object> projectContext;
//
//    public static void initContext() {
//        projectContext = new ConcurrentHashMap<>();
//    }
//
//    public static Object getValue(ContextKeyFI key) {
//        return getValue(key.toString());
//    }
//
//    public static Object getValue(String key) {
//        Object value = projectContext.get(key);
//        Log.info(String.format("Retrieving value for key '%s': %n%s", key, value));
//        return value;
//    }
//
//    public static void setValue(ContextKeyFI key, Object value) {
//        setValue(key.toString(), value);
//    }
//
//    public static void setValue(String key, Object value) {
//        projectContext.put(key, value);
//        Log.info(String.format("Saving value for key '%s': %n%s", key, value));
//    }
//
//    public static void destroyContext() {
//        projectContext = new ConcurrentHashMap<>();
//    }
//
//}
