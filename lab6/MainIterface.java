package lab6;

import java.util.ArrayList;
import java.util.Iterator;

public interface MainIterface extends Iterator {
    public ArrayList<Integer> getSize();
    public int getCurrSize(int i);
    public void setSize(ArrayList<Integer> size);
    public void setCurrSize(int size, int i);
    public Iterator<Integer> iterator();
}
