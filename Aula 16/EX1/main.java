import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {
    private Formatter output; 

    public void openFile() {
        try {
            output = new Formatter("usuarios.txt");
        } catch (SecurityException securityException) {
            System.err.println("Você não tem acesso de gravação a este arquivo.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao criar o arquivo.");
            System.exit(1);
        }
    }

    public void addRecords() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Quantas pessoas deseja cadastrar? ");
        int quantidade = input.nextInt();
        input.nextLine(); 

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Informe um valor maior que zero.");
            return;
        }

        try {
            output.format("nome,senha\n");
            for (int i = 1; i <= quantidade; i++) {
                System.out.println("\nCadastro da pessoa " + i + ":");
                System.out.print("Nome: ");
                String nome = input.nextLine();

                System.out.print("Senha: ");
                String senha = input.nextLine();

                output.format("%s,%s\n", nome, senha);
            }
            System.out.println("\nDados gravados com sucesso no arquivo usuarios.txt");
            
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Erro ao escrever no arquivo.");
        } catch (NoSuchElementException elementException) {
            System.err.println("Entrada inválida. Tente novamente.");
        } finally {
            input.close();
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }

    public static void main(String[] args) {
        main application = new main();
        application.openFile();
        application.addRecords();
        application.closeFile();
    }
}