public class Cidade{ //Classe Cidade
    private String nome, estado; //Atributo privado para nome e estado
    private int populacao; //Atributo privado para população
    public Cidade(String nome, String estado, int populacao){ //Construtor para a classe Cidade
        this.nome = nome; //Atribuição do nome
        this.estado = estado; //Atribuição do estado
        this.populacao = populacao; //Atribuição da população
    }
    public String getNome(){ //Método para obter o nome da cidade
        return nome; //Retorna o nome da cidade
    }
    public String getEstado(){ //Método para obter o estado da cidade
        return estado; //Retorna o estado da cidade
    }
    public int getPopulacao(){ //Método para obter a população da cidade
        return populacao; //Retorna a população da cidade
    }
    public void setNome(String nome){ //Método para definir o nome da cidade
        this.nome = nome; //Atribuição do nome
    }
    public void setEstado(String estado){ //Método para definir o estado da cidade
        this.estado = estado; //Atribuição do estado
    }
    public void setPopulacao(int populacao){ //Método para definir a população da cidade
        this.populacao = populacao; //Atribuição da população
    }
    public String getdados(){ //Método para obter os dados da cidade
        return "A cidade de " + nome + ", localizada em " + estado + ", possui " + populacao + " habitantes."; //Retorna os dados da cidade
    }
}