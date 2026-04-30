public class Circulo extends Figura2D {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * raio;
    }
}
