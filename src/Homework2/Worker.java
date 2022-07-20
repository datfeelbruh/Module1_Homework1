package Homework2;

public class Worker {
    private final String name;
    private int spoiledProductCount = 0;

    Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSpoiledProductCount() {
        return spoiledProductCount;
    }

    public void takeProduct(Stock stock) {
        stock.getProduct();
        System.out.println(getName() + ": Ура я испортил водку!");
        spoiledProductCount = getSpoiledProductCount() + 1;
    }
}
