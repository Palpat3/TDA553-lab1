import java.awt.*;

public abstract class Vehicle {
    
    public double currentSpeed;
    public Color color;
    public String vehicleType;
    public int x;
    public int y;


    public Vehicle(String vehicleType, Color color, int x, int y){
        this.vehicleType = vehicleType;
        this.color = color;
        this.x = x;
        this.y = y;

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

    public void setX(int NewX){
        this.x = NewX;
    }
        
    public void setY(int NewY){
        this.y = NewY;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    public abstract double speedFactor();
    


    public abstract void incrementSpeed(double amount);
        
    

    public abstract void decrementSpeed(double amount);
        
    

}

