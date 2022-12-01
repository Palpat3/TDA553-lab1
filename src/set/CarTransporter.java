package set;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Truck{

    
    private boolean rampUp = true;
    private Loadable storage = new CarStorage(5);

    public CarTransporter(){
        super(2, 90, Color.green, "Car Transporter", 0, 0);
    }

    public void LiftRamp(){
        rampUp = true;
    }

    public void LowerRamp(){
        if (getCurrentSpeed() == 0){
          rampUp = false;  
        }
        else{
            throw new ArithmeticException("You have to be stationairy to move platform");
        }
        
    }

    public boolean isRampUp() {
        return rampUp;
    }

    public boolean IsCarCloseEnoughToStore(Car car){
        int xDiff = this.getX() - car.getX();
        int yDiff = this.getY() - car.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + (Math.pow(yDiff, 2))) < storage.getMinDistanceToStoreCar();
    }

    public void LoadCar(Car car){
        if (!rampUp && IsCarCloseEnoughToStore(car)){
            storage.LoadCar(car);
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive on"); 
        }
        else{
            throw new ArithmeticException("Car is too far away");
        }
    }

    public void removeCar(Car car){
        if (!rampUp){
            storage.RemoveCar(car);
            SetCarInSameDirection(car);
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive off");
        }
    }
    
    private void SetPosition(Car car){
        car.setX(getX());
        car.setY(getY());
    }

    private void SetCarInSameDirection(Car car){
        for(int i = 0; i < 3; i++){
            if(car.getDirection() == this.getDirection()){
                break;
            }
            else{
                car.turnLeft();
            }
        }
    }


    @Override
    public void move(){
        if (rampUp){
            super.move();
            for(Car car : storage.getCarsInStorage()){
               SetPosition(car); 
            }
        }
        else{
            throw new ArithmeticException("Can't drive with the ramp down!");
        }
    }

       
}
