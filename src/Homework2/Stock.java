package Homework2;

public class Stock {
    private static final String productName = "водка";
    private int productCount;

    Stock(int productCount) {
        this.productCount = productCount;
    }

    public String getProductName() {
        return productName;
    }
    public void getProduct() {
        productCount = getProductCount() - 1;
    }

    public int getProductCount() {
        return productCount;
    }
}
