package lab7;

import java.awt.*;

public class Main {
    static public MainWindow app;
    public static void main(String[] args) {
        app = new MainWindow();
        app.pack();
        app.getContentPane().setBackground(Color.blue);
        app.setVisible(true);
    }
    public static void setBackgroundColor(String color) {
        if (color == "blue") app.getContentPane().setBackground(Color.blue);
        if (color == "red") app.getContentPane().setBackground(Color.red);
        if (color == "green") app.getContentPane().setBackground(Color.green);
    }
}
