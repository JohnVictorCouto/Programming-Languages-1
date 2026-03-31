public class Teste {
    public static void main(String[] args) {
        Relogio relogio = new Relogio(); // cria um objeto Relogio, que representa um relógio digital
        while (true) {
            System.out.println(relogio.mostra()); // imprime a hora atual do relógio no formato "HH:MM"
            relogio.ticTac(); // avança o relógio em um minuto
            try {
                Thread.sleep(10); // pausa a execução por 1 segundo para simular o avanço do tempo
            } catch (InterruptedException e) {
                e.printStackTrace(); // trata a exceção caso a thread seja interrompida durante o sono
            }
        }
    }
}