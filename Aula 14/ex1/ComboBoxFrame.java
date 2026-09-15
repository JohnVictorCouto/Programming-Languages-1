// Usando uma JComboBox para selecionar uma imagem a ser mostrada.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame
{ 
    private JComboBox imagesJComboBox; // combobox para armazenar os nomes dos icones
    private JLabel label; // label para mostrar icone selecionado
    private String names[] = { "GIFS/bug1.gif", "GIFS/bug2.gif", "GIFS/travelbug.gif", "GIFS/buganim.gif" };
    private Icon icons[] = { 
        new ImageIcon(getClass().getResource(names [ 0 ])),
        new ImageIcon(getClass().getResource(names [ 1 ])),
        new ImageIcon(getClass().getResource(names[2])),
        new ImageIcon(getClass().getResource(names [3]))
    };
    public ComboBoxFrame() 
    {
        super("Testando JComboBox");
        setLayout(new FlowLayout()); // especifica um layout

        imagesJComboBox = new JComboBox<>(names); // Programa JComboBox
        imagesJComboBox.setMaximumRowCount(3); // Mostra 3 linhas

        imagesJComboBox.addItemListener(
            new ItemListener() 
            {
                // Manipula o evento da JComboBox
                public void itemStateChanged(ItemEvent event) 
                {
                    // Determine se o item foi selecionado
                    if (event.getStateChange() == ItemEvent.SELECTED) 
                    {
                        label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                    }
                }
            }
        );

        add(imagesJComboBox); // adiciona o combobox ao JFrame
        label = new JLabel(icons[0]); // apresenta o 1º ícone
        add(label); // adiciona o label ao JFrame
    }
    public static void main(String[] args) {
        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
        comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBoxFrame.setSize(350,150);
        comboBoxFrame.setVisible(true);
    }
}