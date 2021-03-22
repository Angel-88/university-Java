package lab3.tests;

import lab3.model.*;
import lab3.store.ProductStore;
import lab3.store.WoodDirectory;

import javax.swing.*;

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
            productStore.add(new Timber(woodDirectory.get(3), 10f, 0.5f, 0.4f));
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
            productStore.add(new Cylinder(woodDirectory.get(2), 15f, 0.7f));
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
            productStore.add(new Waste(7f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(woodDirectory);
        System.out.println(productStore);


        System.out.printf("Загальна вага: %1.3f", calcWeight());
    }

    private float calcWeight() {
        float fullWeight = 0;
        for (Object product : productStore.getArr()) {
            fullWeight += ((IWeight) product).weight();
        }
        return fullWeight;
    }
}
