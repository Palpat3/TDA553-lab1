import java.awt.*;

public abstract class Vehicle implements Movable {
    
    public double currentSpeed;
    public Color color;
    public String vehicleType;
    public int x;
    public int y;
    public int dir;


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

    
    public abstract double speedFactor();
    


    public abstract void incrementSpeed(double amount);
        
    

    public abstract void decrementSpeed(double amount);
        
    

}