package ProjetoBatepapo;

import javax.swing.SwingUtilities;

public class SocketClienteGUI
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(
        () -> new BatepapoJanela("SocketCliente - Interface gráfica"));
  }
}
