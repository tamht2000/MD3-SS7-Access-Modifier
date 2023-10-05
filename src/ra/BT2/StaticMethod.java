package ra.BT2;

public class StaticMethod {
    private static float PI = 3.14f;

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    private double R;

    public double calCircleArea(double R) {
        return PI * R * R;
    }

    public double calRectangleArea(double width, double height) {
        return width * height;
    }

    public double calTriangleArea(double day, double cao) {
        return (day*cao)/2;
    }
}
