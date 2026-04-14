public class Celular{ // Classe Celular
    private String marca, modelo; // Atributos privados para armazenar a marca e o modelo do celular
    private int armazenamento; // Atributo privado para armazenar a capacidade de armazenamento do celular

    public Celular(String marca, String modelo, int armazenamento) { // Construtor da classe Celular
        this.marca = marca; // Inicializa o atributo marca com o valor passado como parâmetro
        this.modelo = modelo; // Inicializa o atributo modelo com o valor passado como parâmetro
        this.armazenamento = armazenamento; // Inicializa o atributo armazenamento com o valor passado como parâmetro
    }

    public String getMarca() { // Método getter para obter a marca do celular
        return marca; // Retorna o valor do atributo marca
    }
    public String getModelo() { // Método getter para obter o modelo do celular
        return modelo; // Retorna o valor do atributo modelo
    }
    public int getArmazenamento() { // Método getter para obter a capacidade de armazenamento do celular
        return armazenamento; // Retorna o valor do atributo armazenamento
    }
    public void setMarca(String marca) { // Método setter para definir a marca do celular
        this.marca = marca; // Define o valor do atributo marca com o valor passado como parâmetro
    }
    public void setModelo(String modelo) { // Método setter para definir o modelo do celular
        this.modelo = modelo; // Define o valor do atributo modelo com o valor passado como parâmetro
    }
    public void setArmazenamento(int armazenamento) { // Método setter para definir a capacidade de armazenamento do celular
        this.armazenamento = armazenamento; // Define o valor do atributo armazenamento com o valor passado como parâmetro
    }
    public String getdados(){ // Método para obter os dados do celular
        return "Marca: " + marca + "\nModelo: " + modelo + "\nArmazenamento: " + armazenamento + "GB"; // Retorna uma string formatada com os dados do celular
    }
}
