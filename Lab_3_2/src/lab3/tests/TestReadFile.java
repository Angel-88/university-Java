package lab3.tests;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class TestReadFile {
    public static void main(String[] args) {

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
        BufferedReader reader = null;
        if (f != null) {
            try {
                reader = new BufferedReader(new FileReader(f));
                String s;
                while ((s = reader.readLine()) != null) {
                    System.out.println(s);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
