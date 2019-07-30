package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.getRadius());
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(Math.PI * this.getRadius() * this.getRadius());
        return super.getArea();
    }
}
