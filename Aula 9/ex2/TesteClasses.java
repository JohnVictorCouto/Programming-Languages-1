import javax.swing.JOptionPane;

public class TesteClasses {
    public static void main(String[] args) {
        // --- Exemplo 1: Quadrado (Entrada Inteira) ---
        int ladoSq = Integer.parseInt(JOptionPane.showInputDialog("Digite o lado do Quadrado (Inteiro):"));
        Square sq = new Square(ladoSq);
        exibir2D("Quadrado", sq.getArea(), sq.getPerimeter());

        // --- Exemplo 2: Círculo (Entrada Ponto Flutuante) ---
        double raioCi = Double.parseDouble(JOptionPane.showInputDialog("Digite o raio do Círculo (Decimal):"));
        Circle ci = new Circle(raioCi);
        exibir2D("Círculo", ci.getArea(), ci.getPerimeter());

        // --- Exemplo 3: Cubo (Entrada Ponto Flutuante) ---
        double ladoCu = Double.parseDouble(JOptionPane.showInputDialog("Digite o lado do Cubo (Decimal):"));
        Cube cu = new Cube(ladoCu);
        exibir3D("Cubo", cu.getVolume(), cu.getSurfaceArea());

        // --- Exemplo 4: Tetraedro (Entrada Inteira) ---
        int arestaTe = Integer.parseInt(JOptionPane.showInputDialog("Digite a aresta do Tetraedro (Inteiro):"));
        Tetrahedron te = new Tetrahedron(arestaTe);
        exibir3D("Tetraedro", te.getVolume(), te.getSurfaceArea());
    }

    private static void exibir2D(String nome, double area, double perimetro) {
        JOptionPane.showMessageDialog(null, String.format("%s\nÁrea: %.2f\nPerímetro: %.2f", nome, area, perimetro));
    }

    private static void exibir3D(String nome, double vol, double areaT) {
        JOptionPane.showMessageDialog(null, String.format("%s\nVolume: %.2f\nÁrea Total: %.2f", nome, vol, areaT));
    }
}