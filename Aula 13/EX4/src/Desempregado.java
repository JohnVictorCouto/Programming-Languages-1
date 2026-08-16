/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 24.00115-5
 */
public class Desempregado extends PessoaFisica {
    private double seguroDesemprego;

    // Construtor sem parâmetros
    public Desempregado() {
        super();
        this.seguroDesemprego = 0.0;
    }

    // Construtor com parâmetros
    public Desempregado(String nome, String sobrenome, String cpf, double seguroDesemprego) {
        super(nome, sobrenome, cpf);
        this.seguroDesemprego = seguroDesemprego;
    }

    // Getter e Setter
    public double getSeguroDesemprego() {
        return seguroDesemprego;
    }

    public void setSeguroDesemprego(double seguroDesemprego) {
        this.seguroDesemprego = seguroDesemprego;
    }

    // Sobrescrita do método dados()
    @Override
    public String dados() {
        return super.dados() +
               "\nSeguro Desemprego: R$ " + seguroDesemprego;
    }
}