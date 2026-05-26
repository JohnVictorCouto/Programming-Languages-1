public class Tarefeiro extends Empregado {
    private double valorTarefa;
    private int quantidadeTarefas;

    public Tarefeiro(String nome, String sobrenome, String cpf, double valorTarefa, int quantidadeTarefas) {
        super(nome, sobrenome, cpf);
        this.valorTarefa = valorTarefa;
        this.quantidadeTarefas = quantidadeTarefas;
    }

    @Override
    public double salario() {
        return valorTarefa * quantidadeTarefas;
    }
}
