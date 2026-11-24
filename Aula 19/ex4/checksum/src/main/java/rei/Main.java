package rei;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Checksum checksum = new Checksum();
        char[] dados = {'C', 'a', 's', 'a', '1'};

        System.out.println("--- Teste de Algoritmos de Verificação ---");
        System.out.println("Dados de entrada: " + Arrays.toString(dados));
        
        // Exibe os caracteres resultantes
        System.out.println("Resultado Checksum (Exercício 1): " + checksum.calcularChecksum(dados));
        System.out.println("Resultado CRC-8    (Exercício 3): " + (int) checksum.calcularCRC(dados) + " (Valor ASCII)");
    }
}
