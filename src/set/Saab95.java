package set;

import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
   
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95", "Car", 0, 0, 0);
	    turboOn = false;
        stopVehicle();
    }
    
    protected void setTurboOn(){
	    turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    protected boolean isTurboOn(){
        return turboOn;
    }
    
    protected double speedFactor(){
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    
}