package set;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VehicleModel {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    private final int delay = 50;
    public CarView frame;


    private Timer timer = new Timer(delay, new TimerListener());


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                frame.update(vehicle);
            }
        }
    }

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

    public void start(){
        timer.start();
    }
}
