import java.util.Arrays; 

public class Estatistica { // classe com métodos estatísticos

    public static double media(double[] v) { // calcula média aritmética
        return Arrays.stream(v).average().orElse(0); // retorna média ou 0 se vazio
    }

    public static double variancia(double[] v) { // calcula variância populacional
        if (v == null || v.length == 0) { // valida vetor
            return 0; // retorna 0 para vetor inválido ou vazio
        }
        double media = media(v); // calcula média do vetor
        double soma = 0; // acumula soma dos quadrados das diferenças
        for (double n : v) { // percorre cada valor do vetor
            soma += Math.pow(n - media, 2); // soma quadrado da diferença
        }
        return soma / v.length; // divide pela quantidade de elementos
    }

    public static double desvioPadrao(double[] v) { // calcula desvio padrão
        return Math.sqrt(variancia(v)); // usa a raiz quadrada da variância
    }

    public static double mediana(double[] v) { // calcula a mediana
        if (v == null || v.length == 0) { // valida vetor
            return 0; // retorna 0 para vetor inválido ou vazio
        }
        double[] copia = Arrays.copyOf(v, v.length); // cria cópia para não alterar original
        Arrays.sort(copia); // ordena a cópia
        int meio = copia.length / 2; // calcula índice do meio
        if (copia.length % 2 == 0) { // se quantidade par
            return (copia[meio] + copia[meio - 1]) / 2; // média dos dois valores centrais
        }
        return copia[meio]; // valor central para quantidade ímpar
    }

    public static double coefAssimetria(double[] v) { // calcula coeficiente de assimetria
        if (v == null || v.length == 0) { // valida vetor
            return 0; // retorna 0 para vetor inválido ou vazio
        }
        double media = media(v); // calcula média
        double desvio = desvioPadrao(v); // calcula desvio padrão
        if (desvio == 0) { // evita divisão por zero
            return 0; // retorna 0 se desvio padrão for zero
        }
        double soma = 0; // acumula soma dos cubos das diferenças
        for (double n : v) { // percorre cada elemento
            soma += Math.pow(n - media, 3); // soma cubo da diferença
        }
        return soma / (v.length * Math.pow(desvio, 3)); // normaliza pela quantidade e pelo desvio ao cubo
    }

    public static double coefVariacao(double[] v) { // calcula coeficiente de variação em porcentagem
        if (v == null || v.length == 0) { // valida vetor
            return 0; // retorna 0 para vetor inválido ou vazio
        }
        double media = media(v); // calcula média
        if (media == 0) { // evita divisão por zero
            return 0; // retorna 0 se média for zero
        }
        return (desvioPadrao(v) / Math.abs(media)) * 100; // calcula variação percentual
    }

    public static double funcao(double[] coeficientes, double x) { // avalia polinômio em x
        if (coeficientes == null) { // valida coeficientes
            return 0; // retorna 0 se array nulo
        }
        double resultado = 0; // acumula resultado do polinômio
        for (int i = 0; i < coeficientes.length; i++) { // percorre coeficientes
            resultado += coeficientes[i] * Math.pow(x, i); // soma termo i do polinômio
        }
        return resultado; // retorna valor calculado
    }

    public static double derivada(double[] coeficientes, double x) { // avalia derivada do polinômio em x
        if (coeficientes == null) { // valida coeficientes
            return 0; // retorna 0 se array nulo
        }
        double resultado = 0; // acumula resultado da derivada
        for (int i = 1; i < coeficientes.length; i++) { // percorre coeficientes a partir do termo x^1
            resultado += i * coeficientes[i] * Math.pow(x, i - 1); // soma termo da derivada
        }
        return resultado; // retorna resultado da derivada
    }
} // fim da classe Estatistica