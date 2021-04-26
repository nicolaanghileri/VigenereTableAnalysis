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
import java.util.concurrent.atomic.AtomicBoolean;
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

        getContentPane().setBackground(Color.ORANGE);


        encodeRadio.setBounds(10, 10, 100, 30);
        decodeRadio.setBounds(10, 30, 100, 30);

        ButtonGroup group = new ButtonGroup();

        group.add(encodeRadio);
        group.add(decodeRadio);

        JLabel keyLabel = new JLabel("Inserire la chiave");
        keyLabel.setBounds(10, 70, 250, 30);

        JTextField keyField = new JTextField();
        keyField.setBounds(10, 100, 200, 30);

        JLabel textLabel = new JLabel("Inserire il testo");
        textLabel.setBounds(10, 140, 250, 30);

        JTextField textField = new JTextField();
        textField.setBounds(10, 170, 200, 30);

        JLabel outLabel = new JLabel("OUTPUT");
        outLabel.setBounds(10, 210, 250, 30);

        JTextField outField = new JTextField();
        outField.setBounds(10, 240, 200, 30);

        
        AtomicBoolean type = new AtomicBoolean(false);

        encodeRadio.addActionListener(e -> {
            type.set(false);
            System.out.println("Hai selezionato encoding");
        });

        decodeRadio.addActionListener(e -> {
            type.set(true);
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
                if(!type.get()){
                    vg.setkey(keyField.getText());
                    outField.setText(vg.getCypherChars());
                }else{
                    vg.setkey(keyField.getText());
                    //textField.setText(vg.getClearChars(outField.getText()));
                }
                
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
                if(!type.get()){//SE ENCODE
                    vg.setText(textField.getText());
                    outField.setText(vg.getCypherChars());
                }
            }
        });


        outField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) { update(); }

            @Override
            public void removeUpdate(DocumentEvent e) { update(); }

            @Override
            public void changedUpdate(DocumentEvent e) {}

            public void update() {
                if(type.get()){//SE DECODE
                    
                    textField.setText(vg.getClearChars(outField.getText()));
                    
                }
            }
        });


        add(encodeRadio);
        add(decodeRadio);
        add(keyLabel);
        add(keyField);
        add(textLabel);
        add(textField);
        add(outField);
        add(outLabel);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }
}
