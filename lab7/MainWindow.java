package lab7;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener, KeyListener {
    private JLabel label;
    private JLabel labelMax;
    private JLabel labelMin;
    private JLabel value;
    private static JLabel result;
    private JButton bigger;
    private JButton smaller;
    private JButton isRight;
    private JButton pointed;
    private JTextField maxNumber;
    private JTextField minNumber;
    private JRadioButton radioRed;
    private JRadioButton radioBlue;
    private JRadioButton radioGreen;
    private static JPanel panelMinMax;
    private static JPanel panelBiggerSmaller;
    private static JPanel resultPanel;
    private static JPanel radioPanel;

    public MainWindow() {
        super("Лабораторная работа №7");
        setBounds(100, 100, 400, 300);
        label = new JLabel("Укажите диапазон чисел: ");
        minNumber = new JTextField(2);
        minNumber.addKeyListener(this);
        labelMax = new JLabel("Max");
        labelMin = new JLabel("Min");
        maxNumber = new JTextField(2);
        maxNumber.addKeyListener(this);
        pointed = new JButton("Загадать");
        pointed.setActionCommand("pointed");
        pointed.addActionListener(this);
        panelMinMax = new JPanel();
        panelMinMax.setLayout(new FlowLayout(FlowLayout.LEADING));
        panelMinMax.add(label, BorderLayout.NORTH);
        panelMinMax.add(labelMin);
        panelMinMax.add(minNumber);
        panelMinMax.add(labelMax);
        panelMinMax.add(maxNumber);
        panelMinMax.add(pointed);
        panelMinMax.setAlignmentY(200);
        add(panelMinMax, BorderLayout.PAGE_START);

        value = new JLabel("Число");
        bigger = new JButton("Больше");
        bigger.setActionCommand("bigger");
        bigger.addActionListener(this);
        smaller = new JButton("Меньше");
        smaller.setActionCommand("smaller");
        smaller.addActionListener(this);
        isRight = new JButton("Правильно");
        isRight.setActionCommand("isRight");
        isRight.addActionListener(this);
        panelBiggerSmaller = new JPanel();
        panelBiggerSmaller.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBiggerSmaller.add(smaller);
        panelBiggerSmaller.add(value);
        panelBiggerSmaller.add(bigger);
        panelBiggerSmaller.add(isRight);
        add(panelBiggerSmaller, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.CYAN);

        result = new JLabel("1");
        /*resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.add(result);
        add(resultPanel, BorderLayout.PAGE_END);
        resultPanel.setVisible(true);*/

        radioRed = new JRadioButton("red");
        radioRed.setMnemonic(KeyEvent.VK_B);
        radioRed.setActionCommand("red");
        radioRed.addActionListener(this);
        radioGreen = new JRadioButton("green");
        radioGreen.setMnemonic(KeyEvent.VK_C);
        radioGreen.setActionCommand("green");
        radioGreen.addActionListener(this);
        radioBlue = new JRadioButton("blue");
        radioBlue.setMnemonic(KeyEvent.VK_D);
        radioBlue.setActionCommand("blue");
        radioBlue.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioRed);
        buttonGroup.add(radioGreen);
        buttonGroup.add(radioBlue);
        radioBlue.setVisible(true);
        radioRed.setVisible(true);
        radioGreen.setVisible(true);
        radioPanel = new JPanel();
        radioPanel.add(result);
        radioPanel.add(radioRed);
        radioPanel.add(radioGreen);
        radioPanel.add(radioBlue);
        radioPanel.setVisible(true);
        radioPanel.setAlignmentX(100);
        add(radioPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command)
        {
            case "bigger": {
                Commands.setBigger();
                break;
            }
            case "smaller": {
                Commands.setSmaller();
                break;
            }
            case "isRight": {
                Commands.win();
                break;
            }
            case "pointed": {
                Commands.setMinMax(Integer.parseInt(minNumber.getText()), Integer.parseInt(maxNumber.getText()));
                break;
            }
            case "red": {
                panelBiggerSmaller.setBackground(Color.red);
                panelMinMax.setBackground(Color.red);
                radioPanel.setBackground(Color.red);
                resultPanel.setBackground(Color.red);
                break;
            }
            case "green": {
                panelBiggerSmaller.setBackground(Color.green);
                panelMinMax.setBackground(Color.green);
                radioPanel.setBackground(Color.green);
                resultPanel.setBackground(Color.green);
                break;
            }
            case "blue": {
                panelBiggerSmaller.setBackground(Color.blue);
                panelMinMax.setBackground(Color.blue);
                radioPanel.setBackground(Color.blue);
                resultPanel.setBackground(Color.blue);
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if ((!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void returnedValue(int number) {
       result.setText("Число " + number);
    }
    public static void resultSetText(String message) {
        result.setText(message);
    }
}
