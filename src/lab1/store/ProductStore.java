package lab1.store;

import lab1.model.Timber;

import java.util.ArrayList;

public class ProductStore {
    private final ArrayList<Timber> timbersArr = new ArrayList<>();

    public ArrayList<Timber> getTimbersArr() {
        return timbersArr;
    }

    public void add(Timber newTimber) {
        timbersArr.add(newTimber);
    }

    public float calcWeight() {
        float fullWeight = 0;
        for (Timber timber : timbersArr) {
            fullWeight += timber.weight();
        }
        return fullWeight;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог продукції:\n");
        for (Timber timber : timbersArr) {
            sb.append(timber).append("\n");
        }
        return sb.toString();
    }

}


