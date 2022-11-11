import java.awt.*;

public abstract class Vehicle {
    
    public double currentSpeed;
    public Color color;
    public String vehicleType;


    public Vehicle(String vehicleType, Color color){
        this.vehicleType = vehicleType;
        this.color = color;

    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startVehicle(){
	    currentSpeed = 0.1;
    }

    public void stopVehicle(){
	    currentSpeed = 0;
    }

    
    public abstract double speedFactor();
    


    public abstract void incrementSpeed(double amount);
        
    

    public abstract void decrementSpeed(double amount);
        
    

}
