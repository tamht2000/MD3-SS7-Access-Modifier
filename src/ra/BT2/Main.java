package ra.BT2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();

        System.out.println("Diện tích hình tròn có bán kính: " + 3.5 + " là: " + staticMethod.calCircleArea(3.5));
        System.out.println("Diện tích hình tròn có bán kính: " + 6 + " là: " + staticMethod.calCircleArea(6));


        System.out.println("Diện tích tam giác có cạnh đáy 5 và chiều cao 6 là: " + staticMethod.calTriangleArea(5,6));

        System.out.println("Diện tích hcn có 2 cạnh 2.5 và 6 là: " + staticMethod.calRectangleArea(2.5, 6));
        System.out.println("Diện tích hcn có 2 cạnh 4 và 7 là: " + staticMethod.calRectangleArea(4, 7));
    }
}
