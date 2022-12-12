package set;

public class VehicleFactory {

    public static Volvo240 createVolvo240(){
        return new Volvo240();
    }

    public static Saab95 createSaab95(){
        return new Saab95();
    }

    public static Scania createScania(){
        return new Scania();
    }

    public static CarTransporter createCarTransporter(){
        return new CarTransporter();
    }

    
    
}
