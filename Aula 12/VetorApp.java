import javax.swing.*;
import java.util.Arrays; 

public class VetorApp extends JFrame { // define a classe principal como uma janela Swing

    private double[] vetor; // armazena os valores numéricos do vetor

    public VetorApp() { // construtor que inicializa a interface
        super("Aplicativo Vetor e Estatística"); // define o título da janela

        setSize(600, 400); // define o tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // fecha o programa ao fechar a janela
        setLocationRelativeTo(null); // centraliza a janela na tela

        JMenuBar barra = new JMenuBar(); // cria a barra de menus principal

        // VETOR
        JMenu menuVetor = new JMenu("Vetor"); // cria menu de vetor
        JMenuItem itemDimensiona = new JMenuItem("Dimensiona"); // item para dimensionar o vetor
        JMenuItem itemDigita = new JMenuItem("Digita"); // item para digitar valores no vetor
        JMenuItem itemApresenta = new JMenuItem("Apresenta"); // item para apresentar o vetor

        itemDimensiona.addActionListener(e -> dimensiona()); // associa ação ao item dimensionar
        itemDigita.addActionListener(e -> digita()); // associa ação ao item digitar
        itemApresenta.addActionListener(e -> apresenta()); // associa ação ao item apresentar

        menuVetor.add(itemDimensiona); // adiciona item ao menu vetor
        menuVetor.add(itemDigita); // adiciona item ao menu vetor
        menuVetor.add(itemApresenta); // adiciona item ao menu vetor

        // PROBEST
        JMenu menuProbest = new JMenu("PROBEST"); // cria menu de estatística
        JMenuItem media = new JMenuItem("Média"); // item para média
        JMenuItem desvio = new JMenuItem("Desvio Padrão"); // item para desvio padrão
        JMenuItem variancia = new JMenuItem("Variância"); // item para variância
        JMenuItem mediana = new JMenuItem("Mediana"); // item para mediana
        JMenuItem assimetria = new JMenuItem("Coef. Assimetria"); // item para coeficiente de assimetria
        JMenuItem variacao = new JMenuItem("Coef. Variação"); // item para coeficiente de variação

        media.addActionListener(e -> mostrar("Média", Estatistica.media(vetor))); // calcula e mostra a média
        desvio.addActionListener(e -> mostrar("Desvio Padrão", Estatistica.desvioPadrao(vetor))); // calcula e mostra o desvio padrão
        variancia.addActionListener(e -> mostrar("Variância", Estatistica.variancia(vetor))); // calcula e mostra a variância
        mediana.addActionListener(e -> mostrar("Mediana", Estatistica.mediana(vetor))); // calcula e mostra a mediana
        assimetria.addActionListener(e -> mostrar("Coef. Assimetria", Estatistica.coefAssimetria(vetor))); // calcula e mostra coeficiente de assimetria
        variacao.addActionListener(e -> mostrar("Coef. Variação", Estatistica.coefVariacao(vetor))); // calcula e mostra coeficiente de variação

        menuProbest.add(media); // adiciona item média ao menu estatística
        menuProbest.add(desvio); // adiciona item desvio ao menu estatística
        menuProbest.add(variancia); // adiciona item variância ao menu estatística
        menuProbest.add(mediana); // adiciona item mediana ao menu estatística
        menuProbest.add(assimetria); // adiciona item assimetria ao menu estatística
        menuProbest.add(variacao); // adiciona item variação ao menu estatística

        // CDI
        JMenu menuCdi = new JMenu("CDI"); // cria menu CDI para funções e derivadas
        JMenuItem funcao = new JMenuItem("Função"); // item para função
        JMenuItem derivada = new JMenuItem("Derivada"); // item para derivada

        funcao.addActionListener(e -> calculaFuncao()); // associa ação ao item função
        derivada.addActionListener(e -> calculaDerivada()); // associa ação ao item derivada

        menuCdi.add(funcao); // adiciona item função ao menu CDI
        menuCdi.add(derivada); // adiciona item derivada ao menu CDI

        // ALGESD
        JMenu menuAlgesd = new JMenu("ALGESD"); // cria menu para algoritmos e estruturas de dados
        JMenu menuOrdenacao = new JMenu("Ordenação"); // cria sub-menu de ordenação
        JMenuItem ordenaTrocas = new JMenuItem("Trocas"); // item para bubble sort
        JMenuItem ordenaSelecao = new JMenuItem("Seleção"); // item para selection sort
        JMenuItem ordenaInsercao = new JMenuItem("Inserção"); // item para insertion sort
        JMenuItem ordenaQuick = new JMenuItem("Quick"); // item para quick sort
        JMenuItem ordenaMerge = new JMenuItem("Merge"); // item para merge sort

        ordenaTrocas.addActionListener(e -> ordenaVetor("Trocas")); // associa bubble sort
        ordenaSelecao.addActionListener(e -> ordenaVetor("Seleção")); // associa selection sort
        ordenaInsercao.addActionListener(e -> ordenaVetor("Inserção")); // associa insertion sort
        ordenaQuick.addActionListener(e -> ordenaVetor("Quick")); // associa quick sort
        ordenaMerge.addActionListener(e -> ordenaVetor("Merge")); // associa merge sort

        menuOrdenacao.add(ordenaTrocas); // adiciona bubble sort ao sub-menu
        menuOrdenacao.add(ordenaSelecao); // adiciona selection sort ao sub-menu
        menuOrdenacao.add(ordenaInsercao); // adiciona insertion sort ao sub-menu
        menuOrdenacao.add(ordenaQuick); // adiciona quick sort ao sub-menu
        menuOrdenacao.add(ordenaMerge); // adiciona merge sort ao sub-menu

        JMenu menuBusca = new JMenu("Busca"); // cria sub-menu de busca
        JMenuItem buscaLinearIterativa = new JMenuItem("Linear Iterativa"); // item para busca linear iterativa
        JMenuItem buscaLinearRecursiva = new JMenuItem("Linear Recursiva"); // item para busca linear recursiva
        JMenuItem buscaBinariaIterativa = new JMenuItem("Binária Iterativa"); // item para busca binária iterativa
        JMenuItem buscaBinariaRecursiva = new JMenuItem("Binária Recursiva"); // item para busca binária recursiva

        buscaLinearIterativa.addActionListener(e -> buscaValor("LinearIterativa")); // associa busca linear iterativa
        buscaLinearRecursiva.addActionListener(e -> buscaValor("LinearRecursiva")); // associa busca linear recursiva
        buscaBinariaIterativa.addActionListener(e -> buscaValor("BinariaIterativa")); // associa busca binária iterativa
        buscaBinariaRecursiva.addActionListener(e -> buscaValor("BinariaRecursiva")); // associa busca binária recursiva

        menuBusca.add(buscaLinearIterativa); // adiciona item busca linear iterativa
        menuBusca.add(buscaLinearRecursiva); // adiciona item busca linear recursiva
        menuBusca.add(buscaBinariaIterativa); // adiciona item busca binária iterativa
        menuBusca.add(buscaBinariaRecursiva); // adiciona item busca binária recursiva

        menuAlgesd.add(menuOrdenacao); // adiciona sub-menu ordenação ao menu ALGESD
        menuAlgesd.add(menuBusca); // adiciona sub-menu busca ao menu ALGESD

        barra.add(menuVetor); // adiciona menu vetor à barra
        barra.add(menuProbest); // adiciona menu estatística à barra
        barra.add(menuCdi); // adiciona menu CDI à barra
        barra.add(menuAlgesd); // adiciona menu ALGESD à barra

        setJMenuBar(barra); // aplica barra de menus na janela

        setVisible(true); // torna a janela visível
    }

