public class Caixa {
    // Atributos privados para respeitar o encapsulamento
    private String corredor;
    private int posicao;
    private double peso;
    private String dono;

    // Construtor
    public Caixa(String corredor, int posicao, double peso, String dono) {
        this.corredor = corredor;
        this.posicao = posicao;
        this.peso = peso;
        this.dono = dono;
    }

    // Métodos de Acesso (Getters) e Modificadores (Setters)
    public String getCorredor() { return corredor; }
    public void setCorredor(String corredor) { this.corredor = corredor; }

    public int getPosicao() { return posicao; }
    public void setPosicao(int posicao) { this.posicao = posicao; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getDono() { return dono; }
    public void setDono(String dono) { this.dono = dono; }

    @Override
    public String toString() {
        return "Dono: " + dono + " | Corredor: " + corredor + " | Pos: " + posicao + " | Peso: " + peso + "kg";
    }
}
