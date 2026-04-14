public class Carro { //A classe Carro 
    private String marca, modelo; //Atributos privados para a marca e o modelo do carro
    private int ano; //Atributo privado para o ano do carro

    public Carro(String marca, String modelo, int ano) { //Construtor da classe Carro
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    public String getMarca() { //Método para obter a marca do carro
        return marca;
    }
    public String getModelo() { //Método para obter o modelo do carro
        return modelo;
    }
    public int getAno() { //Método para obter o ano do carro
        return ano;
    }
    public String setMarca(String marca) { //Método para definir a marca do carro
        this.marca = marca;
        return marca;
    }
    public String setModelo(String modelo) { //Método para definir o modelo do carro
        this.modelo = modelo;
        return modelo;
    }
    public int setAno(int ano) { //Método para definir o ano do carro
        this.ano = ano;
        return ano;
    }
}