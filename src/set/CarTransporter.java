package set;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Truck {

    
    private boolean rampUp = true;
    private final int maxCarsOnTruck = 5;
    private List<Car> carsOnTruck = new ArrayList<>(maxCarsOnTruck);
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
        if (!rampUp && (carsOnTruck.size() < maxCarsOnTruck) && !car.isCarOnTruck() && CanCarDriveOn(car)){
            carsOnTruck.add(car);
            car.GetCarOnTruck();
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive on");  
        }
        else if(carsOnTruck.size() == 5){
            throw new ArithmeticException("Car transporter already full");
        }
        else if(!CanCarDriveOn(car)){
            throw new ArithmeticException("Car is too far away");
        }
        }

    

    public void RemoveCarFromTruck(Car car){
        if (!rampUp && carsOnTruck.size() > 0 && car.isCarOnTruck()){
            carsOnTruck.remove(car);
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
        for (Car car : carsOnTruck){
            car.setCurrentSpeed(this.getCurrentSpeed());
        }
    }

    private void MoveCarInSameDirection(){
        for (Car car : carsOnTruck){
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
