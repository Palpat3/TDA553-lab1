import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95", "Car", 0, 0, 0);
	    turboOn = false;
        stopVehicle();
    }
    
   public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public boolean isTurboOn() {
        return turboOn;
    }

    public double speedFactor(){
        double turbo = 1;
        if(isTurboOn()) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        if(speedFactor() * amount < getCurrentSpeed()){
            setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
        }
        else{
            System.out.println("You can't brake that much");
        }
        
    }
    
    
}
