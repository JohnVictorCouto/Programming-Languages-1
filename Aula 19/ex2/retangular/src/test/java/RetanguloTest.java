import exemple.Retangulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetanguloTest {

    @Test
    public void testCalcularArea() {
        Retangulo retangulo = new Retangulo(5, 4);
        int areaEsperada = 20;
        
        // No JUnit 5, a mensagem fica obrigatoriamente no final
        assertEquals(areaEsperada, retangulo.Area(), "O cálculo da área está incorreto.");
    }

    @Test
    public void testCalcularPerimetro() {
        Retangulo retangulo = new Retangulo(5, 4);
        int perimetroEsperado = 18;
        
        // No JUnit 5, a mensagem fica obrigatoriamente no final
        assertEquals(perimetroEsperado, retangulo.Perimetro(), "O cálculo do perímetro está incorreto.");
    }
}
