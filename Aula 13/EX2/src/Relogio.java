/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 24.00115-5
 */
public class Relogio { // classe Relogio que representa um relógio digital
    public Mostrador horas; // mostrador para as horas
    public Mostrador minutos; // mostrador para os minutos
    public String mostrador; // string que representa a hora atual no formato "HH:MM"

    public Relogio() { // construtor que inicializa os mostradores de horas e minutos
        horas = new Mostrador(24); // o mostrador de horas tem um limite de 24 (0-23)
        minutos = new Mostrador(60); // o mostrador de minutos tem um limite de 60 (0-59)
        atualizarMostrador(); // atualiza a string do mostrador para refletir a hora inicial (00:00)
    }
    public void ticTac() { // método que avança o relógio em um minuto
        minutos.incrementar(); // incrementa o mostrador de minutos
        if (minutos.getValor() == 0) { // se os minutos voltarem para 0, significa que uma hora se passou
            horas.incrementar();
        }
        atualizarMostrador(); // atualiza a string do mostrador para refletir a nova hora após o avanço
    }
    public void atualizarMostrador() { // método privado para atualizar a string do mostrador com a hora atual formatada
        mostrador = horas.mostra() + ":" + minutos.mostra();
    }
    public String mostra() { // método público para obter a string do mostrador, que representa a hora atual
        return mostrador;
    }
}
