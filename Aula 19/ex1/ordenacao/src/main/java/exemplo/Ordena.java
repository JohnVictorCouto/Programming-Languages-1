package exemplo;

public class Ordena {

    public void ordenaNumerosDecrescentes(int[] ivet) {
        // Validação de segurança para vetores nulos ou com apenas 1 elemento
        if (ivet == null || ivet.length <= 1) {
            return;
        }

        // Algoritmo Bubble Sort ajustado para ordem decrescente
        for (int ia = 1; ia < ivet.length; ia++) {
            for (int iB = ivet.length - 1; iB >= ia; iB--) {
                
                // Alterado para '<' (menor que) para empurrar os menores valores para o fim
                if (ivet[iB - 1] < ivet[iB]) {
                    int iT = ivet[iB - 1];
                    ivet[iB - 1] = ivet[iB];
                    ivet[iB] = iT;
                }
            }
        }
    }
}
