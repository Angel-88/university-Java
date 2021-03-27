package lab3.store;

import java.io.Serializable;
import java.util.ArrayList;

public class AbstractStore<T> implements Serializable {
    protected final ArrayList<Object> arr = new ArrayList<>();

    public ArrayList<Object> getArr() {
        return arr;
    }

    protected void add(Object newProduct) {
        arr.add(newProduct);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object product : arr) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }

}


