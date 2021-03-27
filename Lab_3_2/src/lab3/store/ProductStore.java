package lab3.store;

import lab3.model.IWeight;

import java.io.Serializable;

public class ProductStore extends AbstractStore<IWeight> {

    public void add(IWeight newProduct) {
        super.add(newProduct);
    }

    public String toString() {
        return "Вміст сховища продуктів:\n" + super.toString();
    }

}


