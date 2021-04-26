package lab6.store;

import lab6.model.IWeight;

public class ProductStore extends AbstractStore<IWeight> {

    public void add(IWeight newProduct) {
        super.add(newProduct);
    }

    public String toString() {
        return "Вміст сховища продуктів:\n" + super.toString();
    }

}


