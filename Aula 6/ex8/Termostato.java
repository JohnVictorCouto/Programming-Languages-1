public class Termostato { // Classe para controlar a temperatura do ar-condicionado

    private int temperatura; // Temperatura em graus Celsius

    public Termostato() { // Construtor para inicializar a temperatura
        this.temperatura = 20; // Temperatura padrão
    }

    public int getTemperatura() { // Método para obter a temperatura atual
        return temperatura;
    }

    public void setTemperatura(int temperatura) { // Método para definir a temperatura, com validação
        if (temperatura >= 15 && temperatura <= 28) { // Verifica se a temperatura está dentro do intervalo permitido
            this.temperatura = temperatura;
        } else { // Se a temperatura for inválida, exibe uma mensagem de erro
            System.out.println("Temperatura inválida! (15 a 28 graus)");
        }
    }
}