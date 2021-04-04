package lab4.tests;

import lab4.model.Wood;
import lab4.store.WoodDirectory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestStoreObject {
    public static void main(String[] args) {
        WoodDirectory woodDirectory = new WoodDirectory();
        woodDirectory.add(new Wood(4,"Дуб", 1f));
        File f = new File("woodDirectory.object");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream((fos));
            oos.writeObject(woodDirectory);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
