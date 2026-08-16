import java.util.Arrays; 

public class Ordenacao { // classe com métodos de ordenação

    public static void bubble(double[] v) { // bubble sort
        if (v == null) { // valida vetor nulo
            return; // sai sem ordenar
        }
        for (int i = 0; i < v.length - 1; i++) { // itera várias vezes
            for (int j = 0; j < v.length - i - 1; j++) { // percorre pares adjacentes
                if (v[j] > v[j + 1]) { // compara pares
                    double aux = v[j]; // guarda valor temporariamente
                    v[j] = v[j + 1]; // troca elementos
                    v[j + 1] = aux; // coloca valor guardado
                }
            }
        }
    }

    public static void selection(double[] v) { // selection sort
        if (v == null) { // valida vetor nulo
            return; // sai sem ordenar
        }
        for (int i = 0; i < v.length; i++) { // percorre posições do vetor
            int menor = i; // assume elemento atual como menor
            for (int j = i + 1; j < v.length; j++) { // busca menor valor à direita
                if (v[j] < v[menor]) { // encontra valor menor
                    menor = j; // atualiza índice do menor
                }
            }
            double aux = v[i]; // guarda valor atual
            v[i] = v[menor]; // coloca menor valor na posição i
            v[menor] = aux; // move valor antigo para posição do menor
        }
    }

    public static void insertion(double[] v) { // insertion sort
        if (v == null) { // valida vetor nulo
            return; // sai sem ordenar
        }
        for (int i = 1; i < v.length; i++) { // percorre elementos a partir do segundo
            double chave = v[i]; // armazena elemento a ser inserido
            int j = i - 1; // começa a comparar com elementos anteriores
            while (j >= 0 && v[j] > chave) { // enquanto houver elementos maiores
                v[j + 1] = v[j]; // move elemento para a direita
                j--; // avança para o elemento anterior
            }
            v[j + 1] = chave; // insere chave na posição correta
        }
    }

    public static void quick(double[] v) { // quick sort público
        if (v == null) { // valida vetor nulo
            return; // sai sem ordenar
        }
        quickSort(v, 0, v.length - 1); // inicia ordenação recursiva
    }

    private static void quickSort(double[] v, int inicio, int fim) { // método recursivo do quick sort
        if (inicio >= fim) { // caso base da recursão
            return; // intervalo vazio ou com um elemento
        }
        int pivotIndex = partition(v, inicio, fim); // particiona intervalo ao redor do pivô
        quickSort(v, inicio, pivotIndex - 1); // ordena parte esquerda
        quickSort(v, pivotIndex + 1, fim); // ordena parte direita
    }

    private static int partition(double[] v, int inicio, int fim) { // particiona o array para quick sort
        double pivot = v[fim]; // escolhe último elemento como pivô
        int i = inicio - 1; // índice do último elemento menor que pivô
        for (int j = inicio; j < fim; j++) { // percorre elementos até o pivô
            if (v[j] <= pivot) { // se elemento menor ou igual ao pivô
                i++; // avança índice menor
                double aux = v[i]; // guarda valor atual
                v[i] = v[j]; // troca para colocar elemento menor à esquerda
                v[j] = aux; // coloca valor guardado na posição j
            }
        }
        double aux = v[i + 1]; // guarda elemento após último menor
        v[i + 1] = v[fim]; // move pivô para sua posição correta
        v[fim] = aux; // coloca valor guardado na posição do pivô
        return i + 1; // retorna índice final do pivô
    }

    public static void merge(double[] v) { // merge sort público
        if (v == null) { // valida vetor nulo
            return; // sai sem ordenar
        }
        mergeSort(v, 0, v.length - 1); // inicia ordenação recursiva
    }

    private static void mergeSort(double[] v, int inicio, int fim) { // método recursivo do merge sort
        if (inicio >= fim) { // caso base da recursão
            return; // intervalo com 0 ou 1 elemento
        }
        int meio = (inicio + fim) / 2; // calcula ponto médio
        mergeSort(v, inicio, meio); // ordena metade esquerda
        mergeSort(v, meio + 1, fim); // ordena metade direita
        merge(v, inicio, meio, fim); // mistura as metades ordenadas
    }

    private static void merge(double[] v, int inicio, int meio, int fim) { // une duas sublistas ordenadas
        double[] esquerda = Arrays.copyOfRange(v, inicio, meio + 1); // copia metade esquerda
        double[] direita = Arrays.copyOfRange(v, meio + 1, fim + 1); // copia metade direita
        int i = 0, j = 0, k = inicio; // índices para esquerda, direita e vetor original
        while (i < esquerda.length && j < direita.length) { // enquanto houver elementos em ambas metades
            if (esquerda[i] <= direita[j]) { // compara elementos das metades
                v[k++] = esquerda[i++]; // insere menor elemento da esquerda
            } else {
                v[k++] = direita[j++]; // insere menor elemento da direita
            }
        }
        while (i < esquerda.length) { // se ainda houver elementos na esquerda
            v[k++] = esquerda[i++]; // copia o restante
        }
        while (j < direita.length) { // se ainda houver elementos na direita
            v[k++] = direita[j++]; // copia o restante
        }
    }

    public static boolean isSorted(double[] v) { // verifica se o vetor está ordenado
        if (v == null || v.length < 2) { // vetor nulo ou com menos de dois elementos
            return true; // considera ordenado
        }
        for (int i = 1; i < v.length; i++) { // percorre do segundo elemento em diante
            if (v[i - 1] > v[i]) { // se encontrar par fora de ordem
                return false; // retorna falso
            }
        }
        return true; // retorna verdadeiro se todos os pares estiverem ordenados
    }
} // fim da classe Ordenacao