    private void dimensiona() { // método para dimensionar o vetor
        try { // tenta ler e validar a entrada do usuário
            int tamanho = Integer.parseInt(JOptionPane.showInputDialog(this, "Tamanho:")); // lê tamanho como inteiro
            if (tamanho <= 0) { // valida tamanho positivo
                throw new NumberFormatException(); // força exceção para tamanho inválido
            }
            vetor = new double[tamanho]; // aloca o vetor com o tamanho informado
            mostrar("Vetor", "Vetor dimensionado com " + tamanho + " posições."); // exibe confirmação
        } catch (Exception e) { // captura erros de entrada
            JOptionPane.showMessageDialog(this, "Valor inválido. Informe um número inteiro positivo."); // alerta o usuário
        }
    }

    private void digita() { // método para preencher o vetor com valores
        if (!validaVetor()) { // verifica se o vetor foi dimensionado
            return; // sai se vetor não estiver válido
        }

        for (int i = 0; i < vetor.length; i++) { // percorre cada posição do vetor
            try { // tenta converter a entrada para número
                vetor[i] = Double.parseDouble(JOptionPane.showInputDialog(this, "Elemento " + (i + 1) + ":")); // armazena valor no vetor
            } catch (Exception e) { // trata entrada inválida
                JOptionPane.showMessageDialog(this, "Valor inválido. Digitação interrompida."); // avisa sobre a interrupção
                return; // interrompe a digitação
            }
        }
    }

