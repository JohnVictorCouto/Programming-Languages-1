// Importa classes necessárias para ler arquivos
import java.io.File;
import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        String[] palavras = new String[10];
        try {
            // Cria um objeto File apontando para o arquivo
            File file = new File("arquivo.txt");

            // Cria um Scanner para ler o arquivo
            Scanner sc = new Scanner(file);

            //Lê 10 strings e armazena no array
            for (int i = 0; i < 10 && sc.hasNext(); i++) {
                palavras[i] = sc.next();
            } 
            // Fecha o scanner após a leitura
            sc.close();

            //Imprime na Ordem Inversa as Strings do Arquivo
            for (int i = 9; i >= 0; i--) {
                if (palavras[i] != null) {
                    System.out.println(palavras[i]);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}