package com;

import com.listeners.ClearListener;
import com.listeners.DigitListener;
import com.listeners.WorkListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mille_000 on 12.12.2014.
 */
public class Calculator {



    //этот класс будет создавать экземпляр калькулятора и запускать его.


    public static void main(String[] args) {
//      new com.Calculator().build();

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
        JFrame frame = new JFrame("com.Calculator");
        frame.setLayout(new BorderLayout());
        JButton clearButton;
        JButton backspaceButton;
        JButton enterButton;
        JButton dotButton;
        JButton changeSignumButton;
        JTextArea indikator;
        JPanel memoryPanel;
        JButton memoryClearButton;
        JButton memoryRemButton;
        JButton memorySetButton;
        JButton memoryPlusButton;
        JButton memoryMinusButton;

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

        memoryPanel = new JPanel(new GridLayout(5, 1));

        memoryClearButton = new JButton();
        setJButton(memoryClearButton, "MC", font, Color.blue, Color.green);

        memoryRemButton = new JButton();
        setJButton(memoryRemButton, "MR", font, Color.blue, Color.green);

        memorySetButton = new JButton();
        setJButton(memorySetButton, "MS", font, Color.blue, Color.green);

        memoryPlusButton = new JButton();
        setJButton(memoryPlusButton, "M+", font, Color.blue, Color.green);

        memoryMinusButton = new JButton();
        setJButton(memoryMinusButton, "M-", font, Color.blue, Color.green);

        memoryPanel.add(memoryClearButton);
        memoryPanel.add(memoryRemButton);
        memoryPanel.add(memorySetButton);
        memoryPanel.add(memoryPlusButton);
        memoryPanel.add(memoryMinusButton);


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
        frame.getContentPane().add(BorderLayout.WEST, memoryPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, controlPanel);
        frame.setVisible(true);

    }

    public void setJButton(JButton button, String s, Font font, Color backgroundColor, Color foregroundcolor){

        button.setText(s);
        button.setBackground(backgroundColor);
        button.setFont(font);
        button.setForeground(foregroundcolor);
    }

    }

