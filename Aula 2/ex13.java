import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada das três frases
        System.out.println("Digite a primeira frase:");
        String f1 = scanner.nextLine();
        System.out.println("Digite a segunda frase:");
        String f2 = scanner.nextLine();
        System.out.println("Digite a terceira frase:");
        String f3 = scanner.nextLine();

        // Cálculo dos pontos médios
        int m1 = f1.length() / 2;
        int m2 = f2.length() / 2;
        int m3 = f3.length() / 2;

        // Separação das metades
        String f1_p1 = f1.substring(0, m1);
        String f1_p2 = f1.substring(m1);
        
        String f2_p1 = f2.substring(0, m2);
        String f2_p2 = f2.substring(m2);
        
        String f3_p1 = f3.substring(0, m3);
        String f3_p2 = f3.substring(m3);

        // Construção da frase embaralhada 
        String fraseEmbaralhada = f2_p1 + f3_p2 + f2_p2 + f1_p1 + f3_p1 + f1_p2;

        // Concatenação das frases originais
        String frasesOriginais = f1 + f2 + f3;

        // Saída dos resultados
        System.out.println("\nFrases Originais Concatenadas:");
        System.out.println(frasesOriginais);
        
        System.out.println("\nFrase Embaralhada:");
        System.out.println(fraseEmbaralhada);

        scanner.close();
    }
}