    private void apresenta() { // método para mostrar os valores do vetor
        if (!validaVetor()) { // valida se vetor existe e tem elementos
            return; // sai se não estiver válido
        }

        StringBuilder texto = new StringBuilder(); // constrói texto com conteúdo do vetor
        for (int i = 0; i < vetor.length; i++) { // percorre cada elemento
            texto.append("[").append(i).append("] = ").append(vetor[i]).append("\n"); // adiciona linha para cada elemento
        }
        mostrar("Vetor", texto.toString()); // exibe vetor em diálogo
    }

    private void calculaFuncao() { // método para calcular valor de função polinomial
        if (!validaVetor()) { // valida vetor de coeficientes
            return; // sai se inválido
        }
        Double x = solicitaDouble("Valor de x para avaliar a função polinomial:"); // lê valor de x
        if (x == null) { // verifica entrada válida
            return; // sai se usuário cancelou ou digitou inválido
        }
        double resultado = Estatistica.funcao(vetor, x); // calcula resultado da função
        mostrar("Função", String.format("f(%.4f) = %.4f", x, resultado)); // exibe resultado formatado
    }

    private void calculaDerivada() { // método para calcular derivada da função polinomial
        if (!validaVetor()) { // valida vetor de coeficientes
            return; // sai se inválido
        }
        Double x = solicitaDouble("Valor de x para avaliar a derivada da função polinomial:"); // lê valor de x
        if (x == null) { // verifica entrada válida
            return; // sai se inválido
        }
        double resultado = Estatistica.derivada(vetor, x); // calcula derivada no ponto x
        mostrar("Derivada", String.format("f'(%.4f) = %.4f", x, resultado)); // exibe resultado
    }

    private void ordenaVetor(String algoritmo) { // método para ordenar o vetor usando o algoritmo escolhido
        if (!validaVetor()) { // valida vetor antes de ordenar
            return; // sai se inválido
        }
        switch (algoritmo) { // escolhe algoritmo de ordenação
            case "Trocas": // caso bubble sort
                Ordenacao.bubble(vetor); // ordena com bubble sort
                break;
            case "Seleção": // caso selection sort
                Ordenacao.selection(vetor); // ordena com selection sort
                break;
            case "Inserção": // caso insertion sort
                Ordenacao.insertion(vetor); // ordena com insertion sort
                break;
            case "Quick": // caso quick sort
                Ordenacao.quick(vetor); // ordena com quick sort
                break;
            case "Merge": // caso merge sort
                Ordenacao.merge(vetor); // ordena com merge sort
                break;
            default: // caso inválido
                return; // sai sem fazer nada
        }
        mostrar("Ordenação", "Vetor ordenado usando " + algoritmo + ".\n" + vetorParaTexto(vetor)); // exibe vetor ordenado
    }

