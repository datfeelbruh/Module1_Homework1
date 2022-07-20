package Homework1;

import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        // Базовый уровень
        // Задача №1
        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';
        String concatenated = hi.trim() + world.toLowerCase() + newLine;
        System.out.println(concatenated.repeat(3));

        // Задача №2
        double height = 1.95;
        double weight = 95;
        double weightIndex = weight / (height * height);
        System.out.println(weightIndex);

        // Задача №3
        char[] letters = {'a', 'b', 'c', 'd', 'e'};
        String stringOfLetters = String.valueOf(letters);
        System.out.println(stringOfLetters);
        letters[3] = 'h';
        String newStringOfLetters = String.valueOf(letters);
        System.out.println(newStringOfLetters);

        // Продвинутый уровень
        // Задача №1
        String text = "234";
        String someText = "some_text";
        int number = Integer.parseInt(text);
        int numberPlusSomeText = number + someText.length();

        //Задача №2
        int a = 3;
        int b = 5;
        int result = (a * a) + (2 * a * b) + (b * b);

        // Задача №3
        int[] numbers1 = {1, 2, 5, 7, 10};
        int[] numbers2 = {2, 3, 2, 17, 15};
        int arraysSize = numbers1.length;
        int[] allNumbers = new int[arraysSize * 3];
        int index = 0;
        for (int i = 0; i < allNumbers.length; i++) {
            if (i < arraysSize) {
                allNumbers[i] = numbers1[index];
            } else if (i < arraysSize * 2) {
                allNumbers[i] = numbers2[index];
            } else {
                allNumbers[i] = numbers1[index] * numbers2[index];
            }
            index++;
            if (index == arraysSize) {
                index = 0;
            }
        }

        //Задача №4
        String someString = "Hello world!";
        System.out.println(someString.replaceAll("l", "r")
                                     .toUpperCase()
                                     .substring(0, 8));

    }
}
