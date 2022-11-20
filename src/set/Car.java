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
    
    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected String getModelName(){
        return modelName;
    }

    @Override
    protected void setCurrentSpeed(double newCurrentSpeed){
        if (newCurrentSpeed > enginePower){
            throw new IllegalArgumentException("speed is too high");
        }else if (newCurrentSpeed < 0){
            throw new IllegalArgumentException("Can't have negative speed");  
        }else{
            super.setCurrentSpeed(newCurrentSpeed); 
        }
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    protected void gas(double amount){
        if ((amount > 0) && (amount < 1)){
            incrementSpeed(amount);
        }
        else{
            throw new IllegalArgumentException("must be a double between 0.0 and 1.0");
        }
    }

    protected void brake(double amount){
        if((amount > 0) && (amount < 1)){
            decrementSpeed(amount);
        }
        else{
            throw new IllegalArgumentException("must be a double between 0 and 1");
        }
    }
} 