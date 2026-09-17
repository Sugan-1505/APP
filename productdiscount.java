import java.util.Scanner;
abstract class Product {
    int productId;
    String name;
    double price;
    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    abstract double calculateDiscount();
    void display() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;
        System.out.println("\nProduct ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
    }
}
class Electronics extends Product {
    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    double calculateDiscount() {
        return price * 0.10;
    }
}
class Clothing extends Product {
    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    double calculateDiscount() {
        return price * 0.20;
    }
}
class Books extends Product {
    Books(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    double calculateDiscount() {
        return price * 0.15;
    }
}
public class ProductDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.print("Enter Product Type: ");
        int choice = sc.nextInt();
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        Product product;
        switch (choice) {
            case 1:
                product = new Electronics(id, name, price);
                break;
            case 2:
                product = new Clothing(id, name, price);
                break;
            case 3:
                product = new Books(id, name, price);
                break;
            default:
                System.out.println("Invalid product type.");
                sc.close();
                return;
        }
        product.display();
        sc.close();
    }
}
