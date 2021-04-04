package lab4.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class AbstractStore<T> implements Serializable, Iterable<Object> {
    protected final ArrayList<Object> arr = new ArrayList<>();

    public ArrayList<Object> getArr() {
        return arr;
    }

    protected void add(Object newProduct) {
        arr.add(newProduct);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this)
            sb.append(obj).append("\n");

        return sb.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new StoreIterator();
    }


    private class StoreIterator implements Iterator<Object> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < arr.size();
        }

        @Override
        public Object next() {
            return arr.get(current++);
        }

        @Override
        public void remove() {
            arr.remove(current - 1);
        }
    }
}


