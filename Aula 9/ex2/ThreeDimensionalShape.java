public abstract class ThreeDimensionalShape extends Shape {
    public abstract double getVolume();
    public abstract double getSurfaceArea();

    @Override
    public double getArea() {
        return getSurfaceArea();
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
