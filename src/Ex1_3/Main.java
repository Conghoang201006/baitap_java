package Ex1_3;

public class Main {
public static void main(String[] args) {
    Ex1_3Rectangle rect1 = new Ex1_3Rectangle();
    System.out.println(rect1);

    Ex1_3Rectangle rect2 = new Ex1_3Rectangle(5.0f, 3.5f);
    System.out.println(rect2);

    rect2.setLength(6.0f);
    rect2.setWidth(4.0f);
    System.out.println("Updated: " + rect2);

    System.out.println("Area: " + rect2.getArea());
    System.out.println("Perimeter: " + rect2.getPerimeter());
}
}
