package set;

import java.awt.*;

public abstract class Vehicle implements Movable {
    
    private double currentSpeed;
    private Color color;
    private final String vehicleType;
    private int x;
    private int y;
    private int dir;


    public Vehicle(String vehicleType, Color color, int x, int y, int dir){
        this.vehicleType = vehicleType;
        this.color = color;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double newCurrentSpeed){
        if (newCurrentSpeed < 0){
            throw new IllegalArgumentException("can't have a negative speed!");
        }else{
            currentSpeed = newCurrentSpeed;
        }
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

    public String getVehicleType(){
        return vehicleType;
    }

    public void move(){
        if (this.dir == 0){
            this.y += Math.round(this.currentSpeed);

        }else if(this.dir == 1){
            this.x += Math.round(this.currentSpeed);

        }else if(this.dir == 2){
            this.y -= Math.round(this.currentSpeed);

        }else if(this.dir == 3){
            this.x -= Math.round(this.currentSpeed);

        }

    }

    public void turnLeft(){
        this.dir -= 1;
        this.dir = this.dir % 4;
        move();

    }

    public void turnRight(){
        this.dir += 1;
        this.dir = this.dir % 4;
        move();

    }

    public void setX(int newXCord){
        this.x = newXCord;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int newYcord){
        this.y = newYcord;
    }

    public int getY(){
        return this.y;
    }

    public int getDir(){
        return dir;
    }

    public void setDir(int newDir){
        dir = newDir;
    }


    public abstract double speedFactor();
    


    public abstract void incrementSpeed(double amount);
        
    

    public abstract void decrementSpeed(double amount);

}