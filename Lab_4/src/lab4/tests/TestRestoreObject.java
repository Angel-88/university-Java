package lab4.tests;

import lab4.store.WoodDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestRestoreObject {
    public static void main(String[] args) {
        WoodDirectory woodDirectory = null;
        File f = new File("woodDirectory.object");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            woodDirectory = (WoodDirectory) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (woodDirectory != null) {
            for (Object w : woodDirectory.getArr())
                System.out.println(w.toString());
        }
    }
}
