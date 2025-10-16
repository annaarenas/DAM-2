public class VehicleSounds<T extends Vehicle, U extends Vehicle> {
    private T vehicle1;
    private U vehicle2;

    public VehicleSounds(T vehicle1, U vehicle2) {
        this.vehicle1 = vehicle1;
        this.vehicle2 = vehicle2;
    }

    public String playSounds(){
        return vehicle1.sound() + " " + vehicle2.sound();
    }
}