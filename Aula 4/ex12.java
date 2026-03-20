import java.math.BigInteger; // Importa a classe BigInteger para lidar com números grandes

public class ex12 {
    public static void main(String[] args) {
        BigInteger produto = BigInteger.ONE; // Inicializa a variável produto com o valor 1 
        // Loop de 120 até 300
        for (int i = 120; i <= 300; i++) { // Itera de 120 a 300
            produto = produto.multiply(BigInteger.valueOf(i)); // Multiplica o valor atual de produto pelo número i convertido para BigInteger
        }

        System.out.println("O produto de todos os números de 120 a 300 é: "+ produto);
    }
}