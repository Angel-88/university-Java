package lab1.tests;

import lab1.model.Timber;
import lab1.store.ProductStore;
import lab1.store.WoodDirectory;

public class TestApp {
    WoodDirectory wd = new WoodDirectory();
    ProductStore ps = new ProductStore();

    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.startApp();
    }

    private void startApp() {
        ps.add(new Timber(wd.get(1), 5f, 0.5f, 0.4f));
        ps.add(new Timber(wd.get(2), 10f, 0.5f, 0.4f));
        ps.add(new Timber(wd.get(3), 10f, 0.5f, 0.4f));
        System.out.println(wd);
        System.out.println(ps);

        System.out.printf("Загальна вага: %1.3f", ps.calcWeight());
    }
}
