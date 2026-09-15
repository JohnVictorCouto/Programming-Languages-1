import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChecksumTest {

    public static void main(String[] args) {
        Checksum checksum = new Checksum();
        int testesPassaram = 0;
        int totalTestes = 0;

        System.out.println("--- INICIANDO BATERIA DE TESTES UNITÁRIOS ---");

        // Teste 1: Caminho feliz (Caixa Preta - Entrada conhecida, saída esperada)
        totalTestes++;
        if (testar("Checksum de 'Casa1'", checksum.calcularChecksum(new char[] { 'C', 'a', 's', 'a', '1' }) == 'W')) testesPassaram++;

        // Teste 2: Array vazio
        totalTestes++;
        if (testar("Checksum vazio", checksum.calcularChecksum(new char[] {}) == '\u0000')) testesPassaram++;

        // Teste 3: Captura de Exceção (NullPointerException)
        totalTestes++;
        boolean lancouExcecao = false;
        try {
            checksum.calcularChecksum(null);
        } catch (NullPointerException e) {
            lancouExcecao = true;
        }
        if (testar("Tratamento de Array Nulo", lancouExcecao)) testesPassaram++;

        // Teste 4: Arquivo Texto
        totalTestes++;
        if (testarArquivo(checksum)) testesPassaram++;

        // Resumo
        System.out.println("\nResumo: " + testesPassaram + "/" + totalTestes + " testes passaram.");
    }

    private static boolean testarArquivo(Checksum checksum) {
        try {
            Path entrada = Path.of("arquivo_entrada.txt");
            Path saida = Path.of("arquivo_saida.txt");

            Files.writeString(entrada, "Casa1", StandardCharsets.UTF_8);
            checksum.calcularChecksumDoArquivoTexto(entrada.toString(), saida.toString());

            String conteudo = Files.readString(saida, StandardCharsets.UTF_8);
            
            // Limpa os arquivos temporários
            Files.deleteIfExists(entrada);
            Files.deleteIfExists(saida);

            return testar("Leitura e Gravação de Arquivo", conteudo.equals("Casa1W"));
        } catch (IOException e) {
            System.out.println("[FALHA] Erro de I/O no teste de arquivo: " + e.getMessage());
            return false;
        }
    }

    private static boolean testar(String nomeTeste, boolean condicao) {
        if (condicao) {
            System.out.println("[OK] " + nomeTeste);
            return true;
        } else {
            System.out.println("[FALHA] " + nomeTeste);
            return false;
        }
    }
}