package set;

import java.awt.*;
import java.util.*;

public class CarTransporter extends Truck {

    
    private boolean rampUp = true;
    private final int maxCarsOnTruck = 5;
    private ArrayList<Car> CarsOnTruck = new ArrayList<>(maxCarsOnTruck);
    private final double minDistanceToDriveOnTruck = 5;

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

    public void DriveCarOnTruck(Car car){
        if (!rampUp && (CarsOnTruck.size() < maxCarsOnTruck) && !car.isCarOnTruck() && CanCarDriveOn(car)){
            CarsOnTruck.add(car);
            car.GetCarOnTruck();
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive on");  
        }
        else if(CarsOnTruck.size() == 5){
            throw new ArithmeticException("Car transporter already full");
        }
        else if(!CanCarDriveOn(car)){
            throw new ArithmeticException("Car is too far away");
        }
        }

    

    public void RemoveCarFromTruck(Car car){
        if (!rampUp && CarsOnTruck.size() > 0 && car.isCarOnTruck()){
            CarsOnTruck.remove(CarsOnTruck.indexOf(car));
            car.GetCarOffTruck();
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive off");
        }
        else{
            throw new ArithmeticException("Car transporter is empty");
        }
    }

    private boolean CanCarDriveOn(Car car){
        int xDiff = this.getX() - car.getX();
        int yDiff = this.getY() - car.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + (Math.pow(yDiff, 2))) < minDistanceToDriveOnTruck;
    }

    private void MatchCarsAndTransportSpeed(){
        for (Car car : CarsOnTruck){
            car.setCurrentSpeed(this.getCurrentSpeed());
        }
    }

    private void MoveCarInSameDirection(){
        for (Car car : CarsOnTruck){
            if(car.getDirection() == this.getDirection()){
                car.move();
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
            MatchCarsAndTransportSpeed();
            MoveCarInSameDirection();
            
        }
        else{
            throw new ArithmeticException("Can't drive with the ramp down!");
        }
    }

       
}
