import java.io.Serializable;

public class Product implements Comparable<Product> {
    public  String id;
    public String name;
    public double price;
    public int number;
    public String describe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Product(String id, String name, double price, int number, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", describe='" + describe + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return (int) (this.price - product.getPrice());
    }
}
