public class Quadrado extends Quadrilatero {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return lado * lado;
    }

    @Override
    public double getPerimeter() {
        return 4 * lado;
    }
    
}
