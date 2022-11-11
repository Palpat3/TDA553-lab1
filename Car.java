import java.awt.*;

public abstract class Car extends Vehicle{
    public int nrDoors;
    public double enginePower;
    public String modelName;

    public Car(int nrDoors, Color color, double enginePower, String modelName, String vehicleType){

        super(vehicleType, color);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.vehicleType = vehicleType;
        stopVehicle();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    
}
