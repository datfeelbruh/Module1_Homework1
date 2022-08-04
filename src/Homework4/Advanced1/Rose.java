package Homework4.Advanced1;

public class Rose extends Plant implements Smelling, Blooming{
    @Override
    public void bloom() {
        System.out.println("Роза : умеет цвести");
    }

    @Override
    public void smell() {
        System.out.println("Роза : умеет пахнуть");
    }
}
