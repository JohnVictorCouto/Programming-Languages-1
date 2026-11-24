package ejemplo;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        int resultado = calc.somar(7, 12);
        
        System.out.println("Resultado de 7 + 12 = " + resultado);
    }
}