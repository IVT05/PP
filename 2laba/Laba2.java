import java.text.DecimalFormat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Laba2 {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static void main(String[] v1) {
        Scanner vvod = new Scanner(System.in);
        Vector vek1 = new Vector("vek1", 1, 2, 3, 4);
        Vector vek2 = new Vector("vek2", 4, 0, 3, 2);
        vek1.printVek();
        vek2.printVek();
        vek1.getvLenght();
        vek2.getvLenght();
        int minV = Vector.minVek(vek1, vek2);
        System.out.println("min = " + minV);
        int maxV = Vector.maxVek(vek1, vek2);
        System.out.println("max = " + maxV);
        vek1.sortVoz();
        vek2.sortVoz();
        System.out.println("\n4islo");
        int zhislo = vvod.nextInt();
        vek1.vekMul(zhislo);
        vek2.vekMul(zhislo);
        Vector vek3 = vek1.add(vek2);
        System.out.println("vek3 ["+vek3.x+", "+vek3.y+"]");
        int scalar = Vector.scalar(vek1, vek2);
        System.out.println("Scalar = "+scalar);
        double evkld = vek1.evclid();
        System.out.println("Evklid Vek1 = "+df2.format(evkld));
    }
}

class Vector {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    String name;
    int x1;
    int x2;
    int y1;
    int y2;
    int x;
    int y;

    Vector(String name, int x1, int y1, int x2, int y2)
    {
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x = x2-x1;
        this.y = y2-y1;
    }
    Vector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    void printVek()
    {
        System.out.println(this.name + " ["+this.x1+", "+this.y1+"] ["+this.x2+", "+this.y2+"]");
        System.out.println("Vek coord = ["+this.x+", "+ this.y+"]");
    }
    double vLenght;
    void getvLenght()
    {
        this.vLenght = Math.sqrt((this.x2-this.x1)*(this.x2-this.x1)+(this.y2-this.y1)*(this.y2-this.y1));
        System.out.println(this.name + " dlina = "+df2.format(this.vLenght));
    }
    static int minVek(Vector vek1, Vector vek2)
    {
    return MathOps.Min(MathOps.Min(MathOps.Min(vek1.x1, vek1.x2),MathOps.Min(vek1.y1, vek1.y2)),MathOps.Min(MathOps.Min(vek2.x1, vek2.x2),MathOps.Min(vek2.y1, vek2.y2)));
    }
    static int maxVek(Vector vek1, Vector vek2)
    {
        return MathOps.Max(MathOps.Max(MathOps.Max(vek1.x1, vek1.x2),MathOps.Max(vek1.y1, vek1.y2)),MathOps.Max(MathOps.Max(vek2.x1, vek2.x2),MathOps.Max(vek2.y1, vek2.y2)));
    }
    void sortVoz()
    {
        int[] args = new int[4];
        args[0] = this.x1;
        args[1] = this.x2;
        args[2] = this.y1;
        args[3] = this.y2;
        int temp;
        for (int j = 0; j < args.length-1; j++)
        for (int i = 0; i < args.length-1; i++)
        {
            if (args[i] > args[i+1])
            {
                temp = args[i];
                args[i] = args[i+1];
                args[i+1] = temp;
            }
        }
        System.out.println("Sort voz - "+args[0] + " " + args[1] + " " + args[2] + " "+ args[3]);
    }
    void vekMul(int i)
    {
        int x = (this.x2-this.x1) * i;
        int y = (this.y2 - this.y1) * i;
        System.out.println(this.name + " * "+i + " = [" + x + ", "+ y + "]");
    }
    public Vector add(Vector B)
    {
        int x = this.x2-this.x1 + B.x2 - B.x1;
        int y = this.y2-this.y1 + B.y2 - B.y1;
        return new Vector(x, y);
    }
    static int scalar( Vector a, Vector b)
    {
        return a.x*b.x + a.y*b.y;
    }
    double evclid()
    {
        return Math.sqrt(this.x1*this.x1+this.x2*this.x2+this.y1*this.y1+this.y2*this.y2);
    }
}

class MathOps{
    static int Max(int a, int b)
    {
        if (a > b) return a; else return b;
    }
    static int Min(int a, int b)
    {
        if (a < b) return a;
        else return b;
    }
}