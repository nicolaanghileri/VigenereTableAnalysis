import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;

/**
 * 
 * @author nicolaanghileri
 * @version 26.04.2021
 */
public class App extends JFrame {

    public App() {
        super("Vigenere Table");

        JRadioButton encodeRadio = new JRadioButton("Encode");
        JRadioButton decodeRadio = new JRadioButton("Decode");

        encodeRadio.setBounds(10, 10, 100, 30);
        decodeRadio.setBounds(10, 30, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(encodeRadio);
        group.add(decodeRadio);

        JLabel keyLabel = new JLabel("Inserire la chiave");
        keyLabel.setBounds(10, 70, 150, 30);

        JTextField keyField = new JTextField();
        keyField.setBounds(10, 100, 100, 30);

        JLabel textLabel = new JLabel("Inserire il testo");
        textLabel.setBounds(10, 140, 150, 30);

        JTextField textField = new JTextField();
        textField.setBounds(10, 170, 100, 30);

        encodeRadio.addActionListener(e -> {
            System.out.println("Hai selezionato encoding");
        });

        decodeRadio.addActionListener(e -> {
            System.out.println("Hai selezionato decoding");
        });

        Vigenere vg = new Vigenere("","");

        keyField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) { update(); }

            @Override
            public void removeUpdate(DocumentEvent e) { update(); }

            @Override
            public void changedUpdate(DocumentEvent e) {}

            public void update() {
                vg.setkey(keyField.getText());
                System.out.println("Sto cambiando la chiave " + vg.getKey());
            }
            
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) { update(); }

            @Override
            public void removeUpdate(DocumentEvent e) { update(); }

            @Override
            public void changedUpdate(DocumentEvent e) {}

            public void update() {
                
                System.out.println("Sto cambiando il texto sh siiiii");
            }
            
        });

        add(encodeRadio);
        add(decodeRadio);
        add(keyLabel);
        add(keyField);
        add(textLabel);
        add(textField);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    /*public static void main(String[] args) {
        //Frame
        JFrame f = new JFrame("Vigenère Table");
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().setBackground(Color.ORANGE);

        //Icon
        ImageIcon img = new ImageIcon("img.jfif");
        f.setIconImage(img.getImage());
        //Title
        JLabel tit = new JLabel("Tool for coding and decoding of Vigenere tecnique:");
        tit.setHorizontalAlignment(JLabel.CENTER);
        f.getContentPane().add(tit);

        //CheckBoxes
        JCheckBox codeCheck = new JCheckBox("Encode");
        JCheckBox encodeCheck = new JCheckBox("Decode");

        //INPUTS
        JTextField valueField = new JTextField();
        JTextField keyField = new JTextField();
        valueField.setPreferredSize(new Dimension(150,50));
        keyField.setPreferredSize(new Dimension(150,50));
        //valueField.setBounds(50,150, 50, 100);
        //keyField.setBounds(50,150, 50, 100);
        
        //Button
        JButton goButton = new JButton("Encript");
        goButton.setBounds(200,100,100,50);
        f.getContentPane().add(goButton);

        //Add TextBox
        f.getContentPane().add(valueField);
        f.getContentPane().add(keyField);
        //Add Checkbox 
        f.getContentPane().add(codeCheck);
        f.getContentPane().add(encodeCheck);

        //Rende visibile la schermata
        f.setVisible(true);
    }*/
}
