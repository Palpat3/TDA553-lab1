package set;

public class Application{

    public static void main(String[] args) {
        // Instance of this class
        VehicleModel vm = new VehicleModel();
        CarController cc = new CarController(vm);

        
    
        vm.addVehicles(VehicleFactory.createVolvo240());
        vm.addVehicles(VehicleFactory.createSaab95());
        vm.addVehicles(VehicleFactory.createScania());
    
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
    
        // Start the timer
        cc.start();
    }

}
