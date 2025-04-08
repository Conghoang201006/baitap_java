package Ex1_2;

public class Ex1_2Circle {
    private double radius = 1.0;

    public Ex1_2Circle() {
    }
    public Ex1_2Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
    public static void main(String[] args) {
        Ex1_2Circle circle1 = new Ex1_2Circle();
        System.out.println(circle1);

        Ex1_2Circle circle2 = new Ex1_2Circle(5.0);
        System.out.println(circle2);

        circle2.setRadius(7.5);
        System.out.println("Updated: " + circle2);

        System.out.println("Area: " + circle2.getArea());
        System.out.println("Circumference: " + circle2.getCircumference());
    }
}

