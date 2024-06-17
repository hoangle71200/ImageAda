import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Product {
    String name;
    double price;
    int quantity;
    public Product (String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product () {

    }

    public String display () {
        return "Name: " + name + "\nPrice: " + price + "\nQuantity: " + quantity + "\n";
    }


    public static Product addPr () {
        System.out.println("Nhập thông tin sản phẩm thêm:");
        System.out.println("Name: "); String addName = new Scanner(System.in).nextLine();
        System.out.println("Price: "); double addPrice = new Scanner(System.in).nextDouble();
        System.out.println("Quantity: "); int addQuantity = new Scanner(System.in).nextInt();
        Product newProduct = new Product(addName, addPrice, addQuantity);
        return newProduct;
    }
}
