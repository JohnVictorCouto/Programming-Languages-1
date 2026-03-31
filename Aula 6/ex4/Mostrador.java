public class Mostrador {
    private int valor; // valor atual do mostrador
    private int limite; // limite para o valor do mostrador (ex: 24 para horas, 60 para minutos/segundos)

    public Mostrador(int limite) { // construtor que recebe o limite do mostrador
        this.limite = limite;
        this.valor = 0;
    }
    public int getValor() { // método para obter o valor atual do mostrador
        return valor;
    }
    public void incrementar() { // método para incrementar o valor do mostrador
        valor = (valor + 1) % limite;
    }
    public String mostra(){ // método para mostrar o valor do mostrador formatado
        if (valor < 10) { // se o valor for menor que 10, adiciona um zero à esquerda
            return "0" + valor;
        } else { // caso contrário, retorna o valor normalmente
            return "" + valor;
        }
    }
}
