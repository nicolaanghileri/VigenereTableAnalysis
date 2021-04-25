import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javafx.scene.image.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;


/**
 * 
 */
public class Main extends JFrame {
    static JTextField textfield1, textfield2, textfield3;

    public static void main(String[] args) {
        JFrame f = new JFrame("Encoding/Decoding");
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().setBackground(Color.ORANGE);
        //
        ImageIcon img = new ImageIcon("img.jfif");
        f.setIconImage(img.getImage());
        //
        JLabel tit = new JLabel("Tool for encription and decription of Vigenere tecnique:");
        tit.setHorizontalAlignment(JLabel.CENTER);
        f.getContentPane().add(tit);
        //INPUTS
        JTextField valueField = new JTextField();
        JTextField keyField = new JTextField();
        valueField.setPreferredSize(new Dimension(150,50));
        keyField.setPreferredSize(new Dimension(150,50));
        valueField.setBounds(50,150, 50, 100);
        keyField.setBounds(50,150, 50, 100);
        f.getContentPane().add(valueField);
        f.getContentPane().add(keyField);
        //Button
        JButton goButton = new JButton("Encript");
        goButton.setBounds(200,100,100,50);
        f.getContentPane().add(goButton);

        /*
        textfield1 = new JTextField("Text field 1", 10);
        textfield2 = new JTextField("Text field 2", 10);
        textfield3 = new JTextField("Text field 3", 10);

        f.getContentPane().add(textfield1);
        f.getContentPane().add(textfield2);
        f.getContentPane().add(textfield3);
        */
        f.setVisible(true);
    }
}
