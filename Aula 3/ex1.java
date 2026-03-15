import javax.swing.JOptionPane;

public class ex1 {

    double valor;

    public static String textualiza(double valor) {
        //Função Conversora de Valor para String
        int inteiro = (int) valor;
        int dezenas = inteiro / 10;
        int unidades = inteiro % 10;

        String texto = "";

        switch (dezenas) {
            case 0:
                texto = "";
                break;
            case 1:
                switch (unidades) {
                    case 0: texto = "dez"; break;
                    case 1: texto = "onze"; break;
                    case 2: texto = "doze"; break;
                    case 3: texto = "treze"; break;
                    case 4: texto = "quatorze"; break;
                    case 5: texto = "quinze"; break;
                    case 6: texto = "dezesseis"; break;
                    case 7: texto = "dezessete"; break;
                    case 8: texto = "dezoito"; break;
                    case 9: texto = "dezenove"; break;
                }
                return texto + " reais";
            case 2: texto = "vinte"; break;
            case 3: texto = "trinta"; break;
            case 4: texto = "quarenta"; break;
            case 5: texto = "cinquenta"; break;
            case 6: texto = "sessenta"; break;
            case 7: texto = "setenta"; break;
            case 8: texto = "oitenta"; break;
            case 9: texto = "noventa"; break;
        }

        if (dezenas > 1 && unidades > 0) {
            texto += " e ";
        }

        switch (unidades) {
            case 1: texto += "um"; break;
            case 2: texto += "dois"; break;
            case 3: texto += "três"; break;
            case 4: texto += "quatro"; break;
            case 5: texto += "cinco"; break;
            case 6: texto += "seis"; break;
            case 7: texto += "sete"; break;
            case 8: texto += "oito"; break;
            case 9: texto += "nove"; break;
        }

        return texto + " reais";
    }

    public static void main(String[] args) {

        String entrada = JOptionPane.showInputDialog("Digite um valor monetário:");
        double valor = Double.parseDouble(entrada);

        String resultado = textualiza(valor);

        JOptionPane.showMessageDialog(null, resultado);
    }
}