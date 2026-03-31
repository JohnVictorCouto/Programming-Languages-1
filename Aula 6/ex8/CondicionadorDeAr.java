import javax.swing.JOptionPane;

public class CondicionadorDeAr { // Classe para controlar o ar-condicionado

    private boolean ligado; // Estado do aparelho (ligado ou desligado)
    private Termostato termostato; // Composição: o condicionador de ar tem um termostato para controlar a temperatura

    public CondicionadorDeAr() { // Construtor para inicializar o estado do aparelho e o termostato
        this.ligado = false; // O aparelho começa desligado
        this.termostato = new Termostato(); // Inicializa o termostato com a temperatura padrão (20°C)
    }

    public void ligar() { // Método para ligar o aparelho
        ligado = true;
        JOptionPane.showMessageDialog(null, "Ar-condicionado ligado.");
    }

    public void desligar() { // Método para desligar o aparelho
        ligado = false;
        JOptionPane.showMessageDialog(null, "Ar-condicionado desligado.");
    }

    public void aumentarTemperatura() { // Método para aumentar a temperatura do ar-condicionado

        if (!ligado) { // Verifica se o aparelho está desligado antes de tentar aumentar a temperatura
            JOptionPane.showMessageDialog(null, "Erro: aparelho desligado!");
            return;
        }

        int temp = termostato.getTemperatura(); // Obtém a temperatura atual do termostato

        if (temp < 28) { // Verifica se a temperatura atual é menor que o limite máximo (28°C)
            termostato.setTemperatura(temp + 1); // Aumenta a temperatura em 1 grau
        } else { // Se a temperatura já estiver no limite máximo, exibe uma mensagem de aviso
            JOptionPane.showMessageDialog(null, "Máximo de 28°C atingido!");
        }
    }

    public void reduzirTemperatura() { // Método para reduzir a temperatura do ar-condicionado

        if (!ligado) { // Verifica se o aparelho está desligado antes de tentar reduzir a temperatura
            JOptionPane.showMessageDialog(null, "Erro: aparelho desligado!");
            return;
        }

        int temp = termostato.getTemperatura(); // Obtém a temperatura atual do termostato

        if (temp > 15) { // Verifica se a temperatura atual é maior que o limite mínimo (15°C)
            termostato.setTemperatura(temp - 1); // Reduz a temperatura em 1 grau
        } else { // Se a temperatura já estiver no limite mínimo, exibe uma mensagem de aviso
            JOptionPane.showMessageDialog(null, "Mínimo de 15°C atingido!");
        }
    }

    public void imprimirTemperatura() { // Método para imprimir a temperatura atual do ar-condicionado

        if (!ligado) { // Verifica se o aparelho está desligado antes de tentar imprimir a temperatura
            JOptionPane.showMessageDialog(null, "Erro: aparelho desligado!");
            return;
        }

        JOptionPane.showMessageDialog(null,"Temperatura atual: " + termostato.getTemperatura() + "°C"); // Exibe a temperatura atual do termostato em uma caixa de diálogo
    }
}