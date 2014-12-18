import listeners.ClearListener;
import listeners.DigitListener;
import listeners.WorkListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mille_000 on 12.12.2014.
 */
public class Calculator {



    //этот класс будет создавать экземпляр калькулятора и запускать его.


    public static void main(String[] args) {
//      new Calculator().build();

        Calculator c = new Calculator();
        c.build();

    }




    private void build(){

        JButton[] digitButtons = new JButton[10];
        JButton[] workButtons = new JButton[4];
//        JButton plusButton = new JButton("+");
//        JButton minusButton = new JButton("-");
//        JButton mulButton = new JButton("X");
//        JButton divButton = new JButton("/");
        double firstOperand = 0.;
        double secondOperand = 0.;
        double result = 0.;

//        Collection<T> data = new Collection<T>() {
//        }


        JPanel digitPanel = new JPanel(new GridLayout(4, 3));
        JPanel workPanel = new JPanel(new GridLayout(4, 1));
        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());
        JButton clearButton;
        JButton backspaceButton;
        JButton enterButton;
        JButton dotButton;
        JButton changeSignumButton;
        JTextArea indikator;

        String[] keyValue = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0"};
        String[] workValue = {"/", "X", "-", "+"};

        Boolean flag = false;



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 300, 300);


//        JButton button1 = new JButton("1");
//        digitPanel.add(button1);

        indikator = new JTextArea(1, 16);
        Font font = new Font("Arial", Font.BOLD, 20);
        indikator.setFont(font);

        indikator.setText("");



        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(keyValue[i]);
            digitButtons[i].addActionListener(new DigitListener(digitButtons, indikator, i, keyValue, flag));
            digitButtons[i].setBackground(Color.darkGray);
            digitButtons[i].setForeground(Color.green);
            digitButtons[i].setFont(font);
            digitPanel.add(digitButtons[i]);
        }
        dotButton = new JButton(".");
        dotButton.setFont(font);
        dotButton.setBackground(Color.gray);

        changeSignumButton = new JButton("+/-");
        changeSignumButton.setFont(font);
        changeSignumButton.setBackground(Color.gray);

        digitPanel.add(dotButton);
        digitPanel.add(changeSignumButton);

        for (int i = 0; i < 4; i++) {
            workButtons[i] = new JButton(workValue[i]);
           workButtons[i].addActionListener(new WorkListener(workButtons, indikator, i, workValue, firstOperand, secondOperand, result, flag));
            workPanel.add(workButtons[i]);
            workButtons[i].setBackground(Color.green);
            workButtons[i].setFont(font);

        }

//        workPanel.add()




        JPanel indicatorPanel = new JPanel();
        indicatorPanel.add(indikator);

        clearButton = new JButton("C");
        clearButton.setFont(font);
        clearButton.setBackground(Color.gray);
        clearButton.addActionListener(new ClearListener(this));
        backspaceButton = new JButton("<-");
        backspaceButton.setFont(font);
        backspaceButton.setBackground(Color.gray);
        enterButton = new JButton("=");
        enterButton.setFont(font);
        enterButton.setBackground(Color.gray);


        controlPanel.add(clearButton);
        controlPanel.add(backspaceButton);
        controlPanel.add(enterButton);



        frame.getContentPane().add(BorderLayout.CENTER, digitPanel);
        frame.getContentPane().add(BorderLayout.NORTH, indicatorPanel);
        frame.getContentPane().add(BorderLayout.EAST, workPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, controlPanel);
        frame.setVisible(true);

    }

    }

