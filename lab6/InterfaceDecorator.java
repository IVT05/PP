package lab6;

import java.util.ArrayList;
import java.util.Iterator;

public class InterfaceDecorator implements MainIterface {
    MainIterface obj;
    InterfaceDecorator(MainIterface o)
    {
        obj = o;
    }

    @Override
    public ArrayList<Integer> getSize() {
        return obj.getSize();
    }

    @Override
    public int getCurrSize(int i) {
        return obj.getCurrSize(i);
    }

    @Override
    public void setSize(ArrayList<Integer> size) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCurrSize(int size, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Integer> iterator() {
        return obj.iterator();
    }

    @Override
    public boolean hasNext() {
        return obj.hasNext();
    }

    @Override
    public Object next() {
        return obj.next();
    }
}
