public class ContaCorrente { // Classe ContaCorrente

    private int numero; // Atributo número da conta
    private int digito; // Atributo dígito da conta
    private double saldo; // Atributo saldo da conta
    private Agencia agencia; // Atributo agência da conta, do tipo Agencia

    public ContaCorrente(int numero, Agencia agencia, double saldo) { // Construtor da classe ContaCorrente, que recebe o número da conta, a agência e o saldo como parâmetros

        if (numero > 0 && numero <= 9999) { // Verifica se o número da conta é válido (entre 1 e 9999)
            this.numero = numero; // Atribui o valor do número da conta ao atributo correspondente
            this.digito = calcularDigito(numero); // Calcula o dígito da conta usando o método calcularDigito e atribui ao atributo correspondente
        } else { // Se o número da conta for inválido, exibe uma mensagem de erro
            System.out.println("Número da conta inválido!");
        }

        this.agencia = agencia; // Atribui a agência da conta ao atributo correspondente
        this.saldo = saldo; // Atribui o valor do saldo da conta ao atributo correspondente
    }

    // Cálculo do dígito (módulo 11)
    private int calcularDigito(int numero) {

        int d1 = numero / 1000;
        int d2 = (numero / 100) % 10;
        int d3 = (numero / 10) % 10;
        int d4 = numero % 10;

        int soma = d1 * 4 + d2 * 6 + d3 * 8 + d4 * 2;
        int resto = soma % 11;

        return (resto == 10) ? 0 : resto;
    }

    public int getNumero() { // Método getter para o número da conta
        return numero;
     }
    public int getDigito() { // Método getter para o dígito da conta
        return digito; 
    }
    public double consultarSaldo() { // Método para consultar o saldo da conta, que retorna o valor do saldo
        return saldo;
    }
    public Agencia getAgencia() { // Método getter para a agência da conta
        return agencia;
     }

    public void setNumero(int numero) { //Método setter para o número da conta, que recebe um inteiro como parâmetro
        this.numero = numero;
     }
    public void setSaldo(double saldo) { // Método setter para o saldo da conta, que recebe um double como parâmetro
        this.saldo = saldo; 
    }
    public void setAgencia(Agencia agencia) { // Método setter para a agência da conta, que recebe uma instância de Agencia como parâmetro
        this.agencia = agencia; 
     }

    public void depositar(double valor) { // Método para depositar um valor na conta, que recebe um double como parâmetro
        if (valor > 0) { // Verifica se o valor do depósito é positivo
            saldo += valor; // Adiciona o valor do depósito ao saldo da conta
        }
    }

    public double sacar(double valor) { // Método para sacar um valor da conta, que recebe um double como parâmetro
        if (valor > saldo) { // Verifica se o valor do saque é maior que o saldo da conta
            System.out.println("Saque não efetuado!"); // Exibe uma mensagem de erro indicando que o saque não foi efetuado devido ao saldo insuficiente 
            return 0; // Retorna 0 para indicar que o saque não foi realizado
        } else {
            saldo -= valor; // Subtrai o valor do saque do saldo da conta
            return valor; // Retorna o valor do saque para indicar que o saque foi realizado com sucesso
        }
    }

    public void imprimirSaldo() { // Método para imprimir o saldo da conta, exibindo o número da conta, agência e saldo
        System.out.println("Conta: " + numero + "-" + digito);
        System.out.println("Agência: " + agencia.getNumero() + "-" + agencia.getDigito());
        System.out.println("Saldo: " + saldo);
    }
}