package lab3.model;

public class Cylinder extends AbstractForm {
    private float length;
    private float diameter;

    public Cylinder(Wood wood, float length, float diameter) {
        super(wood);
        this.length = length;
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
