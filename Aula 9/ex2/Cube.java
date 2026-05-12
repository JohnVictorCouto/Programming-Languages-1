public class Cube extends ThreeDimensionalShape {
    private double lado;

    public Cube(double lado) {
        this.lado = lado;
    }

    @Override
    public double getVolume() {
        return lado * lado * lado;
    }

    @Override
    public double getSurfaceArea() {
        return 6 * lado * lado;
    }
}