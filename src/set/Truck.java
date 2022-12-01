package set;

import java.awt.*;

public abstract class Truck extends Vehicle {

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }
}
