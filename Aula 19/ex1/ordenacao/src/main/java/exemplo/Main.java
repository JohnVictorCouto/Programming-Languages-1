package exemplo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Entrada de exemplo para testar no console
        int[] vetor = {10, 9, 5, 8};

        System.out.println("Vetor original: " + Arrays.toString(vetor));

        // Instancia a classe de negócio e executa a ordenação decrescente
        Ordena ordenador = new Ordena();
        ordenador.ordenaNumerosDecrescentes(vetor);

        System.out.println("Vetor ordenado (Decrescente): " + Arrays.toString(vetor));
    }
}
