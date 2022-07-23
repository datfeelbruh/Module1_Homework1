package Homework2;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        // Базовый уровень
        // Задача №1
        printNumbersWithA();

        // Задача №2
        int ageChildren = 18;
        childrenGoesTo(ageChildren);

        // Задача №3
        boolean chicken = false;
        boolean vegetables = true;
        boolean sour = true;
        boolean toast = true;
        boolean sausage = true;
        boolean eggs = true;
        cook(chicken, vegetables, sour, toast, sausage, eggs);

        // Задача №4
        Cat cat = new Cat("Sibirskyay");
        cat.setName("Murka");
        Dog dog = new Dog("Bulldog");
        dog.setName("Rex");
        System.out.println("Создал кошку породы: " + cat.getSpecies() + ", с именем: " + cat.getName());
        System.out.println("Создал собаку породы: " + dog.getSpecies() + ", с именем: " + dog.getName());

        // Продвинутый уровень
        // Задача №1
        double increment = 0.9;
        double result = 0;
        sumCountUntilMillion(increment, result);

        // Задача №2
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(replaceEvenIndex(array)));

        // Задача №3
        boolean hasFuel = true;
        boolean hasElectricsProblem = true;
        boolean hasMotorProblem = true;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = true;
        checkDefect(hasFuel, hasElectricsProblem, hasMotorProblem, hasTransmissionProblem, hasWheelsProblem);

        // Задача №4
        Stock ourStock = new Stock(100);
        Worker worker1 = new Worker("Dima");
        Worker worker2 = new Worker("Alex");
        Worker worker3 = new Worker("Slava");
        System.out.println(ourStock.getProductCount());
        worker1.takeProduct(ourStock);
        worker1.takeProduct(ourStock);
        worker1.takeProduct(ourStock);
        worker2.takeProduct(ourStock);
        worker2.takeProduct(ourStock);
        System.out.println(ourStock.getProductCount());
        System.out.println(worker1.getSpoiledProductCount());
        System.out.println(worker2.getSpoiledProductCount());
        System.out.println(worker3.getSpoiledProductCount());
    }
    // Базовый уровень
    // Задача №1
    public static void printNumbersWithA() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + "a ");
        }
    }

    // Задача №2
    public static void childrenGoesTo(int age) {
        if (age < 6) {
            System.out.println("Пошел в сад");
        } else if (age < 11) {
            System.out.println("Пошел в младшую школу");
        } else if (age < 17) {
            System.out.println("Пошел в среднюю школу");
        } else {
            System.out.println("Пошел в университет");
        }
    }

    // Задача №3
    public static void cook(boolean chicken, boolean vegetables, boolean sour, boolean toast, boolean sausage,
                            boolean eggs) {
        if (chicken && vegetables && sour && toast) {
            System.out.println("Цезарь готов");
        } else if (vegetables && (sausage || chicken) && eggs) {
            System.out.println("Оливье готов");
        } else if (vegetables) {
            System.out.println("Овощной салат готов");
        } else {
            System.out.println("У меня ничего нет для приготовления салата");
        }
    }

    // Продвинутый уровень
    // Задача №1
    public static void sumCountUntilMillion(double increment, double result) {
        if (result < 0) {
            return;
        }
        int count = 0;
        while (result < 1_000_000) {
            result += increment;
            count++;
        }
        System.out.println("Количество операций: " + count);
    }
    //Задача №2
    public static int[] replaceEvenIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = 0;
            }
        }
        return array;
    }
    // Задача №3
    public static void checkDefect(boolean hasFuel, boolean hasElectricsProblem, boolean hasMotorProblem,
                              boolean hasTransmissionProblem, boolean hasWheelsProblem) {
        int price = 0;
        int repairCount = 0;
        double firstSale;
        double secondSale;
        if (!hasFuel && (!hasElectricsProblem && !hasMotorProblem && !hasTransmissionProblem && !hasWheelsProblem)) {
            price += 1000;
        }
        if (hasMotorProblem) {
            price += 10000;
            repairCount++;
        }
        if (hasElectricsProblem) {
            price += 5000;
            repairCount++;
        }
        if (hasTransmissionProblem) {
            price += 4000;
            repairCount++;
        }
        if (hasWheelsProblem) {
            price += 2000;
            repairCount++;
        }
        firstSale = repairCount >= 2 ? 0.1 : 0;
        secondSale = hasTransmissionProblem && (hasElectricsProblem || hasMotorProblem) ? 0.2 : 0;
        System.out.println(price - (price * (firstSale + secondSale)));
    }
}
