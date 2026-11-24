import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.Calculadora;

public class CalculadoraTest {
    Calculadora calc = new Calculadora();

    // verificar se um caso esperado (uma soma que eu sei o resultado) é verdadeiro
    @Test
    @DisplayName("Soma: ")
    public void deveSomarInteiros(){
        // caso esperado = soma de 1 + 1
        // valor esperado = 2
        assertEquals(4, calc.soma(1,1));
    }
}
