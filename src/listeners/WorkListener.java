package listeners;

import com.sun.javafx.css.CalculatedValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mille_000 on 16.12.2014.
 */
public class WorkListener implements ActionListener {

    JButton[] workButtons = new JButton[4];
    JTextArea indikator = new JTextArea("0");
    int i;
    String [] workValue = new String[4];
    Double firstOperand;
    Double secondOperand;
    Double result;
    String operation = "+";
//    boolean flag = false;



    public WorkListener(JButton workButtons[], JTextArea indikator, int i, String workValue[], Double firstOperand, Double secondOperand, Double result, boolean flag){

        this.workButtons = workButtons;
        this.indikator = indikator;
        this.i = i;
        this.workValue = workValue;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.result = result;
//        this.flag = flag;

    }


    @Override
    public void actionPerformed(ActionEvent e) {





        firstOperand = Double.valueOf(indikator.getText());
        indikator.setText(workValue[i]);
        operation = workValue[i];
//        flag = true;




    }




}
