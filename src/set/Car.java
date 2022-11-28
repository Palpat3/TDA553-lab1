package set;

import java.awt.*;

public abstract class Car extends Vehicle{

    private boolean carOnTruck = false;

    public Car(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    public void GetCarOnTruck(){
        carOnTruck = true;
    }

    public void GetCarOffTruck(){
        carOnTruck = false;
    }

    public boolean isCarOnTruck() {
        return carOnTruck;
    }
    
} 