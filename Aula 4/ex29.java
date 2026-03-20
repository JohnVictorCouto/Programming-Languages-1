import javax.swing.JOptionPane;

public class ex29 {

    public static void main(String[] args) {

        int voto; // Variável para armazenar o voto do usuário, que será um número inteiro representando o candidato escolhido ou a opção de encerrar a votação
        int candidato1 = 0; // Variável para contar os votos do candidato 1, inicialmente definida como 0
        int candidato2 = 0; // Variável para contar os votos do candidato 2, inicialmente definida como 0
        int candidato3 = 0; // Variável para contar os votos do candidato 3, inicialmente definida como 0
        int candidato4 = 0; // Variável para contar os votos do candidato 4, inicialmente definida como 0
        int totalEleitores = 0; // Variável para contar o total de eleitores que votaram, inicialmente definida como 0

        while (true) {

            voto = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                VOTAÇÃO \n
                                                                1 - Candidato 1
                                                                2 - Candidato 2
                                                                3 - Candidato 3
                                                                4 - Candidato 4
                                                                
                                                                Digite seu voto (-1 para encerrar):"""));

            if (voto == -1) { // Verifica se o voto digitado é -1, o que indica que o usuário deseja encerrar a votação
                break; // Encerra o loop se o voto for -1
            }

            switch (voto) { // Verifica o valor do voto digitado e incrementa o contador correspondente ao candidato escolhido, além de incrementar o total de eleitores
                case 1: // Se o voto for 1, incrementa o contador do candidato 1 e o total de eleitores
                    candidato1++; 
                    totalEleitores++;
                    break;

                case 2: // Se o voto for 2, incrementa o contador do candidato 2 e o total de eleitores
                    candidato2++;
                    totalEleitores++;
                    break;

                case 3: // Se o voto for 3, incrementa o contador do candidato 3 e o total de eleitores
                    candidato3++;
                    totalEleitores++;
                    break;
                case 4: // Se o voto for 4, incrementa o contador do candidato 4 e o total de eleitores
                    candidato4++;
                    totalEleitores++;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Voto inválido!"); // Exibe uma mensagem de erro caso o voto digitado seja diferente de 1, 2, 3, 4 ou -1
            }
        }

        if (totalEleitores == 0) { // Verifica se o total de eleitores é 0, o que indica que nenhum voto foi registrado
            JOptionPane.showMessageDialog(null, "Nenhum voto registrado."); // Exibe uma mensagem indicando que nenhum voto foi registrado
            return; // Encerra o programa se nenhum voto foi registrado para evitar divisão por zero no cálculo dos percentuais
        }

        double p1 = (candidato1 * 100.0) / totalEleitores; // Calcula o percentual de votos para o candidato 1 como a quantidade de votos do candidato 1 multiplicada por 100 e dividida pelo total de eleitores
        double p2 = (candidato2 * 100.0) / totalEleitores; // Calcula o percentual de votos para o candidato 2 como a quantidade de votos do candidato 2 multiplicada por 100 e dividida pelo total de eleitores
        double p3 = (candidato3 * 100.0) / totalEleitores; // Calcula o percentual de votos para o candidato 3 como a quantidade de votos do candidato 3 multiplicada por 100 e dividida pelo total de eleitores
        double p4 = (candidato4 * 100.0) / totalEleitores; // Calcula o percentual de votos para o candidato 4 como a quantidade de votos do candidato 4 multiplicada por 100 e dividida pelo total de eleitores

        String resultado =
                """
                RESULTADO \n
                
                Total de eleitores: """ + totalEleitores + "\n\n" +
                "Candidato 1: " + String.format("%.2f", p1) + "%\n" +
                "Candidato 2: " + String.format("%.2f", p2) + "%\n" +
                "Candidato 3: " + String.format("%.2f", p3) + "%\n" +
                "Candidato 4: " + String.format("%.2f", p4) + "%";

        JOptionPane.showMessageDialog(null, resultado); // Exibe o resultado da eleição em uma mensagem para o usuário, mostrando o total de eleitores e o percentual de votos para cada candidato formatado com duas casas decimais
    }
}