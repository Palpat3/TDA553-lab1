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

    public String getModelName(){
        return modelName;
    }

    @Override
    public void setCurrentSpeed(double newCurrentSpeed){
        if (newCurrentSpeed <= enginePower){
            super.setCurrentSpeed(newCurrentSpeed);
        }else{
            System.out.println("speed is too high");
        }
    }

    public double getEnginePower(){
        return enginePower;
    }
    
    public void gas(double amount){
        if ((amount > 0) && (amount < 1)){
            incrementSpeed(amount);
        }else{
            System.out.println("must be a double between 0.0 and 1.0");
        }
    }

    public void brake(double amount){
        if((amount > 0) && (amount < 1)){
            decrementSpeed(amount);
        }else{
            System.out.println("must be a double between 0 and 1");
        }
    }
} 