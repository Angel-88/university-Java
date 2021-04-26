package lab4.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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

    public ListIterator<Object> listIterator() {
        return new StoreListIterator();
    }

    private class StoreListIterator extends StoreIterator implements ListIterator<Object> {
        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public Object previous() {
            return arr.get(current - 1);
        }

        @Override
        public int nextIndex() {
            return current + 1;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        @Override
        public void set(Object o) {
            arr.set(current, o);
        }

        @Override
        public void add(Object o) {
            arr.add(current, o);
            current++;
        }
    }

//        @Override
//        public boolean hasPrevious() {
//            return current > 0;
//        }
//
//        @Override
//        public Object previous() {
//            return arr.get(current--);
//        }
//
//        @Override
//        public int nextIndex() {
//            return current + 1;
//        }
//
//        @Override
//        public int previousIndex() {
//            return current - 1;
//        }
//
//        @Override
//        public void set(Object o) {
//            arr.set(current, o);
//        }
//
//        @Override
//        public void add(Object o) {
//            arr.add(o);
//        }
//    }

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


