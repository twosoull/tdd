package tddstudy2;


public class Product {

    private String name; // 상품명
    private int price; // 가격
    private double discount; // 할인율 (퍼센트)
    private int min_price; // 최소 가격

    public Product(String name, int price, double discount, int min_price) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.min_price = min_price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getMin_price() {
        return min_price;
    }
}
