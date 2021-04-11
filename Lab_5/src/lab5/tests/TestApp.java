package lab5.tests;

import lab5.model.*;
import lab5.store.ProductStore;
import lab5.store.WoodDirectory;

import javax.swing.*;
import java.util.Iterator;
import java.util.function.Predicate;

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
        try {
            productStore.add(new Timber(woodDirectory.get(1), 5f, 0.1f, 0.1f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            productStore.add(new Timber(woodDirectory.get(2), 5.5f, 0.15f, 0.17f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            productStore.add(new Timber(woodDirectory.get(3), 4f, 0.15f, 0.15f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            productStore.add(new Cylinder(woodDirectory.get(3), 4.5f, 0.14f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            productStore.add(new Cylinder(woodDirectory.get(2), 5f, 0.1f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            productStore.add(new Waste(0.08f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            productStore.add(new Waste(0.07f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(woodDirectory);
        System.out.println(productStore);


        System.out.println("Загальна вага: %1.3f" + calcWeight() + System.lineSeparator());

        System.out.println("Перелік виробів до вилучення:");
        System.out.println(productStore);
        Iterator<Object> itr = productStore.iterator();
        while (itr.hasNext()) {
            IWeight obj = (IWeight) itr.next();
            if (obj.weight() > 0.1) {
                itr.remove();
            }
        }
        System.out.println("Перелік виробів після вилучення:");
        System.out.println(productStore);

        float maxWeight = 0.07f;
        productStore.remove(t -> t instanceof Waste && ((IWeight) t).weight() > maxWeight);
        productStore.doForAll(System.out::println);
    }

    private float calcWeight() {
        float fullWeight = 0;
        for (Object product : productStore.getArr()) {
            fullWeight += ((IWeight) product).weight();
        }
        return fullWeight;
    }
}
