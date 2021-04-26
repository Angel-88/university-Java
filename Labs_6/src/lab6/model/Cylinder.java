package lab6.model;

public class Cylinder extends AbstractForm {
    private final float length;
    private final float diameter;

    public Cylinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        if (length < 0.5 || length > 6)
            throw new Exception("Довжина циліндричного бруса - " + length  + " не допустима!\n" +
                    "Допускається від 0.5 до 6");
        this.length = length;
        if (diameter < 0.05 || diameter > 0.2)
            throw new Exception("Діаметр циліндричного бруса - " + diameter  + " не допустима!\n" +
                    "Допускається від 0.05 до 0.2");
        this.diameter = diameter;
    }

    public float getLength() {
        return length;
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public float volume() {
        return (float) (Math.PI * Math.pow(diameter / 2, 2) * length);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "wood=" + wood +
                ", length=" + length +
                ", diameter=" + diameter +
                ", weight=" + weight() +
                '}';
    }
}
