import javax.swing.JOptionPane;

public class Usuario { // Classe para representar um usuário do sistema

    public static void main(String[] args) {

        CondicionadorDeAr ar = new CondicionadorDeAr(); // Cria um objeto do tipo CondicionadorDeAr para controlar o ar-condicionado
 
        int opcao = -1;

        while (opcao != 0) { // Loop para exibir o menu e processar as opções do usuário até que ele escolha sair (opção 0)

            String menu = "=== CONTROLE DO AR ===\n\n"
                    + "1 - Ligar\n"
                    + "2 - Desligar\n"
                    + "3 - Aumentar temperatura\n"
                    + "4 - Reduzir temperatura\n"
                    + "5 - Ver temperatura\n"
                    + "0 - Sair\n\n"
                    + "Escolha:";

            try {

                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {

                    case 1:
                        ar.ligar();
                        break;

                    case 2:
                        ar.desligar();
                        break;

                    case 3:
                        ar.aumentarTemperatura();
                        break;

                    case 4:
                        ar.reduzirTemperatura();
                        break;

                    case 5:
                        ar.imprimirTemperatura();
                        break;

                    case 0:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
            }
        }
    }
}