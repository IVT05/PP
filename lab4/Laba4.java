package lab4;

import java.io.*;

import static java.lang.System.*;


public class Laba4 {
    static public Values4 dataBase[] = new Values4[100];
    static public OutputStream outBytes; //запись в байтовый поток
    static public byte[] buffer;
    static public InputStream inputBytes; //чтение из байтового потока
    static public Reader reader = null;
    static public Writer writer = null;
    public static void main(String[] args) throws IOException {
        int x;
        char c;
        out.println("1: Create new object default\n2: Create new object\n3: Print all object\n4: Exit");
        x = System.in.read();

        c = (char) x;
        //c = '2';
        switch (c) {
            case '1': {createObj();printAllObj();break;}
            case '2': {createWithParams();printAllObj();break;}
            case '3': {printAllObj();break;}
            case '4': {break;}
            default: {out.println("Wrong char"); break;}
        }
    }

    static public void createObj() {
        outBytes = new ByteArrayOutputStream(); //запись в байтовый поток
        int i = 0;
        /*for (int j = 0; j <= 9; j++){
            if (dataBase[i] == null) {i = j; break;}
        }*/
        dataBase[i] = new Clothes4();
        //dataBase[i+1] = new Materials4();
        //запись в байтовый
        ClassWriter.outputValues(dataBase[i], outBytes);
        //ClassWriter.outputValues(dataBase[i+1], outBytes);

    }
    static public void printAllObj(){
        for (int i = 0; i <= dataBase.length-1;i++) {
            if (dataBase[i] == null) break;
            //чтение байтового
            buffer = outBytes.toString().getBytes();
            inputBytes = new ByteArrayInputStream(buffer);
            dataBase[51] = ClassWriter.inputValues(inputBytes);
            //чтение символьного


        }
    }
    static public void createWithParams(){
        reader = new InputStreamReader(System.in); //запись в символьный поток
        //запись в символьный
        dataBase[20] = ClassWriter.readValues(reader);
    }
}
