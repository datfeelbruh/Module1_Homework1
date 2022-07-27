package Homework3.Expert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework3Expert {
    private static final String PATH = "/home/dmitriykhoroshko/Module1_Homework1/reports";
    private static final String PYTEROCHKA = "pyterochka";
    private static final String PEREKRESTOK = "perekrestok";
    private static final String YDOMA = "ydoma";
    private static final String OKEY = "okey";

    public static void main(String[] args) throws IOException {
        List<Path> pathsList;
        try (Stream<Path> walk = Files.walk(Path.of(PATH))) {
            pathsList = walk.filter(Files::isRegularFile)
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());
        }
        //Задача №1
        pyterochkaReport(pathsList);

        //Задача №2
        allOutcomeReport(pathsList);
    }

    private static void allOutcomeReport(List<Path> pathList) throws IOException {
        double pyterochkaYearOutcome = 0.0;
        double perekrestokYearOutcome = 0.0;
        double ydomaYearOutcome = 0.0;
        double okeyYearOutcome = 0.0;

        for (Path path : pathList) {
            String filePath = String.valueOf(path);
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    if (line.startsWith(PYTEROCHKA)) {
                        pyterochkaYearOutcome += computeOutcome(line);
                    } else if (line.startsWith(PEREKRESTOK)) {
                        perekrestokYearOutcome += computeOutcome(line);
                    } else if (line.startsWith(YDOMA)) {
                        ydomaYearOutcome += computeOutcome(line);
                    } else if (line.startsWith(OKEY)) {
                        okeyYearOutcome += computeOutcome(line);
                    }
                }
            }
        }
        String allOutcomeResult = "Расходы " + PYTEROCHKA + " за весь период: " +
                String.format("%.2f", pyterochkaYearOutcome) +
                "\n" +
                "Расходы " + PEREKRESTOK + " за весь период: " +
                String.format("%.2f", perekrestokYearOutcome) +
                "\n" +
                "Расходы " + YDOMA + " за весь период: " +
                String.format("%.2f", ydomaYearOutcome) +
                "\n" +
                "Расходы " + OKEY + " за весь период: " +
                String.format("%.2f", okeyYearOutcome) +
                "\n";
        System.out.println(allOutcomeResult);
    }
    private static void pyterochkaReport(List<Path> pathsList) throws IOException {
        String pyterochkaResult;
        StringBuilder pyterochkaBuiler = new StringBuilder();
        pyterochkaBuiler.append("Прибыль по магазину pyterochka по месяцам");
        pyterochkaBuiler.append("\n");
        for (Path path : pathsList) {
            String filePath = String.valueOf(path);
            String month = filePath.substring(filePath.indexOf("report_"), filePath.lastIndexOf("."));
            month = month.replace("report_", "").replace("_", ".");
            double profit = 0.0;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    if (line.startsWith(PYTEROCHKA)) {
                        profit += computeProfit(line);
                    }
                }
            }
            pyterochkaBuiler.append(month);
            pyterochkaBuiler.append(":");
            pyterochkaBuiler.append(" ");
            pyterochkaBuiler.append(String.format("%.2f", profit));
            pyterochkaBuiler.append("\n");
        }
        pyterochkaResult = pyterochkaBuiler.toString();
        System.out.println(pyterochkaResult);
    }
    private static double computeProfit(String line) {
        String[] inOut = line.split(";");
        double income = Double.parseDouble(inOut[1]);
        double outcome = Double.parseDouble(inOut[2]);
        return income - outcome;
    }

    private static double computeOutcome(String line) {
        String[] inOut = line.split(";");
        return Double.parseDouble(inOut[2]);
    }

}