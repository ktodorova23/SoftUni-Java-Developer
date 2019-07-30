package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getWidth() {
        return this.width;
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * (this.getWidth() + this.getHeight()));
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(this.getWidth() * this.getHeight());
        return super.getArea();
    }
}
