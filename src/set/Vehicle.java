package set;

import java.awt.*;

public abstract class Vehicle implements Movable {
    
    private int nrDoors;
    private double enginePower;    
    private double currentSpeed;
    private Color color;
    private String modelName;
    private double x;
    private double y;
    private int direction = 1;
    


    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        stopVehicle();  
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected Color getColor(){
        return color;
    }

    protected String getModelName(){
        return modelName;
    }

    protected double getX(){
        return x;
    }

    protected double getY(){
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double newCurrentSpeed){
        if (newCurrentSpeed > enginePower){
            throw new IllegalArgumentException("speed is too high");
        }else if (newCurrentSpeed < 0){
            throw new IllegalArgumentException("Can't have negative speed");  
        }else{
            currentSpeed = newCurrentSpeed; 
        }
    }

    protected int getDirection(){
        return direction;
    }

    public void startVehicle(){
	    currentSpeed = 0.1;
    }

    public void stopVehicle(){
	    currentSpeed = 0;
    }

    public void move(){
        directionConverter();
        if (direction == 0){
            y += this.currentSpeed;
        }
        else if(direction == 1){
            x += this.currentSpeed;
        }
        else if(direction == 2){
            y -= this.currentSpeed;
        }
        else if(direction == 3){
            x -= this.currentSpeed;
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

    protected abstract double speedFactor();
}