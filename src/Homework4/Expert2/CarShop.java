package Homework4.Expert2;

public class CarShop {
    private Car car;

    public CarShop(Car car) {
        this.car = car;
    }

    public void greetings() {
        System.out.println("Здравствуй клиент, цена этого авто");
    }
    public void question() {
        if (car.getCarPrice() < 0) {
            System.out.println("Давайте посмотрим другое авто?");
        } else {
            System.out.println("Хочешь купить авто?");
        }
    }
    public void sellCar() {
        greetings();
        if (car.getCarPrice() < 0) {
            System.out.println("Неизвестна мне");
            question();
        } else {
            System.out.println(car.getCarPrice());
            question();
        }
    }
}
