public class Busca { // classe que implementa métodos de busca em vetores

    public static int linear(double[] v, double chave) { // busca linear iterativa
        if (v == null) { // valida se o vetor existe
            return -1; // retorna -1 para vetor nulo
        }
        for (int i = 0; i < v.length; i++) { // percorre cada elemento
            if (v[i] == chave) { // compara valor atual com a chave
                return i; // retorna índice se encontrado
            }
        }
        return -1; // retorna -1 se não encontrado
    }

    public static int linearRecursiva(double[] v, double chave, int indice) { // busca linear recursiva
        if (v == null || indice >= v.length) { // valida vetor e posição atual
            return -1; // termina recursão com não encontrado
        }
        if (v[indice] == chave) { // compara elemento atual com chave
            return indice; // retorna índice encontrado
        }
        return linearRecursiva(v, chave, indice + 1); // chama função para próximo índice
    }

    public static int binariaIterativa(double[] v, double chave) { // busca binária iterativa
        if (v == null) { // valida vetor nulo
            return -1; // retorna -1 se inválido
        }
        int inicio = 0; // define início do intervalo
        int fim = v.length - 1; // define fim do intervalo
        while (inicio <= fim) { // enquanto existir intervalo
            int meio = (inicio + fim) / 2; // calcula posição do meio
            if (v[meio] == chave) { // verifica se valor do meio é a chave
                return meio; // retorna índice encontrado
            }
            if (v[meio] < chave) { // se valor menor que chave
                inicio = meio + 1; // busca no lado direito
            } else {
                fim = meio - 1; // busca no lado esquerdo
            }
        }
        return -1; // retorna -1 se não encontrado
    }

    public static int binariaRecursiva(double[] v, double chave, int inicio, int fim) { // busca binária recursiva
        if (v == null || inicio > fim) { // valida intervalo e vetor
            return -1; // retorna -1 se intervalo inválido
        }
        int meio = (inicio + fim) / 2; // calcula meio do intervalo
        if (v[meio] == chave) { // verifica se meio é a chave
            return meio; // retorna índice encontrado
        }
        if (v[meio] < chave) { // se meio for menor que a chave
            return binariaRecursiva(v, chave, meio + 1, fim); // continua no lado direito
        }
        return binariaRecursiva(v, chave, inicio, meio - 1); // continua no lado esquerdo
    }
} // fim da classe Busca