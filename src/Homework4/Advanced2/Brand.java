package Homework4.Advanced2;

public class Brand {
    private final Shop[] brandShops;

    public Brand(Shop[] shops) {
        this.brandShops = shops;
    }

    public Shop[] getBrandShops() {
        return brandShops;
    }
}
