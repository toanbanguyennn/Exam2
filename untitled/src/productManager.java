import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class productManager {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> productArrayList = new ArrayList<>();

    public Product createProduct() {

        System.out.println("Mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả : ");
        String describe = scanner.nextLine();
        return new Product(id, name, price, number, describe);
    }

    public void addProduct() {
        Product product = createProduct();
        productArrayList.add(product);

    }
    public static void displayProduct() {
        for (Product c: productArrayList) {
            System.out.println(c);

        }


    }

    public void deleteProduct() {
        System.out.println("Nhập vào id sản phẩm cần xóa: ");
        String a = scanner.nextLine();
        for (Product pr : productArrayList) {
            if (pr.getId().equals(a)) {
                System.out.println("Bạn có chắc chắn muốn xoá sản phẩm");
                System.out.println("Nhập kí tự bất kì để thoát!");
                String k = scanner.nextLine();
                if(k.equals("Y")){
                productArrayList.remove(pr);
                System.out.println("Xóa sản phẩm thành công!");}
                break;

            } else {
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên ");
            }
        }
    }

    public void editProduct() {
        System.out.println("Nhập mã sản phẩm cần sửa :");
        String code = scanner.nextLine();

        for (Product b : productArrayList) {
            if (b.getId().equals(code)) {
                System.out.println("Mã sản phẩm mới: ");
                String id = scanner.nextLine();
                System.out.println("Tên sản phẩm mới : ");
                String name = scanner.nextLine();
                System.out.println("Giá sản phẩm mới: ");
                int price = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số lượng mới: ");
                int number = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập mô tả mới : ");
                String describe = scanner.nextLine();
                b.setId(id);
                b.setName(name);
                b.setPrice(price);
                b.setNumber(number);
                b.setDescribe(describe);

            } else {
                System.out.println("Sản phẩm cần sửa không có :");
            }
        }
    }


    public void writeFileProduct(String File) {
        try {
            File file = new File("FileProduct.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product : productArrayList) {
                bufferedWriter.write(product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getNumber() + "," + product.getDescribe()  +"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public  ArrayList<Product> readFileProductList() {

        try {
            File file = new File("FileProduct.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(strings[0], strings[1], Double.parseDouble(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                productArrayList.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return productArrayList;
    } public ArrayList<Product> sortByIncrementalPrice() {
        Collections.sort(productArrayList);
        return productArrayList;
    }

    public ArrayList<Product> sortByDescendPrice() {
        ArrayList<Product> newProducts = sortByIncrementalPrice();
        Collections.reverse(newProducts);
        return newProducts;
    }

    public Product searchById(String id) {
        for (Product product : productArrayList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product searchMaxPrice() {
        ArrayList<Product> productArrayList = sortByIncrementalPrice();
        return productArrayList.get((productArrayList.size() - 1));
    }

    public boolean checkID(String id) {
        for (Product product : productArrayList) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
