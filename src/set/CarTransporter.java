package set;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Truck implements Loadable{

    
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

    public void LoadCar(Car car){
        if (!rampUp && (carsOnTruck.size() < maxCarsOnTruck) && !car.isCarOnTruck() && IsCarCloseEnough(car)){
            carsOnTruck.add(car);
            car.GetCarOnTruck();
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive on");  
        }
        else if(carsOnTruck.size() == 5){
            throw new ArithmeticException("Car transporter already full");
        }
        else if(!IsCarCloseEnough(car)){
            throw new ArithmeticException("Car is too far away");
        }
        }

    

    public void RemoveCar(Car car){
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

    public boolean IsCarCloseEnough(Car car){
        int xDiff = this.getX() - car.getX();
        int yDiff = this.getY() - car.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + (Math.pow(yDiff, 2))) < minDistanceToDriveOnTruck;
    }
    
    /* Vill göra private men går ej med inteface */
    public void SetPosition(Car car){
        car.setX(getX());
        car.setY(getY());
        SetCarInSameDirection(car);
    
       
    }

    private void SetCarInSameDirection(Car car){
        if(car.getDirection() == this.getDirection()){
            car.move();
        }
        else{
            car.turnLeft();
        }
    
    }


    @Override
    public void move(){
        if (rampUp){
            super.move();
            for(Car car : carsOnTruck){
               SetPosition(car); 
            }
        }
        else{
            throw new ArithmeticException("Can't drive with the ramp down!");
        }
    }

       
}
