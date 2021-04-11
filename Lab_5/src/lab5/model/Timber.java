package lab5.model;

public class Timber extends AbstractForm{
    private final float length;
    private final float height;
    private final float width;

    public Timber(Wood wood, float length, float height, float width) throws Exception {
        super(wood);
        if (length < 0.5 || length > 6)
            throw new Exception("Довжина бруса - " + length + " не допустима!\n" +
                    "Допускається від 0.5 до 6");
        this.length = length;
        if (height < 0.05 || height > 0.2)
            throw new Exception("Висота бруса - " + height + " не допустима!\n" +
                    "Допускається від 0.05 до 0.2");
        this.height = height;
        if (width < 0.05 || width > 0.2)
            throw new Exception("Ширина бруса - " + width  + " не допустима!\n" +
                    "Допускається від 0.05 до 0.2");
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float volume() {
        return length * height * width;
    }

    @Override
    public String toString() {
        return "Timber{" +
                "length=" + length +
                ", height=" + height +
                ", width=" + width +
                ", weight=" + weight() +
                '}';
    }
}
