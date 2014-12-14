package listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




/**
 * Created by mille_000 on 12.12.2014.
 */
public class DigitListener implements ActionListener{

    JButton digitButtons[] = new JButton[10];
    public JTextArea indikator = new JTextArea();
    int i;
    String keyValue[] = new String[10];


    public DigitListener(JButton digitButtons[], JTextArea indikator, int i, String keyValue[]) {

        this.digitButtons = digitButtons;
        this.indikator = indikator;
        this.i = i;
        this.keyValue = keyValue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {



            indikator.setText(indikator.getText() + keyValue[i]);



    }
}
