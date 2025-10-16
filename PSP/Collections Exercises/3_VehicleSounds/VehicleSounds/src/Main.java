public class Main {
    public static void main(String[] args) {
        VehicleSounds<Truck, Bike> vehicleSounds = new VehicleSounds<>(new Truck("BMW"), new Bike("Vespa"));
        VehicleSounds<Car, Truck> vehicleSounds2 = new VehicleSounds<>(new Car("Mercedes"), new Truck("Volvo"));

        System.out.println(vehicleSounds.playSounds());
        System.out.println(vehicleSounds2.playSounds());
    }
}
