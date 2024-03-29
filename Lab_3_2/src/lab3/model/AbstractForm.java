package lab3.model;

import java.io.Serializable;

public abstract class AbstractForm implements IWeight, Serializable {
    protected Wood wood;

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    public Wood getWood() {
        return wood;
    }

    @Override
    public float weight() {
        return wood.getDensity() * volume();
    }

    public abstract float volume();
}
