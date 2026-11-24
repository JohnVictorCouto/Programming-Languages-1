package exemple;

public class Main {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5, 4);

        System.out.println("--- Dados do Retângulo ---");
        System.out.println("Área calculada.....: " + retangulo.Area());
        System.out.println("Perímetro calculado: " + retangulo.Perimetro());
    }
}