package set;


import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    

    private VehicleModel model;

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed

    //methods:
    public CarController(VehicleModel model){
        this.model = model;
    } 

    
    

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    

    public ArrayList<Vehicle> getVehicleList(){
        return model.getVehicleList();
    }

    
    // Calls the gas method for each car once
    public void gas(int amount) {
        model.gas(amount);
    }
}
