
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Product pr1 = new Product("Hoang", 500, 20);
    static Product pr2 = new Product("Hung", 300, 10);
    static Product pr3 = new Product("Ngoc", 200, 1);
    static Product listPr[] = {pr1, pr2, pr3} ;
    public static void main(String[] args) {
        while (true) {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1. Hiển thị");
            System.out.println("0. Hiển thị kiểu mảng");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Sửa sản phẩm");
            System.out.println("5. sắp xếp sản phẩm theo giá.");
            System.out.println("6. Tìm kiếm sản phẩm theo tên");
            int inp = Integer.parseInt(sc.nextLine());
            if (inp == 1) {
                for (Product p: listPr) {
                    System.out.println(p.display());
                }
            } else if (inp == 0) {
                displayA();
            } else if (inp == 2) {
                addPr();
            } else if (inp == 3){
                deletePr();
            } else if (inp == 4){
                editPr();
            }else if (inp == 5){
                sapxepTangdan();
            }else if (inp == 6){
                search();
            } else {
                System.out.println("Chưa có chức năng khác");
            }
        }
    }
    public static void addPr () {
        System.out.println("Nhập thông tin sản phẩm thêm:");
        System.out.println("Name: "); String addName = new Scanner(System.in).nextLine();
        System.out.println("Price: "); double addPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Quantity: "); int addQuantity = Integer.parseInt(sc.nextLine());
        Product newProduct = new Product(addName, addPrice, addQuantity);
        Product newList[] = new Product[listPr.length + 1];
        newList[newList.length - 1] = newProduct;
        for (int i = 0; i < listPr.length; i++) {
            newList[i] = listPr[i];
        }
        listPr = newList;
    }

    public static void deletePr () {
        System.out.println("Nhập thông tin sản phẩm xóa:");
        String prDelete = new Scanner(System.in).nextLine();
        Product newList[] = new Product[listPr.length - 1];
        int indexD = 0;
        for (int i = 0; i < listPr.length; i++) {
            if (listPr[i].name.equals(prDelete)) {
                indexD = i;
            }
        }
        for (int i = 0; i < newList.length; i++) {
            if (i < indexD) {
                newList[i] = listPr[i];
            } else {
                newList[i] = listPr[i+1];
            }
        }
        listPr = newList;
    }

    public static void editPr () {
        System.out.println("Nhập thông tin sản phẩm sửa:");
        String prEdit = new Scanner(System.in).nextLine();
        int indexE = 0;
        for (int i = 0; i < listPr.length; i++) {
            if (listPr[i].name.equals(prEdit)) {
                indexE = i;
            }
        }
        Product newList[] = new Product[listPr.length];
        System.out.println(indexE);

        System.out.println("Name mới: "); String editName = sc.nextLine();
        System.out.println("Price mới: "); double editPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Quantity: "); int editQuantity = Integer.parseInt(sc.nextLine());
        Product editProduct = new Product(editName, editPrice, editQuantity);
        newList[indexE] = editProduct;
        for (int i = 0; i < newList.length; i++) {
            if (i != indexE) {
                newList[i] = listPr[i];
            }
        }
        listPr = newList;
    }

    public static void displayA () {
        System.out.println(Arrays.toString(listPr));
    }

    public static void sapxepTangdan () {
        for (int j = 0; j < listPr.length; j++) {
            for (int i = 0; i < listPr.length-1; i++) {
                if (listPr[i].price > listPr[i+1].price) {
                    Product temp;
                    temp = listPr[i];
                    listPr[i] = listPr[i+1];
                    listPr[i+1] = temp;
                }
            }
        }
        for (Product p: listPr) {
            System.out.println(p.name + ": " + p.price);
        }
    }

    public static void search () {
        System.out.println("Nhập thông tin sản phẩm cần tìm: ");
        char searchPr = sc.next().charAt(0);
        char listChar[] = new char[listPr.length];
        for (int i = 0; i < listPr.length; i++) {
            listChar[i] = listPr[i].name.charAt(0);
        }
        System.out.println(Arrays.toString(listChar));
        for (int i = 0; i < listPr.length; i++) {
            if (listChar[i] == searchPr) {
                System.out.println("Name: " + listPr[i].name + "\nPrice: " + listPr[i].price + "\nQuantity: " + listPr[i].quantity + "\n");
            }
        }
    }
}