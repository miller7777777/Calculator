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
    Boolean flag = false;


    public DigitListener(JButton digitButtons[], JTextArea indikator, int i, String keyValue[], boolean flag) {

        this.digitButtons = digitButtons;
        this.indikator = indikator;
        this.i = i;
        this.keyValue = keyValue;
//        this.flag = flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        System.out.println(flag);
            cs();


            indikator.setText(indikator.getText() + keyValue[i]);



    }

    public void cs(){
//        if(indikatorField.getText().substring(0, 1).equals("Вы")) cls0();
//        if(indikator.getText().indexOf("Вы") == 0) cls0();
//        if(indikator.getText().indexOf("In") == 0) cls0();
//        if(indikator.getText().indexOf("Na") == 0) cls0();
//        if(indikator.getText().indexOf("00") == 0) cls0();
//        if(indikator.getText().indexOf("00") == 0) cls0();

//        if(indikator.getText().substring(0, 1).equals("In")) cls0();
        if(indikator.getText().substring(0).equals("+")) cls0();
        if(indikator.getText().substring(0).equals("-")) cls0();
        if(indikator.getText().substring(0).equals("X")) cls0();
        if(indikator.getText().substring(0).equals("/")) cls0();
        if(flag) {
            cls0();
            flag = false;
        }
    }

    public void cls0(){

        indikator.setText("");
    }
}
