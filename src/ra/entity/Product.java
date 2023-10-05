package ra.entity;

import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    // Constructor
    public Product() {
    }

    public Product(String productID, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        calculateProfit();
    }

    // Getters and setters
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
        calculateProfit();
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Methods
    public void inputData(Scanner scanner, Product[] arrProduct, int productCount) {
        // Nhập mã sản phẩm
        boolean isValid = true;
        do {
            System.out.print("Nhập mã sản phẩm (Pxxx): ");
            String productId = scanner.nextLine();
            if (productId.matches("^P\\d{3}$")) {
                boolean isDuplicate = true;
                for (int i = 0; i < productCount; i++) {
                    if (!arrProduct[i].getProductID().equalsIgnoreCase(productId)) {
//                        this.productID = productId;
                        isDuplicate = false;
                        break;
                    }
                }

                if (!isDuplicate) {
                    System.out.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại.");
                } else {
                    this.productID = productId;
                    isValid = false;
                }

            } else {
                System.err.println("Mã sản phẩm phải có định dạng Pxxx, vui lòng nhập lại.");
            }
        } while (isValid);


        // nhập tên sản phẩm
        boolean checkName = true;

        do {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
            String productName = scanner.nextLine();
            if (productName.length() < 6 || productName.length() > 50) {
                for (int i = 0; i < productCount; i++) {
                    if (arrProduct[i].getProductName().equalsIgnoreCase(productName)) {
                        System.out.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                    } else {
//                        this.productName = productName;
                        break;
                    }
                }

            } else {
                this.productName = productName;
                checkName = false;
            }


        } while (checkName);


        // Nhập giá nhập của sản phẩm
        boolean isPrice = true;
        do {
            System.out.print("Nhập giá nhập : ");
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice <= 0) {
                System.out.println("Giá không hợp lệ.");
            } else {
                this.importPrice = importPrice;
                isPrice = false;
            }

        } while (isPrice);


        // Nhập giá bán của sản phẩm
        boolean isExportPrice = true;
        do {
            System.out.print("Nhập giá xuất (>= giá nhập + 20%): ");
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice <= this.importPrice * 1.2) {
                System.out.println("Giá bán không hợp lệ.");
            } else {
                this.exportPrice = exportPrice;
                isExportPrice = false;
            }

        } while (isExportPrice);


        // Nhập số lượng sản phẩm
        boolean isQuantity = true;
        do {
            System.out.print("Nhập số lượng sản phẩm (> 0): ");
            int quantity = Integer.parseInt(scanner.nextLine());
            // Validate quantity
            if (quantity <= 0) {
                System.out.println("Số lượng sản phẩm không hợp lệ. Vui lòng nhập lại.");
            } else {
                this.quantity = quantity;
                isQuantity = false;
            }

        } while (isQuantity);


        // Nhập mô tả
        System.out.print("Nhập mô tả sản phẩm: ");
        String descriptions = scanner.nextLine();
        this.descriptions = descriptions;

        // Nhập trạng thái
        System.out.print("Nhập trạng thái sản phẩm (true/false): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());


        calculateProfit();
    }

//    public void displayData() {
//        System.out.println("Mã sản phẩm: " + productID);
//        System.out.println("Tên sản phẩm: " + productName);
//        System.out.println("Giá nhập: " + importPrice);
//        System.out.println("Giá xuất: " + exportPrice);
//        System.out.println("Lợi nhuận: " + profit);
//        System.out.println("Số lượng: " + quantity);
//        System.out.println("Mô tả: " + descriptions);
//        System.out.println("Trạng thái: " + (status ? "Đang bán" : "Không bán"));
//    }

    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá nhập: %.2f - Giá xuất: %.2f \n Lợi nhuận: %.2f - Số lượng: %d - Mô tả: %s - Trạng thái: %s\n",
                productID, productName, importPrice, exportPrice, profit, quantity, descriptions, status ? "Đang bán" : "Không bán");
        System.out.println("----------------------------------------------------------------------------");
    }

    public void calculateProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }
}
