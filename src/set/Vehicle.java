package set;

import java.awt.*;

public abstract class Vehicle implements Movable {
    
    private int nrDoors;
    private double enginePower;    
    private double currentSpeed;
    private Color color;
    private String modelName;
    private int x;
    private int y;
    private int direction = 0;
    


    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, int x, int y){
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

    protected int getX(){
        return x;
    }

    protected int getY(){
        return y;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double newCurrentSpeed){
        currentSpeed = newCurrentSpeed;
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