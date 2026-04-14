public class Animal{ // Classe Animal
    private String nome, especie; // Atributos privados para nome e espécie do animal
    private int idade; // Atributo privado para idade do animal
    public Animal(String nome, String especie, int idade){ // Construtor para inicializar os atributos do animal
        this.nome = nome; // Atribui o valor do nome ao atributo nome
        this.especie = especie; // Atribui o valor da espécie ao atributo especie
        this.idade = idade; // Atribui o valor da idade ao atributo idade
    }
    public String getNome(){ // Método público para obter o nome do animal
        return nome; // Retorna o nome do animal
    }
    public String getEspecie(){ // Método público para obter a espécie do animal
        return especie; // Retorna a espécie do animal
    }
    public int getIdade(){ // Método público para obter a idade do animal
        return idade; // Retorna a idade do animal
    }
    public void setNome(String nome){ // Método público para definir o nome do animal
        this.nome = nome; // Atribui o valor do nome ao atributo nome
    }
    public void setEspecie(String especie){ // Método público para definir a espécie do animal
        this.especie = especie; // Atribui o valor da espécie ao atributo especie
    }
    public void setIdade(int idade){ // Método público para definir a idade do animal
        this.idade = idade; // Atribui o valor da idade ao atributo idade
    }
}