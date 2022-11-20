package set;

import java.awt.*;

public abstract class Vehicle implements Movable {
    
    private double currentSpeed;
    private Color color;
    private final String vehicleType;
    private int x;
    private int y;
    private int dir;
    private int modDir;


    public Vehicle(String vehicleType, Color color, int x, int y, int dir){
        this.vehicleType = vehicleType;
        this.color = color;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double newCurrentSpeed){
        if (newCurrentSpeed < 0){
            System.out.println("Can't have a negative speed");
        }else{
            currentSpeed = newCurrentSpeed;
        }
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
	    color = clr;
    }

    protected void startVehicle(){
	    currentSpeed = 0.1;
    }

    protected void stopVehicle(){
	    currentSpeed = 0;
    }

    protected String getVehicleType(){
        return vehicleType;
    }

    private void dirConverter(int dir){
        modDir = (dir % 4 + 4) % 4;
    }

    public void move(){
        dirConverter(this.dir);
        if (modDir == 0){
            this.y += Math.round(this.currentSpeed);

        }else if(modDir == 1){
            this.x += Math.round(this.currentSpeed);

        }else if(modDir == 2){
            this.y -= Math.round(this.currentSpeed);

        }else if(modDir == 3){
            this.x -= Math.round(this.currentSpeed);
        }
    }

    public void turnLeft(){
        this.dir -= 1;
        move();
    }

    public void turnRight(){
        this.dir += 1;
        move();
    }

    protected void setX(int newXCord){
        this.x = newXCord;
    }

    protected int getX(){
        return this.x;
    }

    protected void setY(int newYcord){
        this.y = newYcord;
    }

    protected int getY(){
        return this.y;
    }

    protected int getDir(){
        return dir;
    }

    protected void setDir(int newDir){
        dir = newDir;
    }

    public abstract void incrementSpeed(double amount);
        
    

    public abstract void decrementSpeed(double amount);
}