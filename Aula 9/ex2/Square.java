public class Square extends TwoDimensionalShape {
    private double lado;
    public Square(int a) { 
        this.lado = a; 
    }
    public Square(double a) { 
        this.lado = a; 
    }

    @Override 
    public double getArea() { 
        return Math.pow(lado, 2);
    }
    @Override 
    public double getPerimeter() { 
        return 4 * lado; 
    } 
}