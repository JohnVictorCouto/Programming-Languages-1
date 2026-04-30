import javax.swing.JOptionPane;
public class TesteClasses { //classe principal
    public static void main(String[] args) { 
        double raio = 2.00; //raio do círculo
        Circulo circulo = new Circulo(raio); //instancia do círculo
        JOptionPane.showMessageDialog(null, "Área do círculo: " + circulo.getArea() + "\nPerímetro do círculo: " + circulo.getPerimeter()); //exibe a área e o perímetro do círculo

        double largura = 3.00; //largura do retângulo
        double altura = 4.00; //altura do retângulo
        Retangulo retangulo = new Retangulo(largura, altura); //instancia do retângulo
        JOptionPane.showMessageDialog(null, "Área do retângulo: " + retangulo.getArea() + "\nPerímetro do retângulo: " + retangulo.getPerimeter()); //exibe a área e o perímetro do retângulo

        double diagonalMaior = 5.00; //diagonal maior do losango
        double diagonalMenor = 3.00; //diagonal menor do losango
        Losango losango = new Losango(diagonalMaior, diagonalMenor); //instancia do losango
        JOptionPane.showMessageDialog(null, "Área do losango: " + losango.getArea() + "\nPerímetro do losango: " + losango.getPerimeter()); //exibe a área e o perímetro do losango  

        double baseMaior = 6.00; //base maior do trapézio
        double baseMenor = 4.00; //base menor do trapézio
        double alturaTrapezio = 3.00; //altura do trapézio
        Trapezio trapezio = new Trapezio(baseMaior, baseMenor, alturaTrapezio); //instancia do trapézio
        JOptionPane.showMessageDialog(null, "Área do trapézio: " + trapezio.getArea() + "\nPerímetro do trapézio: " + trapezio.getPerimeter()); //exibe a área e o perímetro do trapézio

        double lado = 4.00; //lado do quadrado
        Quadrado quadrado = new Quadrado(lado); //instancia do quadrado
        JOptionPane.showMessageDialog(null, "Área do quadrado: " + quadrado.getArea() + "\nPerímetro do quadrado: " + quadrado.getPerimeter()); //exibe a área e o perímetro do quadrado
    }
}
