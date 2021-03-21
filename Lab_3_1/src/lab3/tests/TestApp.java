package lab3.tests;

import lab3.model.*;
import lab3.store.ProductStore;
import lab3.store.WoodDirectory;

public class TestApp {
    WoodDirectory woodDirectory = new WoodDirectory();
    ProductStore productStore = new ProductStore();

    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.startApp();
    }

    private void startApp() {
        woodDirectory.add(new Wood(1, "Модрина", 1.1f));
        woodDirectory.add(new Wood(2, "Ялина", 0.9f));
        woodDirectory.add(new Wood(3, "Сосна", 0.7f));
        productStore.add(new Timber(woodDirectory.get(1), 5f, 0.5f, 0.4f));
        productStore.add(new Timber(woodDirectory.get(2), 10f, 0.5f, 0.4f));
        productStore.add(new Timber(woodDirectory.get(3), 10f, 0.5f, 0.4f));
        productStore.add(new Cylinder(woodDirectory.get(3), 10f, 0.5f));
        productStore.add(new Cylinder(woodDirectory.get(2), 15f, 0.7f));
        productStore.add(new Waste(10f));
        productStore.add(new Waste(7f));
        System.out.println(woodDirectory);
        System.out.println(productStore);


        System.out.printf("Загальна вага: %1.3f", calcWeight());
    }

    private float calcWeight() {
        float fullWeight = 0;
        for (Object timber : productStore.getArr()) {
            fullWeight += ((IWeight) timber).weight();
        }
        return fullWeight;
    }
}
