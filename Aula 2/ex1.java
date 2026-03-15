import java.util.Scanner; // Importa a classe Scanner

public class ex1 {

    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in); // Cria um objeto Scanner para ler dados digitados

        // Entrada de dados
        System.out.print("Nome do comprador: "); 
        String nome = sc.nextLine(); // Lê o nome digitado 
        System.out.print("Produto adquirido: "); 
        String produto = sc.nextLine(); // Lê o nome do produto digitado
        System.out.print("Quantidade adquirida: "); 
        int quantidade = sc.nextInt(); // Lê a quantidade digitada 
        System.out.print("Preço unitário do produto: "); 
        double precoUnitario = sc.nextDouble(); // Lê o preço digitado
        double total = quantidade * precoUnitario; // Calcula o valor total

        // Impressão da Nota Fiscal
        System.out.println("\n=========== NOTA FISCAL ==========="); 
        System.out.println("Comprador: " + nome); 
        System.out.println("Produto: " + produto); 
        System.out.println("Quantidade: " + quantidade); 
        System.out.printf("Preço Unitário: R$ %.2f%n", precoUnitario); 
        System.out.printf("Total a pagar: R$ %.2f%n", total); 
        System.out.println("==================================="); 
        
        sc.close(); // Fecha o objeto Scanner
    }
}