public class Funcionario extends Pessoa {
    private double salario;
    private String cargo;
    private boolean ehAposentado;
    public Funcionario(String nome, int idade, double salario, String cargo, boolean ehAposentado) {
        super(nome, idade);
        this.salario = salario;
        this.cargo = cargo;
        this.ehAposentado = ehAposentado;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public boolean isEhAposentado() {
        return ehAposentado;
    }
    public void setEhAposentado(boolean ehAposentado) {
        this.ehAposentado = ehAposentado;
    }
    public int categoria(int idade){
        if(idade > 20){
            return 30;
        }
        else{
            return 10;
        }
    }

    public int categoria(){
        return categoria(this.getIdade());
    }
}
