import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import rei.Checksum;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChecksumTest {

    private final Checksum checksum = new Checksum();

    @Test
    public void testCaminhoFeliz() {
        // Teste 1: Caixa Preta - Entrada conhecida, saída esperada
        char[] entrada = {'C', 'a', 's', 'a', '1'};
        char esperado = 'W';
        
        assertEquals(esperado, checksum.calcularChecksum(entrada), 
            "O cálculo do checksum de 'Casa1' está incorreto.");
    }

    @Test
    public void testArrayVazio() {
        // Teste 2: Array vazio
        char[] entradaVazia = {};
        char esperado = '\u0000';
        
        assertEquals(esperado, checksum.calcularChecksum(entradaVazia), 
            "O checksum para um array vazio deveria ser o caractere nulo.");
    }

    @Test
    public void testTratamentoArrayNulo() {
        // Teste 3: Captura de Exceção (NullPointerException)
        // O assertThrows valida se a exceção correta é disparada ao passar null
        assertThrows(NullPointerException.class, () -> {
            checksum.calcularChecksum(null);
        }, "Deveria lançar NullPointerException ao passar um array nulo.");
    }

    @Test
    public void testArquivoTexto(@TempDir Path pastaTemporaria) throws IOException {
        // Teste 4: Arquivo Texto usando a anotação @TempDir do JUnit 5.
        // Isso cria e deleta os arquivos automaticamente isolados na memória do teste.
        Path entrada = pastaTemporaria.resolve("arquivo_entrada.txt");
        Path saida = pastaTemporaria.resolve("arquivo_saida.txt");

        // Escreve os dados iniciais
        Files.writeString(entrada, "Casa1", StandardCharsets.UTF_8);
        
        // Executa a lógica de negócio do arquivo
        checksum.calcularChecksumDoArquivoTexto(entrada.toString(), saida.toString());

        // Valida o resultado final gravado
        String conteudoResultante = Files.readString(saida, StandardCharsets.UTF_8);
        assertEquals("Casa1W", conteudoResultante, 
            "O arquivo de saída não contém o conteúdo original concatenado ao seu checksum.");
    }
}
