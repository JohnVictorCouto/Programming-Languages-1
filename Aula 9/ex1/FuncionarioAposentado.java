public class FuncionarioAposentado extends Funcionario {
    private double salarioAposentadoria;

    public FuncionarioAposentado(String nome, int idade, double salario, String cargo, boolean ehAposentado, double salarioAposentadoria) {
        super(nome, idade, salario, cargo, ehAposentado);
        this.salarioAposentadoria = salarioAposentadoria;
    }

    public double getSalarioAposentadoria() {
        return salarioAposentadoria;
    }

    public void setSalarioAposentadoria(double salarioAposentadoria) {
        this.salarioAposentadoria = salarioAposentadoria;
    }

    @Override
    public int categoria(int idade){
        return 60;
    }
}
