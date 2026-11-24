package ProjetoBatepapo;

import javax.swing.SwingUtilities;

public class ClienteBatepapoGUI
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(
        () -> new BatepapoJanela("ClienteBatepapo - Interface gráfica"));
  }
}
