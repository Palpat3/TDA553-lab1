package set;

import java.awt.*;

public abstract class Vehicle implements Movable {
    
    private double currentSpeed;
    private Color color;
    private final String vehicleType;
    private int x;
    private int y;
    private int direction;
    


    public Vehicle(String vehicleType, Color color, int x, int y, int direction){
        this.vehicleType = vehicleType;
        this.color = color;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double newCurrentSpeed){
        currentSpeed = newCurrentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected String getVehicleType(){
        return vehicleType;
    }

    protected int getX(){
        return x;
    }

    protected int getY(){
        return y;
    }

    protected int getDirection(){
        return direction;
    }

    protected void startVehicle(){
	    currentSpeed = 0.1;
    }

    protected void stopVehicle(){
	    currentSpeed = 0;
    }

    

    public void move(){
        directionConverter();
        if (direction == 0){
            y += Math.round(this.currentSpeed);
        }
        else if(direction == 1){
            x += Math.round(this.currentSpeed);
        }
        else if(direction == 2){
            y -= Math.round(this.currentSpeed);
        }
        else if(direction == 3){
            x -= Math.round(this.currentSpeed);
        }
    }

    public void turnLeft(){
        direction -= 1;
        move();
    }

    public void turnRight(){
        direction += 1;
        move();
    }

    private void directionConverter(){
        direction = (direction % 4 + 4) % 4;
    }

    protected abstract double speedFactor();
}