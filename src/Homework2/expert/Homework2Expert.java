package Homework2.expert;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Homework2Expert {
    private static final Set<String> SPECIAL_CAR_NUMBERS = new HashSet<>();
    private static final String SPECIAL_NUMBER_PATTERN = "^М\\d{3}АВ\\d{2,3}";

    public static void main(String[] args) {
        Map<Integer, Map<String, String[]>> data = GeneratorExpertHomework.getData();
        for (Map.Entry<Integer, Map<String, String[]>> dataEntry : data.entrySet()) {
            Map<String, String[]> regionInOut = dataEntry.getValue();
            getRegionAutoNumber(regionInOut);
        }
        System.out.println(SPECIAL_CAR_NUMBERS);
        System.out.println(SPECIAL_CAR_NUMBERS.size());
    }

    private static void getRegionAutoNumber(Map<String, String[]> data) {
        for (Map.Entry<String, String[]> inOutEntry : data.entrySet()) {
            String[] carNumbers = inOutEntry.getValue();
            getSpecialCarNumbers(carNumbers);
        }
    }

    private static void getSpecialCarNumbers(String[] data) {
        for (String number : data) {
            Pattern pattern = Pattern.compile(SPECIAL_NUMBER_PATTERN);
            Matcher matcher = pattern.matcher(number);
            while (matcher.find()) {
                String carNumber = matcher.group();
                SPECIAL_CAR_NUMBERS.add(carNumber);
            }
        }
    }
}
