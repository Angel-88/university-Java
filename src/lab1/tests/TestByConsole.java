package lab1.tests;

import lab1.model.Timber;
import lab1.model.Wood;
import lab1.store.ProductStore;
import lab1.store.WoodDirectory;

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
            System.out.println("3 - підрахувати загальну вагу");
            System.out.println("4 - Завершити роботу" + System.lineSeparator());
            System.out.println("Введіть id операції:");
            switch (scanner.nextInt()) {
                case 1 -> {
                    createWood();
                    System.out.println(woodDirectory);
                }
                case 2 -> {
                    createTimber();
                    System.out.println(productStore);
                }
                case 3 -> System.out.printf("Загальна вага: %1.3f" + System.lineSeparator(), productStore.calcWeight());
                case 4 -> flag = false;
            }
        }
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
        int timberId = scanner.nextInt();
        System.out.println("Введіть довжину бруса");
        float timberLength =scanner.nextFloat();
        System.out.println("Введіть висоту бруса");
        float timberHeight = scanner.nextFloat();
        System.out.println("Введіть ширину бруса");
        float timberWidth = scanner.nextFloat();
        productStore.add(new Timber(woodDirectory.get(timberId), timberLength, timberHeight, timberWidth));
    }
}
