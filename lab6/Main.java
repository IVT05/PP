package lab6;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
    MainIterface clothes = new Clothes();
    MainIterface material = new Materials();
    Iterator<Integer> a, b; //итератор
    a = clothes.iterator();
    System.out.println("Iterator Clothes");
        while (clothes.hasNext())
            System.out.println(clothes.next());
    System.out.println("Iterator Materials");
        b = material.iterator();
        while (material.hasNext())
            System.out.println(material.next());
    System.out.println("Enchanced for");
    a = clothes.iterator();
    for (int i : clothes.getSize())
    {
        System.out.print(clothes.next());
        System.out.print(" ");
    }

    MainInterfaceFactory matfac = new MaterialsFactory();
    MainInterfaceFactory clothfac = new ClothesFactory();
    MainIterface newmat = matfac.createInstance();
    MainIterface newclot = clothfac.createInstance();
    Iterator<Integer> c = newmat.iterator();
    while (newmat.hasNext())
        System.out.println((c.next()));

    }
}
