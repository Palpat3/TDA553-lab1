package set;

import java.awt.*;

public class Scania extends Truck{

    private double platformAngle = 0;
   
    
    public Scania(){
        super(2, 90, Color.WHITE, "Scania", 0, 0);
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void ChangePlatformAngle(double newPlatformAngle){
        if(getCurrentSpeed() == 0 && newPlatformAngle <= 70 && newPlatformAngle >= 0){
            platformAngle = newPlatformAngle;
        }
        else if(getCurrentSpeed() != 0){
            throw new ArithmeticException("You have to be stationairy to move platform");
        }
        else{
            throw new IllegalArgumentException("The platform can't be angled more than 70 degrees or less than 0 degrees");
        }
    }

    @Override
    public void startVehicle() {
        if(platformAngle == 0){
            super.startVehicle();
        }
    }
}
    
