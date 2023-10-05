package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] arrProduct = new Product[100];
//        Product product1 =new Product("1", "bánh chưng", 100, 200, 1, "ngon", true);
//        Product product2 =new Product("2", "bánh giò", 100, 160, 2, "ngon", true);
//        Product product3 =new Product("3", "bánh đậu xanh", 123, 220, 2, "ngon", true);
//        Product product4 =new Product("4", "bánh trung thu", 130, 260, 2, "ngon", true);
//        Product product5 =new Product("5", "bánh đa", 70, 180, 2, "ngon", false);
//        arrProduct[0] = product1;
//        arrProduct[1] = product2;
//        arrProduct[2] = product3;
//        arrProduct[3] = product4;
//        arrProduct[4] = product5;
        int productCount = 0;

        while (true) {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng (1-10): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrProduct[productCount] = new Product();
                        arrProduct[productCount].inputData(scanner, arrProduct, productCount);
                        productCount++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < productCount; i++) {
                        arrProduct[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < productCount; i++) {
                        arrProduct[i].calculateProfit();
                        System.out.println(arrProduct[i].getProductName() + " có lợi nhuận là: " + arrProduct[i].getProfit());
                    }
                    System.out.println("Đã tính lợi nhuận cho các sản phẩm.");
                    break;
                case 4:
                    // Sắp xếp sản phẩm theo lợi nhuận giảm dần
                    for (int i = 0; i < productCount - 1; i++) {
                        for (int j = i + 1; j < productCount; j++) {
                            if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                                // Hoán đổi vị trí
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp các sản phẩm theo lợi nhuận giảm dần.");
                    break;
                case 5:
                    // Thống kê sản phẩm theo giá
                    // Nhập khoảng giá
                    System.out.print("Nhập giá bắt đầu (fromPrice): ");
                    double fromPrice = scanner.nextDouble();

                    System.out.print("Nhập giá kết thúc (toPrice): ");
                    double toPrice = scanner.nextDouble();

                    int count = 0; // Đếm số lượng sản phẩm trong khoảng giá

                    // Duyệt qua mảng sản phẩm và đếm số lượng sản phẩm có giá nằm trong khoảng
                    for (int i = 0; i < productCount; i++) {
                        double productPrice = arrProduct[i].getExportPrice();
                        if (productPrice >= fromPrice && productPrice <= toPrice) {
                            count++;
                            // Hiển thị thông tin sản phẩm có giá nằm trong khoảng
                            System.out.println("Mã sản phẩm: " + arrProduct[i].getProductID());
                            System.out.println("Tên sản phẩm: " + arrProduct[i].getProductName());
                            System.out.println("Giá bán: " + productPrice);
                            System.out.println("------------------------");
                        }
                    }

                    if (count == 0) {
                        System.out.println("Không có sản phẩm nào có giá trong khoảng từ " + fromPrice + " đến " + toPrice);
                    } else {
                        System.out.println("Tổng số sản phẩm có giá từ " + fromPrice + " đến " + toPrice + ": " + count);
                    }
                case 6:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < productCount; i++) {
                        if (arrProduct[i].getProductName().equalsIgnoreCase(searchName)) {
                            arrProduct[i].displayData();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + searchName);
                    }
                    break;
                case 7:
                    System.out.print("Nhập mã sản phẩm cần thêm: ");
                    String productIdToPlus = scanner.nextLine();
                    boolean check = false;
                    for (int i = 0; i < productCount; i++) {
                        if(arrProduct[i].getProductID().equalsIgnoreCase(productIdToPlus)){
                            System.out.println("nhập số lượng thêm: ");
                            int soLuong = Integer.parseInt(scanner.nextLine());
                            arrProduct[i].setQuantity(arrProduct[i].getQuantity() + soLuong);
                            check = true;
                        }
                    }
                    if(!check) {
                        System.out.println("không tìm thấy sản phẩm có mã: " + productIdToPlus);
                    }
                    break;
                case 8:
                    // Bán sản phẩm
                    boolean isSell = true;
                    do {
                        System.out.print("Nhập mã sản phẩm cần bán: ");
                        String productIdToSell = scanner.nextLine();
                        boolean founded = false;
                        for (int i = 0; i < productCount; i++) {
                            if (arrProduct[i].getProductID().equalsIgnoreCase(productIdToSell)) {
                                System.out.println("Nhập số lượng muốn bán: ");
                                int soluong = Integer.parseInt(scanner.nextLine());
                                if (soluong <= 0) {
                                    System.out.println("Số lượng không hợp lệ. Vui lòng nhập số lượng hợp lệ.");
                                } else if (arrProduct[i].getQuantity() >= soluong) {
                                    arrProduct[i].setQuantity(arrProduct[i].getQuantity() - soluong);
                                    System.out.println("Đã bán sản phẩm: " + arrProduct[i].getProductName());
                                    founded = true;
                                    if (arrProduct[i].getQuantity() == 0) {
                                        arrProduct[i].setStatus(false);
                                    }
                                } else {
                                    System.out.println("Số lượng sản phẩm còn " + arrProduct[i].getQuantity() + ". Vui lòng nhập lại.");
                                }
                            }
                        }
                        if (!founded) {
                            System.out.println("Không tìm thấy sản phẩm có mã: " + productIdToSell + ". Hãy nhập lại mã.");
                        }
                        System.out.print("Bạn có muốn bán sản phẩm khác? (Nhập 'yes' để tiếp tục): ");
                        String choiced = scanner.nextLine();
                        isSell = choiced.equalsIgnoreCase("yes");
                    } while (isSell);
                    break;

                case 9:
                    System.out.print("Nhập mã sản phẩm cần đổi trạng thái: ");
                    String productIdToSetStatus = scanner.nextLine();
                    boolean solded = false;
                    for (int i = 0; i < productCount; i++) {
                        if(arrProduct[i].getProductID().equalsIgnoreCase(productIdToSetStatus)) {
                            System.out.println("set lại status:");
                            boolean statusSet = Boolean.parseBoolean(scanner.nextLine());
                            arrProduct[i].setStatus(statusSet);
                            solded = true;
                        }
                    }
                    if(!solded){
                        System.out.println("không tìm thấy sản phẩm có id:" + productIdToSetStatus);
                    }
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}
