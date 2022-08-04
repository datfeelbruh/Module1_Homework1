package Homework4.Advanced2;

public class Shop {
    private final Worker[] shopWorkers;

    public Shop(Worker[] workers) {
        this.shopWorkers = workers;
    }

    public Worker[] getShopWorkers() {
        return shopWorkers;
    }
}
