package lab3.store;

import lab3.model.IWeight;

public class ProductStore extends AbstractStore {

    public void add(IWeight newProduct) {
        super.add(newProduct);
    }

    public String toString() {
        return "Вміст сховища продуктів:\n" + super.toString();
    }

}


