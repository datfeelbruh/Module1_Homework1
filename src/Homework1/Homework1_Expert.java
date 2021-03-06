package Homework1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Экспертный уровень
//Задача №1
public class Homework1_Expert {
    private final static String CLIENT_DATA1 = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
    private final static String CLIENT_DATA2 = "<client>(Какие то данные)<data></data></client>";
    private final static String CLIENT_DATA3 = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
    private final static String ALL_DATA_PATTERN = "(<data>(.*)</data>)";
    private final static String PHONE_PATTERN = "\\d*";
    private final static String EMAIL_PATTERN = "[a-z]+@[a-z]+.[a-z]+";
    private final static String NAMES_PATTERN = "([А-Я][а-я]* ?[А-Я][а-я]* ?[А-Я][а-я]*)";
    private final static String DELIMITER = ";";
    private final static String LAST_DELIMITER = ";$";
    private static String matchedData = "";

    public static void main(String[] args) {
        String result1 = hidePersonalData(CLIENT_DATA1);
        String result2 = hidePersonalData(CLIENT_DATA2);
        String result3 = hidePersonalData(CLIENT_DATA3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static String hidePersonalData(String clientData) {
        Pattern pattern = Pattern.compile(ALL_DATA_PATTERN);
        Matcher matcher = pattern.matcher(clientData);
        StringBuilder hidden = new StringBuilder();

        while (matcher.find()) {
            matchedData = matcher.group(2);
        }
        if (matchedData.length() <= 1) {
            return clientData;
        } else {
            for (String data: matchedData.split(DELIMITER)) {
                if (isPhoneNumber(data)) {
                    hidePhoneNumber(data, hidden);
                } else if (isEmail(data)) {
                    hideEmail(data, hidden);
                } else if (isNames(data)){
                    hideNames(data, hidden);
                }
            }
        }
        String hiddenData = hidden.toString().replaceAll(LAST_DELIMITER, "");
        return clientData.replaceAll(matchedData, hiddenData);
    }

    private static void hidePhoneNumber(String data, StringBuilder hiddenData) {
        hiddenData.append(data, 0, 4);
        hiddenData.append("*".repeat(3));
        hiddenData.append( data.substring(7));
        hiddenData.append(DELIMITER);
    }

    private static boolean isPhoneNumber(String data) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    private static void hideEmail(String data, StringBuilder hiddenData) {
        int indexOfMailChar = data.indexOf("@");
        int indexOfDot = data.indexOf(".");
        hiddenData.append(data, 0, indexOfMailChar - 1);
        hiddenData.append("*");
        hiddenData.append("@");
        hiddenData.append("*".repeat(data.substring(indexOfMailChar, indexOfDot - 1).length()));
        hiddenData.append(data.substring(indexOfDot));
        hiddenData.append(DELIMITER);
    }

    private static boolean isEmail(String data) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    private static void hideNames(String data, StringBuilder hiddenData) {
        hiddenData.append(data.charAt(0));
        hiddenData.append("*".repeat(data.indexOf(" ") - 2));
        hiddenData.append(data.charAt(data.indexOf(" ") - 1));
        hiddenData.append(data, data.indexOf(" "), data.lastIndexOf(" ") + 1);
        hiddenData.append(data.charAt(data.lastIndexOf(" ") + 1));
        hiddenData.append(".");
        hiddenData.append(DELIMITER);
    }

    private static boolean isNames(String data) {
        Pattern pattern = Pattern.compile(NAMES_PATTERN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}

