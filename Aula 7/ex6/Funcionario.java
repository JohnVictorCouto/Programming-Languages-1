public class Funcionario { // Classe Funcionário
    private String nome, cargo; // Atributos privados para armazenar o nome e o cargo do funcionário
    private double salario; // Atributo privado para armazenar o salário do funcionário
    public Funcionario(String nome, String cargo, double salario) { // Construtor para funcionário
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
    public String getNome() { // Método para obter o nome do funcionário
        return nome;
    }
    public String getCargo() { // Método para obter o cargo do funcionário
        return cargo;
    }
    public double getSalario() { // Método para obter o salário do funcionário
        return salario;
    }
    public void setSalario(double salario) { // Método para definir o salário do funcionário
        this.salario = salario;
    }
    public void setCargo(String cargo) { // Método para definir o cargo do funcionário
        this.cargo = cargo;
    }
    public void setNome(String nome) { // Método para definir o nome do funcionário
        this.nome = nome;
    }
    public double salarioAnual() { // Método para calcular o salário anual do funcionário
        return salario * 12;
    }
    public String getdados() { // Método para exibir os dados do funcionário
        return "Nome: " + nome + "\nCargo: " + cargo + "\nSalário Mensal: " + salario + "\nSalário Anual: " + salarioAnual();
    }
}
