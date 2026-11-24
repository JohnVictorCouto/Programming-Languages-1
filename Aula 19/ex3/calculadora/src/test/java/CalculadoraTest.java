import ejemplo.Calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testSomarDoisNumerosPositivos() {
        Calculadora calc = new Calculadora();
        
        // Cenário: Somar 5 + 3
        int resultadoEsperado = 8;
        int resultadoAtual = calc.somar(5, 3);
        
        // Asserção do JUnit 5
        assertEquals(resultadoEsperado, resultadoAtual, "O cálculo da soma de números positivos está incorreto.");
    }

    @Test
    public void testSomarComNumeroNegativo() {
        Calculadora calc = new Calculadora();
        
        // Cenário: Somar 10 + (-4)
        int resultadoEsperado = 6;
        int resultadoAtual = calc.somar(10, -4);
        
        assertEquals(resultadoEsperado, resultadoAtual, "O cálculo da soma envolvendo números negativos falhou.");
    }
}
