interface Operacao {
    int executar(int a, int b);
}
public class ExemploFuncaoAnonima{
    public static void main(String[] args) {
        // Criando uma instância da interface Operacao usando uma função anônima
        Operacao soma = new Operacao() {
            @Override
            public int executar(int a, int b) {
                return a + b;
            }
        };

        // Usando a função anônima para realizar a soma
        int resultadoSoma = soma.executar(5, 3); // resultado é 8
        System.out.println("Resultado da soma (5 + 3): " + resultadoSoma);
    }
}