package lab5;

import java.util.Arrays;

public class Clothes implements InterfaceClothes{
    int model;
    String name;
    int[] size = new int[10];
    Clothes(){
        model = 0;
        name = "default";
        for (int i = 0; i < size.length; i++) size[i] = i;
        System.out.println("Created default - " + this.toString());
    }
    public String toString() {
        String ret = name + " " + model;
        for (int i = 0; i < size.length; i++) ret += " " + size[i];
        return ret;
    }
    public int getModel() {
        return model;
    }

    public String getName() {
        return name;
    }
    public int getSizeLength(){
        return this.size.length;
    }
    public int getSize(int index) {
        return size[index];
    }
    public void setSize(int index, int value)
    {
        this.size[index] = value;
    }
}
