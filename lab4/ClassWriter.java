package lab4;

import java.io.*;

public class ClassWriter {
    static void outputValues (Values4 o, OutputStream out){ //запись в байтовый поток     ///сериализация?
        o.output(out);
    }
    static Values4 inputValues ( InputStream in){ //чтение байтового потока    ///десереализация?
        return new Clothes4(in);
    }
    static void writeValues (Values4 o, Writer out){ //запись в символьный поток
        o.write(out);
    }
    static Values4 readValues ( Reader in){ //чтение символьного потока
        return new Materials4(in);
    }
    static void serializableValues (Values4 o, OutputStream out){
        o.output(out);
    }
    static Values4 deserializeValues (InputStream in){
        return new Clothes4(in);
    }

}
