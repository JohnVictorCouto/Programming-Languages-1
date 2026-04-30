public class Retangulo extends Quadrilatero {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return largura * altura;
    }

    @Override
    public double getPerimeter() {
        return 2 * (largura + altura);
    }
    
}
