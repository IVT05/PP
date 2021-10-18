package lab5;

public class Thread2 extends Thread{
    InterfaceClothes obj;
    boolean isAlive;
    Thread2(InterfaceClothes obj){
        this.obj = obj;
        isAlive = true;
    }
    void disable(){
        isAlive = false;
    }
    public void run(){
        int sizeLength = obj.getSizeLength();
        if (isAlive)
        for (int i = 0; i < sizeLength; i++){
            System.out.println("Read: " + obj.getSize(i) + " from position " + i);
        }
        isAlive = false;
        System.out.println("Thread 2 out");
    }
}
