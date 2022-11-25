package set;

import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
   
    
    public Saab95(){
        super(2, 125, Color.red,  "Saab95", 0, 0);
	    turboOn = false;
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