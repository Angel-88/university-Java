package lab4.model;

import java.io.Serializable;

public class Waste implements IWeight, Serializable {

    float weight;

    public Waste(float weight) throws Exception {
        if (weight < 0.020 || weight > 0.100)
            throw new Exception("Вага відходів - " + weight  + " не допустима!\n" +
                    "Допускається від 0.020 до 0.100");
        this.weight = weight;
    }

    @Override
    public float weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }
}
