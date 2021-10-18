package lab5;

public class InterfaceClothesSynchronizer {
    private InterfaceClothes i;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = false;
    public InterfaceClothesSynchronizer(InterfaceClothes i) {this.i = i;}
    public int read() throws  InterruptedException {
        int val;
        synchronized(lock) {
            if (!canRead()) throw new InterruptedException();
            while (!set)
                lock.wait();
            val = i.getSize(current++);
            System.out.println("Read: " + val);
            set = false;
            lock.notifyAll();
        }
        return val;
    }
    public void write(int val) throws InterruptedException {
        synchronized(lock) {
            if (!canWrite()) throw new InterruptedException();
            while (set)
                lock.wait();
            i.setSize(current, val);
            System.out.println("Write: " + val);
            set = true;
            lock.notifyAll();
        }
    }
    public boolean canRead() {
        return current < i.getSizeLength();
    }
    public boolean canWrite() {
        return (!set && current < i.getSizeLength() || (set && current < i.getSizeLength()-1));
    }
}
