import javax.swing.JOptionPane;

public class ex2 {

    double valor;

    public static String textualiza(double valor) {
        //Função Conversora de Valor para String
        int inteiro = (int) valor;
        int dezenas = inteiro / 10;
        int unidades = inteiro % 10;

        String dezenaTexto =
            dezenas == 0 ? "" :
            dezenas == 1 ? "dez" :
            dezenas == 2 ? "vinte" :
            dezenas == 3 ? "trinta" :
            dezenas == 4 ? "quarenta" :
            dezenas == 5 ? "cinquenta" :
            dezenas == 6 ? "sessenta" :
            dezenas == 7 ? "setenta" :
            dezenas == 8 ? "oitenta" :
            dezenas == 9 ? "noventa" : "";

        String unidadeTexto =
            unidades == 0 ? "" :
            unidades == 1 ? "um" :
            unidades == 2 ? "dois" :
            unidades == 3 ? "três" :
            unidades == 4 ? "quatro" :
            unidades == 5 ? "cinco" :
            unidades == 6 ? "seis" :
            unidades == 7 ? "sete" :
            unidades == 8 ? "oito" :
            unidades == 9 ? "nove" : "";

        String resultado =
            dezenas == 0 ? unidadeTexto :
            unidades == 0 ? dezenaTexto :
            dezenaTexto + " e " + unidadeTexto;

        return resultado + " reais";
    }

    public static void main(String[] args) {

        String entrada = JOptionPane.showInputDialog("Digite um valor:");
        double valor = Double.parseDouble(entrada);

        String texto = textualiza(valor);

        JOptionPane.showMessageDialog(null, texto);
    }
}