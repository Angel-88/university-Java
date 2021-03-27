package lab2.store;

import lab2.model.Wood;

public class WoodDirectory extends AbstractStore {

    public Wood get(int id) {
        for (Object o : arr) {
            Wood wood = (Wood) o;
            if (wood.getId() == id)
                return wood;
        }
        return null;
    }

    public boolean add(Wood newWood) {
        if (get(newWood.getId()) != null)
            return false;
        super.add(newWood);
        return true;
    }

    public String toString() {
        return "Каталог деревини:\n" + super.toString();
    }
}
