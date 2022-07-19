import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        productManager productManagers = new productManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("************* Menu *************");
            System.out.println("1 : Xem danh sách sản phẩm : ");
            System.out.println("2 : Thêm sản phẩm :");
            System.out.println("3 : Sửa thông tin sản phẩm : ");
            System.out.println("4 : Xoá sản phẩm : ");
            System.out.println("5 : Sắp xếp sản phẩm : ");
            System.out.println("6 : Sản phẩm có giá trị đắt nhất : ");
            System.out.println("7 : Đọc từ file : ");
            System.out.println("8 : Ghi vào file : ");
            System.out.println("9 : Thoát ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    productManagers.displayProduct();
                    break;
                case 2:
                    productManagers.addProduct();
                    break;
                case 3:
                    productManagers.editProduct();
                    break;
                case 4:
                    productManagers.deleteProduct();
                    break;
                case 5:
                    System.out.println("1. Sắp xếp  tăng dần :");
                    System.out.println("2. Sắp xếp  giảm dần :");
                    System.out.println("3. Thoát.");
                    int choiceSort = Integer.parseInt(scanner.nextLine());
                    switch (choiceSort) {
                        case 1:
                            productManagers.sortByIncrementalPrice();
                            break;
                        case 2:
                            productManagers.sortByDescendPrice();
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 6:
                    productManagers.searchMaxPrice();
                    break;
                case 7:
                    productManagers.readFileProductList();
                    break;
                case 8:
                    productManagers.writeFileProduct("FileProduct.csv");
                    break;
                case 9:
                    System.exit(9);
                    break;
            }

        }while (choice != 0) ;
    }
}