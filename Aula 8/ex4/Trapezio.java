public class Trapezio extends Quadrilatero {
    private double baseMaior;
    private double baseMenor;
    private double altura;

    public Trapezio(double baseMaior, double baseMenor, double altura) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return ((baseMaior + baseMenor) / 2) * altura;
    }

    @Override
    public double getPerimeter() {
        double lado1 = Math.sqrt(Math.pow((baseMaior - baseMenor) / 2, 2) + Math.pow(altura, 2));
        double lado2 = lado1; // Os lados inclinados são iguais
        return baseMaior + baseMenor + lado1 + lado2;
    }
    
}
