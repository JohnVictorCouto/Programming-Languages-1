public class Agencia { // Classe Agencia

    private String nome; // Atributo nome da agência
    private int numero; // Atributo número da agência
    private int digito; // Atributo dígito da agência

    public Agencia(String nome, int numero) { // Construtor da classe Agencia, que recebe o nome e número da agência como parâmetros
        this.nome = nome; // Atribui o valor do nome da agência ao atributo correspondente

        if (numero > 0 && numero <= 9999) { // Verifica se o número da agência é válido (entre 1 e 9999)
            this.numero = numero; // Atribui o valor do número da agência ao atributo correspondente
            this.digito = calcularDigito(numero); // Calcula o dígito da agência usando o método calcularDigito e atribui ao atributo correspondente
        } else { // Se o número da agência for inválido, exibe uma mensagem de erro
            System.out.println("Número da agência inválido!");
        }
    }

    private int calcularDigito(int numero) { // Método para calcular o dígito da agência com base no número da agência

        int d1 = numero / 1000;
        int d2 = (numero / 100) % 10;
        int d3 = (numero / 10) % 10;
        int d4 = numero % 10;

        int soma = d1 * 4 + d2 * 6 + d3 * 8 + d4 * 2;
        int resto = soma % 11;

        return (resto == 10) ? 0 : resto; // Retorna o dígito calculado, se o resto for 10, retorna 0
    }

    public String getNome() { // Método getter para o nome da agência
        return nome; 
    }
    public int getNumero() { // Método getter para o número da agência
        return numero; 
    }
    public int getDigito() { // Método getter para o dígito da agência
        return digito;
     }
    public void setNome(String nome) { // Método setter para o nome da agência, que recebe uma string como parâmetro
        this.nome = nome;
    }
    public void setNumero(int numero) { // Método setter para o número da agência, que recebe um inteiro como parâmetro
        if (numero > 0 && numero <= 9999) { // Verifica se o número da agência é válido (entre 1 e 9999)
            this.numero = numero; // Atribui o valor do número da agência ao atributo correspondente
            this.digito = calcularDigito(numero); // Calcula o dígito da agência usando o método calcularDigito e atribui ao atributo correspondente
        } else { // Se o número da agência for inválido, exibe uma mensagem de erro
            System.out.println("Número da agência inválido!");
        }
    }
}