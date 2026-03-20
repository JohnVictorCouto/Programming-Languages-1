public class ex11 {
    public static void main(String[] args) {
        int num = 501; // Inicializa a variável num com o valor 500
        String resultado = ""; // Inicializa a variável resultado como uma string vazia
        for (int i = 0; i < num; i++) {
            if (i % 5 == 0) { // Verifica se i é múltiplo de 5
                resultado += i + "\n"; // Adiciona o número múltiplo de 5 à variável resultado seguido de uma nova linha
            }
        }
        System.out.println(resultado); // Exibe a variável resultado no console
    }
}
