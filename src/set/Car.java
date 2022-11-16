package set;

import java.awt.*;

public abstract class Car extends Vehicle{
    private final int nrDoors;
    private final double enginePower;
    private final String modelName;

    public Car(int nrDoors, Color color, double enginePower, String modelName, String vehicleType, int x, int y, int dir){

        super(vehicleType, color, x, y, dir);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopVehicle();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public String getModelName(){
        return modelName;
    }
    // TODO fix this method according to lab pm 
    // TODO double check if this is correct
    public void gas(double amount){
        if ((amount > 0) && (amount < 1)){
            incrementSpeed(amount);
        }else{
            throw new IllegalArgumentException("must be a double between 0 and 1");
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if((amount > 0) && (amount < 1)){
            decrementSpeed(amount);
        }else{
            throw new IllegalArgumentException("must be a double between 0 and 1");
        }
    }
    
}