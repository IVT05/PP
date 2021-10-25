package lab6;

import java.util.ArrayList;
import java.util.Iterator;

public class LabIterator {
    static Iterator<Integer> iter;
    static int max, count;
    static public Iterator<Integer> iterator(ArrayList<Integer> arr)
    {
        iter = arr.iterator();
        max = arr.size();
        count = 0;
        return arr.iterator();
    }
    static public boolean hasNext() {
        if (count < max) {
            count++;
            return true;
        }
        else
        {
            count = 0;
            return false;
        }
    }

    static public Integer next() {
        return iter.next();
    }
}
