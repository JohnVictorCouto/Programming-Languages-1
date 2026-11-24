import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Interface funcional necessária para viabilizar o Exemplo 1
@FunctionalInterface
interface Operacao {
    int executar(int a, int b);
}

public class Lambda {

    public static void main(String[] args) {
        
        System.out.println("====== REGISTRO DE FUNCIONAMENTO ======\n");

        // ----------------------------------------------------
        // 1. Lambda simples
        // ----------------------------------------------------
        Operacao soma = (a, b) -> a + b;
        int resultadoSoma = soma.executar(5, 3); // resultado é 8
        
        System.out.println("[Exemplo 1] Lambda simples:");
        System.out.println("Soma realizada (5 + 3) = " + resultadoSoma);
        System.out.println();


        // ----------------------------------------------------
        // 2. Lambda com tipos explícitos
        // ----------------------------------------------------
        Comparator<String> comparador = (String s1, String s2) -> s1.compareTo(s2);
        int resultadoComparacao = comparador.compare("maçã", "banana");
        
        System.out.println("[Exemplo 2] Lambda com tipos explícitos:");
        System.out.println("Resultado da comparação entre 'maçã' e 'banana': " + resultadoComparacao);
        if (resultadoComparacao > 0) {
            System.out.println("-> Significado: 'maçã' é maior (vem depois) que 'banana' lexicograficamente.");
        }
        System.out.println();


        // ----------------------------------------------------
        // 3. Filtragem com Lambda
        // ----------------------------------------------------
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
                                     
        System.out.println("[Exemplo 3] Filtragem com Lambda:");
        System.out.println("Lista original: " + numeros);
        System.out.println("Lista filtrada (somente pares): " + pares);
        
        System.out.println("\n=======================================");
    }
}
