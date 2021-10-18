package lab5;

public class Thread1 extends Thread{
    InterfaceClothes obj;
    boolean isAlive;
    Thread1(InterfaceClothes obj){
        this.obj = obj;
        isAlive = true;
    }
    void disable(){
        isAlive = false;
    }
    public void run(){
    int sizeLength = obj.getSizeLength();
    int j = 1;
    if (isAlive)
    for (int i = 0; i < sizeLength; i++){
        obj.setSize(i, j);
        j += 5;
        System.out.println("Write: " + j + " to position " + i);
    }
    isAlive = false;
    System.out.println("Thread 1 out");
    }

}
