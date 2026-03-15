// Importa classes necessárias para ler arquivos
import java.io.File;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {

        try {
            // Cria um objeto File apontando para o arquivo
            File file = new File("dados.txt");

            // Cria um Scanner para ler o arquivo
            Scanner sc = new Scanner(file);

            // Lê o nome do comprador (primeira linha)
            String nomeComprador = sc.nextLine();

            // Lê o produto adquirido (segunda linha)
            String produto = sc.nextLine();

            // Lê a quantidade adquirida (terceira linha) e converte para inteiro
            int quantidade = Integer.parseInt(sc.nextLine());

            // Lê o preço unitário (quarta linha) e converte para double
            double precoUnitario = Double.parseDouble(sc.nextLine());

            // Fecha o scanner após a leitura
            sc.close();

            // Calcula o valor total da compra
            double total = quantidade * precoUnitario;

            // Imprime a Nota Fiscal formatada
            System.out.println("========= NOTA FISCAL =========");
            System.out.println("Comprador: " + nomeComprador);
            System.out.println("Produto: " + produto);
            System.out.println("Quantidade: " + quantidade);
            System.out.println("Preço Unitário: R$ " + String.format("%.2f", precoUnitario));
            System.out.println("Total: R$ " + String.format("%.2f", total));
            System.out.println("===============================");

        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}