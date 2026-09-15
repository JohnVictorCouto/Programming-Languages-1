import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    private static final String ARQUIVO_USUARIOS = "usuarios.txt";
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Fazer login");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrarUsuarios();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            }
        }
    }

    private static void cadastrarUsuarios() {
        File arquivo = new File(ARQUIVO_USUARIOS);

        try {
            boolean arquivoExiste = arquivo.exists();
            FileWriter escritor = new FileWriter(arquivo, true);
            BufferedWriter buffer = new BufferedWriter(escritor);

            if (!arquivoExiste || arquivo.length() == 0L) {
                buffer.write("nome,senha");
                buffer.newLine();
            }

            System.out.print("Quantos usuários deseja cadastrar? ");
            int quantidade = lerInteiro();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida. Informe um valor maior que zero.");
                buffer.close();
                return;
            }

            for (int i = 1; i <= quantidade; i++) {
                System.out.println("\nCadastro do usuário " + i + ":");
                System.out.print("Nome: ");
                String nome = input.nextLine();

                System.out.print("Senha: ");
                String senha = input.nextLine();

                buffer.write(nome + "," + senha);
                buffer.newLine();
            }

            buffer.close();
            System.out.println("\nDados gravados com sucesso no arquivo " + ARQUIVO_USUARIOS);

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private static void fazerLogin() {
        File arquivo = new File(ARQUIVO_USUARIOS);

        if (!arquivo.exists()) {
            System.out.println("Arquivo de usuários não encontrado. Cadastre um usuário antes de logar.");
            return;
        }

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Senha: ");
        String senha = input.nextLine();

        if (validarLogin(nome, senha)) {
            System.out.println("LOGIN REALIZADO COM SUCESSO");
        } else {
            System.out.println("LOGIN E/OU SENHA ERRADO(S)");
            System.out.print("Deseja realizar cadastro? (S/N): ");
            String resposta = input.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                cadastrarUsuarios();
            }
        }
    }

    private static boolean validarLogin(String nome, String senha) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.equalsIgnoreCase("nome,senha")) {
                    continue;
                }

                String[] dados = linha.split(",", 2);

                if (dados.length == 2 && dados[0].trim().equals(nome.trim()) && dados[1].trim().equals(senha.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return false;
    }
}