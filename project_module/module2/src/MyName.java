import java.util.Scanner;

public class MyName {
    public static Scanner sc = new Scanner(System.in);
    public String firstName;
    public String lastName;
    public int age;

    public MyName(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String display () {
        return "Họ tên: " + firstName + " " + lastName + " Age: " + age;
    }

    public static MyName newPr (String firstName, String lastName, int age) {
        MyName newProduct = new MyName(firstName, lastName, age);
        return newProduct;
    }

    public static void main(String[] args) {
        MyName name1 = new MyName("Lê", "Hoàng", 23);
        System.out.println(name1.display());
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
//        MyName.newPr(firstName, lastName, age);
        System.out.println(MyName.newPr(firstName, lastName, age).firstName);
    }
}
