import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import exemplo.Ordena;
public class OrdenaTest {

    @Test
    public void testOrdenacaoDecrescente() {
        // Entrada de teste (vetor desordenado)
        int[] proposto = {10, 9, 5, 8};
        
        // Resultado esperado em ordem DECRESCENTE
        int[] esperado = {10, 9, 8, 5};

        Ordena teste = new Ordena();
        teste.ordenaNumerosDecrescentes(proposto);

        // O JUnit valida automaticamente o tamanho e cada elemento do vetor
        assertArrayEquals(esperado, proposto, "O vetor não foi ordenado corretamente em ordem decrescente.");
    }
}
