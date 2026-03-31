public class Relogio { // classe Relogio que representa um relógio digital
    public Mostrador horas; // mostrador para as horas
    public Mostrador minutos; // mostrador para os minutos
    public Mostrador segundos; // mostrador para os segundos
    public String mostrador; // string que representa a hora atual no formato "HH:MM:SS"
    public boolean periodo; // variável para indicar se é AM ou PM

    public Relogio() { // construtor que inicializa os mostradores de horas e minutos
        horas = new Mostrador(24); // o mostrador de horas tem um limite de 24 (0-23)
        minutos = new Mostrador(60); // o mostrador de minutos tem um limite de 60 (0-59)
        segundos = new Mostrador(60); // o mostrador de segundos tem um limite de 60 (0-59)
        periodo = true; // inicialmente, o período é AM
        atualizarMostrador(); // atualiza a string do mostrador para refletir a hora inicial (00:00:00)
    }
    public void ticTac() { // método que avança o relógio em um minuto
        segundos.incrementar(); // incrementa o mostrador de segundos
        if (segundos.getValor() == 0) { // se os segundos voltarem para 0, significa que um minuto se passou
            minutos.incrementar();
            if (minutos.getValor() == 0) { // se os minutos voltarem para 0, significa que uma hora se passou
                horas.incrementar();
                if (horas.getValor() == 12 || horas.getValor() == 0) { // se as horas voltarem para 0, significa que um ciclo de 24 horas se passou
                    periodo = !periodo; // alterna entre AM e PM
                }
            }
        }
        atualizarMostrador(); // atualiza a string do mostrador para refletir a nova hora após o avanço
    }
    private void atualizarMostrador() { // método privado para atualizar a string do mostrador com a hora atual formatada
        mostrador = horas.mostra() + ":" + minutos.mostra() + ":" + segundos.mostra() + (periodo ? "- AM" : "- PM"); // formata a hora como "HH:MM:SS - AM/PM"
    }
    public String mostra() { // método público para obter a string do mostrador, que representa a hora atual
        return mostrador;
    }
}
