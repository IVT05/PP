package lab4;

import java.io.*;

public class Clothes4 implements Values4, Serializable{
    int model; //порядковый номер
    String name; //название
    int[] size = new int[3]; //размеры
    String hCode; //хэшкод
    public Clothes4(){ //пустой конструктор
        model = 0;
        name = "default";
        for (int i = 0; i <= size.length-1; i++){
            size[i] = 0;
        }
        System.out.println("created default");
    }
    public Clothes4(InputStream in){  //десериализация?
        try {
            String buffer = "";
            int values;
            while ((values = in.read()) != -1)
                buffer += (char)values;
            System.out.println(buffer);
            String[] subStr;
            String del = " ";
            subStr = buffer.split(del);
            name = subStr[1];
            model = Integer.parseInt(subStr[2]);
            for (int i = 0; i < size.length; i++){
                size[i] = Integer.parseInt(subStr[i+2]);
            }
            System.out.println("Created new Clothes - " + this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Clothes4(int model, String name, int[] size){ //конструктор с параметрами
        if (size.length > 3) {throw new RuntimeException("Out of array");} //выброс исключения
        else {
            this.model = model;
            this.name = name;
            for (int i = 0; i <= size.length-1;i++)
                this.size[i] = size[i];
            System.out.println("created with params");
        }
    }
    public void getArgs(int number){ // вывод одного размера
        System.out.println(this.size[number]);
    }
    public void getName() { //вывод названия
        System.out.println(this.name);
    }
    public void getNumber(){ //вывод номера модели
        System.out.println(this.model);
    }
    public void getArgs(){ //вывод всех размеров
        for (int i = 0; i <= this.size.length-1;i++)
            System.out.print(this.size[i]+" ");
        System.out.println("");
    }
    public void changeSize(char op, int value) throws WrongChar { //изменение размера
        if (op == '+') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]+=value; System.out.print(this.size[i] + " ");}
        if (op == '-') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]-=value; System.out.print(this.size[i] + " ");}
        if (op != '+' && op != '-') throw new WrongChar("Wrong Char");
        System.out.println();
    }
    public String toString(){
        return "C " + name + " " + model + " " + size[0] + " " + size[1]+ " " + size[2] + "\n";
    }
    public boolean equals(Clothes4 obj){
        return (this.name == obj.name && this.size[0] == obj.size[0] && this.size[1] == obj.size[1] && this.size[2] == obj.size[2]&& this.model == obj.model);
    }
    public int hashCode(){
        String temp = this.toString();
        byte[] byteArray = temp.getBytes();
        String temp1 = "";
        for (int i =0; i <= 4;i++) temp1 += byteArray[i];
        this.hCode = temp1;
        int hCode = Integer.valueOf(temp1);
        return hCode;
    }
    public boolean returnFunc() {
        if (this.name == "default") return true; else return false;
    }
    public void output(OutputStream out) {//запись байтовый поток
        byte[] clothBuffer = this.toString().getBytes();
        try {
            out.write(clothBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void write(Writer out) {//запись символьный поток
        try {
            out.write(this.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
