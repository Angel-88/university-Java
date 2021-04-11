package lab5.tests;

import lab5.model.*;
import lab5.store.ProductStore;
import lab5.store.WoodDirectory;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestByConsole {
    private final WoodDirectory woodDirectory = new WoodDirectory();
    private final ProductStore productStore = new ProductStore();
    private static final Scanner scanner = new Scanner(System.in);
    private final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Log.txt"));

    public TestByConsole() throws IOException {
        writeString("Початок програми");
        System.out.println(System.lineSeparator() + "Введіть своє ім'я та прізвище");
        String name = scanner.nextLine();
        writeString(name);
    }

    public static void main(String[] args) {
        try {
            TestByConsole appByConsole = new TestByConsole();
            appByConsole.startApp();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            System.out.println("6 - Зберегти каталог деревини");
            System.out.println("7 - Завантажити каталог деревини");
            System.out.println("8 - Зберегти каталог продукції");
            System.out.println("9 - Завантажити каталог продукції");
            System.out.println("10 - Зберегти каталог продукції до текстового файлу");
            System.out.println("11 - Завершити роботу" + System.lineSeparator());
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
                case 6 -> saveWoodDirectoryToFile();
                case 7 -> loadWoodDirectoryToObject();
                case 8 -> saveProductStoreToFile();
                case 9 -> loadProductStoreToObject();
                case 10 -> saveProductStoreToTxtFile();
                case 11 -> flag = false;
            }
        }
        close();
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
        Wood newWood = new Wood(woodId, woodName, woodDestiny);
        woodDirectory.add(newWood);
        writeString(newWood + " Додано");
    }

    private void createTimber() {
        System.out.println("Введіть id деревини");
        int woodId = scanner.nextInt();
        System.out.println("Введіть довжину бруса (від 0,5 до 6)");
        float timberLength = scanner.nextFloat();
        System.out.println("Введіть висоту бруса (від 0,05 до 0,2)");
        float timberHeight = scanner.nextFloat();
        System.out.println("Введіть ширину бруса (від 0,05 до 0,2)");
        float timberWidth = scanner.nextFloat();
        try {
            Timber newTimber = new Timber(woodDirectory.get(woodId), timberLength, timberHeight, timberWidth);
            productStore.add(newTimber);
            writeString(newTimber + " Додано");
        } catch (Exception e) {
            System.out.println(e.getMessage() + ", введіть коректні дані знов!");
            createTimber();
        }
    }

    private void createCylinder() {
        System.out.println("Введіть будь-ласка id деревини");
        int woodId = scanner.nextInt();
        System.out.println("Введіть довжину циліндричного бруса (від 0,5 до 6)");
        float cylinderLength = scanner.nextFloat();
        System.out.println("Введіть діаметер циліндричного бруса (від 0,05 до 0,2)");
        float cylinderDiameter = scanner.nextFloat();
        try {
            Cylinder newCylinder = new Cylinder(woodDirectory.get(woodId), cylinderLength, cylinderDiameter);
            productStore.add(newCylinder);
            writeString(newCylinder + " Додано");
        } catch (Exception e) {
            System.out.println(e.getMessage() + ", введіть коректні дані знов!");
            createCylinder();
        }
    }

    private void createWaste() {
        System.out.println("Введіть вагу мішка відходів (від 0,020 до 0,100)");
        float wasteWeight = scanner.nextFloat();
        try {
            Waste newWaste = new Waste(wasteWeight);
            productStore.add(newWaste);
            writeString(newWaste + " Додано");
        } catch (Exception e) {
            System.out.println(e.getMessage() + ", введіть коректні дані знов!");
            createWaste();
        }
    }

    private void saveWoodDirectoryToFile() {
        File f = new File("woodDirectory.object");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream((fos));
            oos.writeObject(woodDirectory);
            System.out.println("Каталог деревини збережено");
            writeString(f.getName() + " Збережений");
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveProductStoreToFile() {
        File f = new File("productStore.object");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream((fos));
            oos.writeObject(productStore);
            System.out.println("Каталог продуктів збережено");
            writeString(f.getName() + " Збережений");
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadWoodDirectoryToObject() {
        WoodDirectory woodDirectory = null;
        File f = new File("woodDirectory.object");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            woodDirectory = (WoodDirectory) ois.readObject();
            ois.close();
            writeString(f.getName() + " Завантажений");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Помилки:", JOptionPane.ERROR_MESSAGE);
        }
        if (woodDirectory != null) {
            for (Object w : woodDirectory.getArr())
                System.out.println(w.toString());
        }
    }

    private void loadProductStoreToObject() {
        ProductStore productStore = null;
        File f = new File("productStore.object");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productStore = (ProductStore) ois.readObject();
            ois.close();
            writeString(f.getName() + " Завантажений");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Помилки:", JOptionPane.ERROR_MESSAGE);
        }
        if (productStore != null) {
            for (Object w : productStore.getArr())
                System.out.println(w.toString());
        }
    }

    private void saveProductStoreToTxtFile() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return "файли типу *.txt";
            }

            @Override
            public boolean accept(File f) {
                if (f != null) {
                    return f.isDirectory() || f.toString().endsWith(".txt");
                }
                return false;
            }
        });
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();
        if (f != null) {
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
        }
        try {
            assert f != null;
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(productStore.toString());
            writer.close();
            writeString(f.getName() + " Збережений");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeString(String s) {
        try {
            bufferedWriter.write(getCurrentDateTime() + ": " + s + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Логування.", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getCurrentDateTime() {
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return formatter.format(current);
    }

    public void close() {
        writeString("Завершення програми.");
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Завершення.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
