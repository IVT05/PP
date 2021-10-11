package lab4;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public interface Values4 {
    public void getName();
    public void getNumber();
    public void getArgs();
    public void changeSize(char op, int value) throws WrongChar;
    public boolean returnFunc();
    void output(OutputStream out); //запись в байтовый
    void write(Writer out); // запись в символьный
    //String toString();
}
