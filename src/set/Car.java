package set;

import java.awt.*;

public abstract class Car extends Vehicle{

    private boolean carInStorage = false;

    public Car(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    public void DriveCarInStorage(){
        carInStorage = true;
    }

    public void DriveCarOutOfStorage(){
        carInStorage = false;
    }

    @Override
    public void move(){
        if(!carInStorage){
            super.move();
        }
        else{
            throw new ArithmeticException("Can't move the car while in storage");
        }
    }

    
    
}