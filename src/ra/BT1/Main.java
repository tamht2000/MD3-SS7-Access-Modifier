package ra.BT1;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.getMyString());

        myClass.setMyString("Hello World");
        System.out.println("giá trị chuỗi khi được thay đổi: " + myClass.getMyString());
    }
}
