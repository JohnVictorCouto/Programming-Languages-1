public class Filme { //Classe Filme
    private String titulo, diretor, genero, indicacao; //Atributos privados para armazenar o título, diretor, gênero e indicação do filme
    private int ano; //Atributo privado para ano
    public Filme(String titulo, String diretor, int ano, String genero, String indicacao) { //Construtor do Filme
        this.titulo = titulo;
        this.diretor = diretor;
        this.ano = ano;
        this.indicacao = indicacao;
        this.genero = genero;
    }
    public String getTitulo() { //Método para obter o titulo
        return titulo;
    }
    public String getDiretor() { //Método para obter o diretor
        return diretor;
    }
    public int getAno() { //Método para obter o ano
        return ano;
    }
    public String getGenero() { //Método para obter o genero
        return genero;
    }
    public String getIndicacao() { //Método para obter a indicacao
        return indicacao;
    }
    public void setTitulo(String titulo) { //Método para definir o titulo
        this.titulo = titulo;
    }
    public void setDiretor(String diretor) { //Método para definir o diretor
        this.diretor = diretor;
    }
    public void setAno(int ano) { //Método para definir o ano
        this.ano = ano;
    }
    public void setIndicacao(String indicacao) { //Método para definir a indicacao
        this.indicacao = indicacao;
    }
    public void setGenero(String genero) { //Método para definir o genero
        this.genero = genero;
    }
    public String toString() { //Método para retornar uma representação em string do filme
        return "Título: " + titulo + "\nDiretor: " + diretor + "\nAno: " + ano + "\nGênero: " + genero + "\nIndicação: " + indicacao;
    }
}