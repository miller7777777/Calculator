import listeners.DigitListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mille_000 on 12.12.2014.
 */
public class Calculator {

    //этот класс будет создавать экземпляр калькулятора и запускать его.


    public void build(){

        JButton[] digitButtons = new JButton[10];
        JButton[] workButtons = new JButton[4];

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
        String[] work = {"/", "X", "-", "+"};



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 300, 300);


//        JButton button1 = new JButton("1");
//        digitPanel.add(button1);

        indikator = new JTextArea(1, 16);
        Font font = new Font("Arial", Font.BOLD, 20);
        indikator.setFont(font);

        indikator.setText("0");



        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(keyValue[i]);
            digitButtons[i].addActionListener(new DigitListener(digitButtons, indikator, i, keyValue));
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
            workButtons[i] = new JButton(work[i]);
            workPanel.add(workButtons[i]);
            workButtons[i].setBackground(Color.green);
            workButtons[i].setFont(font);

        }




        JPanel indicatorPanel = new JPanel();
        indicatorPanel.add(indikator);

        clearButton = new JButton("C");
        clearButton.setFont(font);
        clearButton.setBackground(Color.gray);
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

    public static void main(String[] args) {
      new Calculator().build();

    }


    }

