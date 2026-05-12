public class Triangle extends TwoDimensionalShape {
    private double lado1, lado2, lado3;
    public Triangle(int a, int b, int c) { 
        this.lado1 = a; 
        this.lado2 = b; 
        this.lado3 = c; 
    }
    public Triangle(double a, double b, double c) { 
        this.lado1 = a; 
        this.lado2 = b; 
        this.lado3 = c; 
    }

    @Override 
    public double getArea() { 
         // Semiparámetro (s) para a Fórmula de Heron
        double s = getPerimeter() / 2.0;
        // Área = raiz(s * (s-a) * (s-b) * (s-c))
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
    @Override 
    public double getPerimeter() { 
        return lado1 + lado2 + lado3; 
    } 
}