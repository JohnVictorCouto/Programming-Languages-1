public class Sphere extends ThreeDimensionalShape {
    private double raio;

    public Sphere(double raio) {
        this.raio = raio;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * raio * raio * raio;
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * raio * raio;
    }
}