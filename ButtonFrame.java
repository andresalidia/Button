import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * ButtonFrame
 */
public class ButtonFrame extends JFrame {
    private JButton plainJButton; // botão apenas com texto
    private JButton fancyJButton; // botão com ícones

    //buttonFrame adiciona JButtons ao JFrame
    public ButtonFrame()
    {
        super("lesting buttons");
        setLayout(new FlowLayout());//configura o layout de Frame

        plainJButton = new JButton("Plain Button");// botão com texto
        add(plainJButton);// adiciona plianJButton ao JFrame

        Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
        Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
        fancyJButton = new JButton("FrancyButton",bug1);//configura imagem
        fancyJButton.setRolloverIcon(bug2);// configura imagem de rollover
        add(fancyJButton);//adiciona fancyJButton ao JFrame

        //cria novo ButtonHandler para tratamento de evento de Botão
        ButtonHandler handler = new ButtonHandler();
        fancyJButton.addActionListener(handler);
        plainJButton.addActionListener(handler);
    }// fim do construtor ButtonFrame

    //classe interna para tratamento de vento de botão
    private class ButtonHandler implements ActionListener {
        public void actionPerformed (ActionEvent event){
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s", event.getActionCommand()));
        }        
    }
}