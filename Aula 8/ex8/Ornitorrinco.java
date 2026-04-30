public class Ornitorrinco extends Oviparo implements Lactante {
    public Ornitorrinco(String nome, int numeroOvosPorPostura, int tempoIncubacaoDias) {
        super(nome, 4, numeroOvosPorPostura, tempoIncubacaoDias); // Ornitorrincos têm 4 patas
    }

    @Override
    public String produzirLeite() { // Implementação do método da interface Lactante
        return "Fêmea produz leite, apesar de ser ovíparo."; // Ornitorrincos são únicos por serem mamíferos que botam ovos, e as fêmeas produzem leite para alimentar os filhotes, mesmo sem mamilos.
    }
}
