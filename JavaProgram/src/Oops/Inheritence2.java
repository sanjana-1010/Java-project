package Oops;
class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product {
    String warranty;

    Electronics(int id, String name, double price, String warranty) {
        super(id, name, price);
        this.warranty = warranty;
    }

    void display() {
        System.out.println("\n--- Electronics Details ---");
        displayDetails();
        System.out.println("Warranty: " + warranty);
    }
}

class Clothing extends Product {
    String size;

    Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    void display() {
        System.out.println("\n--- Clothing Details ---");
        displayDetails();
        System.out.println("Dress Size: " + size);
    }
}

class Food extends Product {
    String expiryDate;

    Food(int id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    void display() {
        System.out.println("\n--- Food Details ---");
        displayDetails();
        System.out.println("Expiry Date: " + expiryDate);
    }
}

public class Inheritence2{
    public static void main(String[] args) {

        Electronics e = new Electronics(101, "Laptop", 55000, "2 Years");

        Clothing c = new Clothing(102, "T-Shirt", 799, "L");

        Food f = new Food(103, "Biscuits", 50, "31-12-2026");

        e.display();
        c.display();
        f.display();
    }
}
