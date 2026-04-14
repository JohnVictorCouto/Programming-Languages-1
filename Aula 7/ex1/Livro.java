public class Livro { // Classe Livro
    private String titulo, autor, genero; // Atributos privados para o titulo, autor e genero do livro
    private int numeroPaginas; // Atributo privado para o numero de paginas do livro
    public Livro(String titulo, String autor, int numeroPaginas, String genero) { // Construtor da classe Livro
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }
    public String getTitulo() { // Método para obter o titulo do livro
        return titulo;
    }
    public String getAutor() { // Método para obter o autor do livro
        return autor;
    }
    public int getNumeroPaginas() { // Método para obter o numero de paginas do livro
        return numeroPaginas;
    }
    public String getGenero() { // Método para obter o genero do livro
        return genero;
    }
    public void setTitulo(String titulo) { // Método para definir o titulo do livro
        this.titulo = titulo;
    }
    public void setAutor(String autor) { // Método para definir o autor do livro
        this.autor = autor;
    }
    public void setNumeroPaginas(int numeroPaginas) { // Método para definir o numero de paginas do livro
        this.numeroPaginas = numeroPaginas;
    }
    public void setGenero(String genero) { // Método para definir o genero do livro
        this.genero = genero;
    }

}
