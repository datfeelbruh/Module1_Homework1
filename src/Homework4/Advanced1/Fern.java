package Homework4.Advanced1;

public class Fern extends Plant implements Blooming{
    @Override
    public void bloom() {
        System.out.println("Папоротник : умеет цвести");
    }
}
