package com.penske.core.helpers;

import com.penske.core.framework.Log;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.swing.text.MaskFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringHelper {
    private StringHelper() {
    }

    public static boolean isNotNullNotEmptyNotWhiteSpace(final String string) {
        return string != null && !string.isEmpty() && !string.trim().isEmpty();
    }

    public static Matcher matchString(String regex, String str) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(str);
        m.matches();
        return m;
    }

    public static String getMatchedGroup(String regex, String str, int groupNumber) {
        try {
            return matchString(regex, str).group(groupNumber);
        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    String.format("String '%s' does have group '%s' matched by pattern '%s'.",
                            str,
                            groupNumber,
                            regex));
        }
    }

    public static String removeWhitespaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static Integer parseStringToInteger(String number) {
        return Integer.parseInt(number);
    }

    public static String stripNonDigits(final CharSequence input) {
        final StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c > 47 && c < 58) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static Date stringToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            Log.error(e.getMessage());
        }
        return date;
    }

    public static boolean isDateValid(String str, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(str.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static int getDay(Calendar cal) {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Calendar cal) {
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Calendar cal) {
        return cal.get(Calendar.YEAR);
    }

    public static String getDayName(Date date) {
        return new SimpleDateFormat("EEEE", Locale.US).format(date);
    }

    public static String getMonthName(int monthNumber) {
        String[] months = new DateFormatSymbols().getMonths();
        int n = monthNumber - 1;
        return (n >= 0 && n <= 11) ? months[n] : "wrong number";
    }

    public static String inputStreamToString(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            Log.error(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Log.error(e.getMessage());
                }
            }
        }
        return sb.toString();
    }

    public static List<String> inputStreamToArrayList(InputStream is) {
        BufferedReader br = null;
        List<String> arrayListOut = new ArrayList<>();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                arrayListOut.add(line.trim());
            }

        } catch (IOException e) {
            Log.error(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Log.error(e.getMessage());
                }
            }
        }
        return arrayListOut;

    }

    public static Map<Object, Object> build(Object... data) {
        Map<Object, Object> result = new HashMap<>();

        if (data.length % 2 != 0)
            throw new IllegalArgumentException("Odd number of arguments");

        Object key = null;
        Integer step = -1;

        for (Object value : data) {
            step++;
            switch (step % 2) {
                case 0:
                    if (value == null)
                        throw new IllegalArgumentException("Null key value");
                    key = value;
                    continue;
                case 1:
                    result.put(key, value);
                    break;
            }
        }
        return result;
    }

//    public static long convertTimeToLong(int day, GeneralEnumConstants.DayPeriod dayPeriod) {
//        DateTime dateNow = new DateTime(DateTimeZone.UTC);
//        long millsOfDay = dateNow.getMillisOfDay();
//        switch (dayPeriod) {
//            case START_DAY:
//                return dateNow.plusDays(day).getMillis() - millsOfDay;
//            case END_DAY:
//                return dateNow.plusDays(day + 1).getMillis() - millsOfDay - 1;
//            default:
//                return dateNow.plusDays(day).getMillis();
//        }
//    }

    public static long getStartOfTheDayUTC(long time) {
        DateTime dateTime = new DateTime(time, DateTimeZone.UTC);
        return dateTime.minus(dateTime.getMillisOfDay()).getMillis();
    }

    public static String formatValidPhoneNumber(String phoneNumber, String mask) {
        String sOut = "";
        try {
            MaskFormatter maskFormatter = new MaskFormatter(mask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            maskFormatter.valueToString(phoneNumber);
            sOut = maskFormatter.valueToString(phoneNumber);
        } catch (ParseException e) {
            Log.error(e.getMessage());
        }
        return sOut;
    }

    public static boolean isStringMatched(String pattern, String value) {
        return Pattern.matches(pattern, value);
    }

//    public static long getStartLogTime(long eventDateTime, Long driverId) {
//        Long driverTimeShift = TestDriverHelper.getDriverTimeShiftByDriverId(driverId);
//        long eventTimeLocalForDriver = eventDateTime + driverTimeShift;
//        DateTime dateTime = new DateTime(eventTimeLocalForDriver, DateTimeZone.UTC);
//        long millsOfDay = dateTime.getMillisOfDay();
//        dateTime = dateTime.minus(millsOfDay);
//        return dateTime.getMillis() + driverTimeShift;
//    }

//    public static String formatDateTime(long timeMills) {
//        DateTimeFormatter fmt = DateTimeFormat.forPattern(ApiConfigHelper.DATE_TIME_FORMAT_FOR_DEBUG);
//        return fmt.withLocale(Locale.ENGLISH).print(new DateTime(timeMills, DateTimeZone.UTC));
//    }

    public static Map<String, String> convertListToHashMap(List<List<String>> fieldValueList) {
        Map<String, String> fieldValueMap = new HashMap<>();
        if (isValidFieldValues(fieldValueList)) {
            for (List<String> list : fieldValueList) {
                String key = list.get(0);
                String value = list.get(1);
                if (StringHelper.isNotNullNotEmptyNotWhiteSpace(key) && (!value.equalsIgnoreCase("null")) && (!value.equals(""))) {
                    fieldValueMap.put(key, value);
                }
            }
        }
        return fieldValueMap;
    }

    private static boolean isValidFieldValues(List<List<String>> fieldValueList) {
        if (fieldValueList != null) {
            for (List<String> list : fieldValueList) {
                if (list.size() != 2) {
                    throw new RuntimeException("Incorrect items count in List<String>");
                }
            }
            return true;
        }
        return false;
    }
}
