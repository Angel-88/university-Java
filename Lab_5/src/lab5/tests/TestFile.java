package lab5.tests;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TestFile {
    public static void main(String[] args) {
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
            for (int i = 0; i < 10; i++) {
                double x = Math.random();
                String s = String.valueOf(x);
                writer.write(s);
                writer.newLine();
            }
            String name = "Daria ";
            String group = "KN_19";
            writer.write(name + group);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
