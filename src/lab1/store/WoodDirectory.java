package lab1.store;

import lab1.model.Wood;

import java.util.Arrays;

public class WoodDirectory {
    private Wood[] woodsArr = new Wood[3];
    private int count = 0;

    {
        woodsArr[0] = new Wood(1, "Модрина", 1.1f);
        woodsArr[1] = new Wood(2, "Ялина", 0.9f);
        woodsArr[2] = new Wood(3, "Сосна", 0.7f);
        count = 3;
    }

    public Wood[] getWoodsArr() {
        return Arrays.copyOf(woodsArr, count);
    }

    public Wood get(int id) {
        for (int i = 0; i < count; i++) {
            if (woodsArr[i].getId() == id)
                return woodsArr[i];
        }
        return null;
    }

    public boolean add(Wood newWood) {
        if (get(newWood.getId()) != null)
            return false;
        if (woodsArr.length == count)
            woodsArr = Arrays.copyOf(woodsArr, count + count / 2);
        woodsArr[count++] = newWood;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог деревини:\n");
        for (int i = 0; i < count; i++) {
            sb.append(woodsArr[i]).append("\n");
        }
        return sb.toString();
    }
}
