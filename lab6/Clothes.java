package lab6;

import java.util.ArrayList;
import java.util.Iterator;

public class Clothes implements MainIterface {
    ArrayList<Integer> size = new ArrayList<Integer>();
    int count = 0;
    int max;
    Clothes() {
        for (int a = 0; a < 10; a++)
        {
            size.add(a*3);
        }
        max = size.size();
    }

    public void setSize(ArrayList<Integer> size) {
        this.size = size;
    }
    public ArrayList<Integer> getSize() {
        return size;
    }
    public int getCurrSize(int i) {
        return size.get(i);
    }
    public void setCurrSize(int size, int i) {
        this.size.set(i, size);
    }
    public Iterator<Integer> iterator() {
        count = 0;
        return LabIterator.iterator(size);
    }

    @Override
    public boolean hasNext() {
       return LabIterator.hasNext();
    }

    @Override
    public Integer next() {
        return LabIterator.next();
    }
}
