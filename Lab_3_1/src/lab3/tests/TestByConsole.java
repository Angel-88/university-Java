package lab3.tests;

import lab3.model.*;
import lab3.store.ProductStore;
import lab3.store.WoodDirectory;

import java.util.Scanner;

public class TestByConsole {
    private final WoodDirectory woodDirectory = new WoodDirectory();
    private final ProductStore productStore = new ProductStore();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TestByConsole appByConsole = new TestByConsole();
        appByConsole.startApp();
    }

    private void startApp() {
        boolean flag = true;
        while (flag) {
            System.out.println("=============================================");
            System.out.println("1 - додати деревину");
            System.out.println("2 - додати брус");
            System.out.println("3 - додати циліндричний брус");
            System.out.println("4 - додати мішок з відходами");
            System.out.println("5 - підрахувати загальну вагу");
            System.out.println("6 - Завершити роботу" + System.lineSeparator());
            System.out.println("Введіть номер операції:");
            switch (scanner.nextInt()) {
                case 1 -> {
                    createWood();
                    System.out.println(woodDirectory);
                }
                case 2 -> {
                    createTimber();
                    System.out.println(productStore);
                }
                case 3 -> {
                    createCylinder();
                    System.out.println(productStore);
                }
                case 4 -> {
                    createWaste();
                    System.out.println(productStore);
                }
                case 5 -> System.out.printf("Загальна вага: %1.3f" + System.lineSeparator(), calcWeight());
                case 6 -> flag = false;
            }
        }
    }

    private float calcWeight() {
        float fullWeight = 0;
        for (Object timber : productStore.getArr()) {
            fullWeight += ((IWeight) timber).weight();
        }
        return fullWeight;
    }

    private void createWood() {
        System.out.println(System.lineSeparator() + "Введіть id деревини");
        int woodId = scanner.nextInt();
        System.out.println("Введіть назву деревини");
        String woodName = scanner.next();
        System.out.println("Введіть густину деревини");
        float woodDestiny = scanner.nextFloat();
        woodDirectory.add(new Wood(woodId, woodName, woodDestiny));
    }

    private void createTimber() {
        System.out.println("Введіть id деревини");
        int woodId = scanner.nextInt();
        System.out.println("Введіть довжину бруса");
        float timberLength = scanner.nextFloat();
        System.out.println("Введіть висоту бруса");
        float timberHeight = scanner.nextFloat();
        System.out.println("Введіть ширину бруса");
        float timberWidth = scanner.nextFloat();
        productStore.add(new Timber(woodDirectory.get(woodId), timberLength, timberHeight, timberWidth));
    }

    private void createCylinder() {
        System.out.println("Введіть будь-ласка id деревини");
        int woodId = scanner.nextInt();
        System.out.println("Введіть довжину циліндричного бруса");
        float cylinderLength = scanner.nextFloat();
        System.out.println("Введіть діаметер циліндричного бруса");
        float cylinderDiameter = scanner.nextFloat();
        productStore.add(new Cylinder(woodDirectory.get(woodId), cylinderLength, cylinderDiameter));
    }

    private void createWaste() {
        System.out.println("Введіть вагу мішка відходів");
        float wasteWeight = scanner.nextFloat();
        productStore.add(new Waste(wasteWeight));
    }
}
