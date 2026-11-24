package exemple;

public class Retangulo {
    private int base;
    private int altura;

    public Retangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }
    
    public int Area(){
        return base * altura;
    }
    
    public int Perimetro(){
        return 2 * (base + altura);
    }
}
