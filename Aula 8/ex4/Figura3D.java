public abstract class Figura3D extends Figura {
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