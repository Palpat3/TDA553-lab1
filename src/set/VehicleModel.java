package set;

import java.util.ArrayList;

public class VehicleModel {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicles(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicleList(){
        return vehicles;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
        {
            vehicle.gas(gas);
        }
    }
}