    private void buscaValor(String tipoBusca) { // método para executar busca no vetor
        if (!validaVetor()) { // valida vetor previamente
            return; // sai se inválido
        }
        Double chave = solicitaDouble("Valor chave para a busca:"); // lê chave a buscar
        if (chave == null) { // verifica validade da entrada
            return; // sai se inválido
        }

        if (tipoBusca.startsWith("Binaria") && !Ordenacao.isSorted(vetor)) { // se busca binária e vetor não ordenado
            if (!solicitaOrdenacaoParaBusca()) { // solicita ordenação antes da busca
                return; // sai se usuário cancelar
            }
        }

        int indice; // armazena índice encontrado
        switch (tipoBusca) { // escolhe método de busca
            case "LinearIterativa": // busca linear iterativa
                indice = Busca.linear(vetor, chave);
                break;
            case "LinearRecursiva": // busca linear recursiva
                indice = Busca.linearRecursiva(vetor, chave, 0);
                break;
            case "BinariaIterativa": // busca binária iterativa
                indice = Busca.binariaIterativa(vetor, chave);
                break;
            case "BinariaRecursiva": // busca binária recursiva
                indice = Busca.binariaRecursiva(vetor, chave, 0, vetor.length - 1);
                break;
            default: // caso inválido
                return; // sai sem fazer nada
        }
        String mensagem = (indice >= 0)
                ? "Valor encontrado no índice " + indice + "." // mensagem de sucesso
                : "Valor não encontrado."; // mensagem de fracasso
        mostrar("Busca", mensagem + "\n" + vetorParaTexto(vetor)); // exibe mensagem com o vetor
    }

    private boolean solicitaOrdenacaoParaBusca() { // pede ao usuário algoritmo para ordenar antes de busca binária
        String[] opcoes = {"Trocas", "Seleção", "Inserção", "Quick", "Merge"}; // opções de ordenação
        String escolha = (String) JOptionPane.showInputDialog(this,
                "O vetor deve estar ordenado para busca binária. Escolha o algoritmo de ordenação:",
                "Ordenação prévia", JOptionPane.PLAIN_MESSAGE, null,
                opcoes, opcoes[0]); // exibe diálogo de seleção
        if (escolha == null) { // se o usuário cancelar
            return false; // retorna falso
        }
        ordenaVetor(escolha); // ordena o vetor com a escolha
        return true; // retorna verdadeiro
    }

    private boolean validaVetor() { // valida se o vetor está disponível e possui elementos
        if (vetor == null) { // se vetor não foi dimensionado
            JOptionPane.showMessageDialog(this, "Dimensione primeiro o vetor."); // informa o usuário
            return false; // retorna falso
        }
        if (vetor.length == 0) { // se vetor tem tamanho zero
            JOptionPane.showMessageDialog(this, "O vetor deve ter ao menos uma posição."); // informa o usuário
            return false; // retorna falso
        }
        return true; // retorna verdadeiro se válido
    }

    private Double solicitaDouble(String mensagem) { // lê um valor double do usuário
        try { // tenta converter texto para número
            return Double.parseDouble(JOptionPane.showInputDialog(this, mensagem)); // retorna valor convertido
        } catch (Exception e) { // captura erro de conversão
            JOptionPane.showMessageDialog(this, "Valor inválido."); // exibe alerta
            return null; // retorna nulo em caso de erro
        }
    }

    private String vetorParaTexto(double[] v) { // converte o vetor para uma string formatada
        StringBuilder sb = new StringBuilder("Vetor: "); // inicia construtor de string
        sb.append(Arrays.toString(v)); // adiciona representação do array
        return sb.toString(); // retorna a string completa
    }

    private void mostrar(String titulo, Object valor) { // exibe uma mensagem ao usuário
        JOptionPane.showMessageDialog(this, valor, titulo, JOptionPane.INFORMATION_MESSAGE); // mostra diálogo de informação
    }

    public static void main(String[] args) { // ponto de entrada da aplicação
        SwingUtilities.invokeLater(VetorApp::new); // executa a criação da interface na thread de eventos Swing
    }
} // fim da classe VetorApp
