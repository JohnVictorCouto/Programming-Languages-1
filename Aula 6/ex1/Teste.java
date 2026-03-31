public class Teste {
    public static void main(String[] args) {
        Relogio relogio = new Relogio(); //
        for (int i = 0; i < 1440; i++) { // simula o avanço do relógio por um dia inteiro (1440 minutos)
            relogio.ticTac(); // avança o relógio em um minuto
            System.out.println(relogio.mostra()); // imprime a hora atual no formato "HH:MM" a cada minuto
        }
    }
}
