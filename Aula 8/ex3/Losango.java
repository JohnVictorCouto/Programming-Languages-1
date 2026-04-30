public class Losango extends Figura {
    private double diagonalMaior;
    private double diagonalMenor;

    public Losango(double diagonalMaior, double diagonalMenor) {
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double getArea() {
        return (diagonalMaior * diagonalMenor) / 2;
    }

    @Override
    public double getPerimeter() {
        double lado = Math.sqrt(Math.pow(diagonalMaior / 2, 2) + Math.pow(diagonalMenor / 2, 2));
        return 4 * lado;
    }
    
}
