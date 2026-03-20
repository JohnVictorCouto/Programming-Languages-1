public class ex21 {
    public static void main(String[] args) {
        int i = 1; // Inicializa a variável i com o valor 1
        int num = 20; // Inicializa a variável num com o valor 20
        while (i < num + 1) { // Continua o loop enquanto i for menor que num
            System.out.println("Polegada (in)" + "  " + "Centimetros (cm)"); // Imprime os títulos das colunas
            System.out.println("    " + i + "           " + (i*2.54)); // Imprime os valores de i e i*2.54 formatados em colunas, onde i representa as polegadas e i*2.54 representa a conversão para centímetros
            i += 1; // Incrementa i em 1 a cada iteração do loop
        }
    }
}