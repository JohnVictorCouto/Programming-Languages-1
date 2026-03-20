public class ex4 {
    public static void main(String[] args) {
        int i = 1; // Inicializa a variável i com o valor 1
        int num = 20; // Inicializa a variável num com o valor 20
        while (i < num + 1) { // Continua o loop enquanto i for menor que num
            System.out.println("Progressiva" + "  " + "Regressiva"); // Imprime os títulos das colunas
            System.out.println("    " + i + "           " + (num - i)); // Imprime os valores de i e num - i formatados em colunas
            i += 1; // Incrementa i em 1 a cada iteração do loop
        }
    }
}