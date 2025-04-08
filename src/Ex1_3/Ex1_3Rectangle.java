package Ex1_3;
public class Ex1_3Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Ex1_3Rectangle() {
    }
    public Ex1_3Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public double getArea() {
        return length * width;
    }
    public double getPerimeter() {
        return 2 * (length + width);
    }
    @Override
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width + "]";
    }
}

