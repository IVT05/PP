package lab4;

import java.io.*;

public class Materials4 implements Values4, Serializable {
    int number;
    int[] size = new int[2];
    String name;
    String hCode;
    public Materials4(){
        this.number = 0;
        this.size[0] = 0;
        this.size[1] = 0;
        this.name = "Default";
        System.out.println("Created default");
    }
    public Materials4(Reader in) {
        try {
            in = new InputStreamReader(System.in);
            String buffer = "";
            int chr;
            int i;
            for (i =0; (chr= in.read())!= '\n'; i++){
                buffer += (char)chr;
            }
            System.out.println(buffer);
            String[] subStr = buffer.split(" ");
            name = subStr[1];
            number = Integer.parseInt(subStr[2]);
            for (int j = 0; j< size.length;j++) size[j] = Integer.parseInt(subStr[j+2]);
            System.out.println("Created new object - " + this.toString());
            in.close();
        } catch (Exception e) {System.out.println(e);}

    }
    public Materials4(int number, String name, int arg1, int arg2){
        this.number = number;
        this.name = name;
        this.size[0] = arg1;
        this.size[1] = arg2;
        System.out.println("Created with params");
    }
    public void getName(){
        System.out.println(name);
    }
    public void getNumber(){
        System.out.println(number);
    }
    public void getArgs(){
        System.out.println(size[0] + " " + size[1]);
    }
    public void changeSize(char op, int value){
        if (op == '+') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]+=value; System.out.print(this.size[i] + " ");}
        if (op == '-') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]-=value; System.out.print(this.size[i] + " ");}
        System.out.println();
    }
    public String toString(){
        return "M " + name + " " + number + " " + size[0] + " " + size[1] + "\n";
    }
    public boolean equals(Materials4 obj){
        return (this.name == obj.name && this.size[0] == obj.size[0] && this.size[1] == obj.size[1] && this.number == obj.number);
    }
    public int hashCode(){
        String temp = this.toString();
        byte[] byteArray = temp.getBytes();
        String temp1 = "";
        for (int i =0; i <= byteArray.length-1;i++) temp1 += byteArray[i];
        this.hCode = temp1;
        return 1234;}
    public boolean returnFunc() {
        if (this.name == "Default") return true; else return false;
    }
    public void output(OutputStream out) { //запись байтовый поток
        byte[] matBuffer = this.toString().getBytes();
        try {
            out.write(matBuffer);
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
