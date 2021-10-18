package lab5;

public class Thread4 extends Thread implements Runnable{
    InterfaceClothes i;
    int size;
    int value = 0;
    Thread4(InterfaceClothes i) {this.i = i; this.size = i.getSizeLength();}
    public void run(){
        InterfaceClothesSynchronizer sync = new InterfaceClothesSynchronizer(i);
        try {
            for (int i = 0; i < size; i++) {
                sync.write(i);
                value = sync.read();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 4 out");
        return;
    }
}
