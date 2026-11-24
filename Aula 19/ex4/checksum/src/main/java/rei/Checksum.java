package rei;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Checksum {

    // --- Exercício 1: Cálculo do Checksum (Soma e Complemento de 2) ---
    public char calcularChecksum(char[] dados) {
        int soma = 0;
        
        //Somar os grupos de dados (somando os valores ASCII)
        for (char c : dados) {
            soma += c;
        }
        
        // 3. Descartar o bit excedente à esquerda (mantemos apenas os 8 bits menos significativos)
        int soma8Bits = soma & 0xFF; 
        
        // 4. Calcular o Complemento de 2
        int complemento1 = (~soma8Bits) & 0xFF;
        
        // Depois, somamos 1 ao resultado complementado
        int complemento2 = (complemento1 + 1) & 0xFF;
        
        return (char) complemento2;
    }

    // --- Exercício 2: Cálculo a partir de Arquivo Texto ---
    public void calcularChecksumDoArquivoTexto(String caminhoEntrada, String caminhoSaida) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        
        // Lê os caracteres do arquivo de entrada
        try (FileReader reader = new FileReader(caminhoEntrada)) {
            int caractereLido;
            while ((caractereLido = reader.read()) != -1) {
                conteudo.append((char) caractereLido);
            }
        }
        
        // Calcula o checksum
        char[] dados = conteudo.toString().toCharArray();
        char checksum = calcularChecksum(dados);
        
        // Grava os dados originais + o checksum no arquivo de saída
        try (FileWriter writer = new FileWriter(caminhoSaida)) {
            writer.write(dados);
            writer.write(checksum);
        }
    }

    // --- Exercício 3: Desafio ---
    // O CRC-8 ou CRC-16 usa aritmética polinomial e deslocamento de bits (XOR).
    public char calcularCRC(char[] dados) {
        int crc = 0x00; // Valor inicial
        int polinomio = 0x07;

        for (char c : dados) {
            crc ^= (c & 0xFF);
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x80) != 0) {
                    crc = (crc << 1) ^ polinomio;
                } else {
                    crc <<= 1;
                }
            }
        }
        return (char) (crc & 0xFF);
    }
}