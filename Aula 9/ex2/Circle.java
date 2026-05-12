public class Circle extends TwoDimensionalShape {
    private double raio;
    // Sobrecarga de construtores
    public Circle(int raio) { this.raio = (double) raio; }
    public Circle(double raio) { this.raio = raio; }

    @Override 
    public double getArea() { 
        return Math.PI * raio * raio; 
    }
    @Override 
    public double getPerimeter() { 
        return 2 * Math.PI * raio; 
    }
}
