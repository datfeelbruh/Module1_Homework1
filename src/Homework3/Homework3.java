package Homework3;

import java.io.*;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) throws IOException {
        // Базовый уровень
        //Задача №1
        Toyota toyota = new Toyota();
        Zhiguli zhiguli = new Zhiguli();
        toyota.enableMusic();
        zhiguli.breakdown();

        //Задача №2
        String path = "/home/dmitriykhoroshko/Module1_Homework1/my_first_file.txt";
        StringBuilder fileData = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while(br.ready()) {
                fileData.append(br.readLine());
                fileData.append(" ");
            }
        }
        String result = fileData.toString();
        System.out.println(result);

        //Задача №3
        FinancialRecord finRec = new FinancialRecord(500, 300);
        File report = new File("report.txt");
        report.createNewFile();
        try (Writer writer = new FileWriter(report)) {
            writer.write("доходы = " + finRec.getIncome() + ", ");
            writer.write("расходы = " + finRec.getOutcome() + "\n");
            writer.flush();
        }

        // Продвинутый уровень
        //Задача №1
        Car[] carArray = new Car[40];
        for (int i = 0; i < carArray.length; i++) {
            if (i % 2 == 0) {
                carArray[i] = CarFactory.createToyota();
            } else {
                carArray[i] = CarFactory.createZhiguli();
            }
        }
        for (Car car : carArray) {
            if (car instanceof Toyota) {
                ((Toyota) car).enableMusic();
            } else {
                ((Zhiguli) car).breakdown();
            }
        }

        //Задача №2
        Random random = new Random(1);
        FinancialRecord[] finRecords = new FinancialRecord[10];
        for (int i = 0; i < 10; i++) {
            finRecords[i] = new FinancialRecord(random.nextInt(10000), random.nextInt(10000));
        }
        try (Writer writer = new FileWriter(report)) {
            for (FinancialRecord fr : finRecords) {
                int income = fr.getIncome();
                int outcome = fr.getOutcome();
                writer.write("доходы = " + income + ", расходы = " + outcome + "\n");
            }
            writer.flush();
        }
        int allIncome = 0;
        int allOutcome = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(report))) {
            while(br.ready()) {
                String fileLine = br.readLine();
                allIncome += Integer.parseInt(fileLine.substring(fileLine.indexOf("=") + 2, fileLine.indexOf(",")));
                allOutcome += Integer.parseInt(fileLine.substring(fileLine.lastIndexOf("=") + 2));
            }
        }
        System.out.println("общие доходы - " + allIncome + "," + " общие расходы - " + allOutcome);
    }
}
