public abstract class Vehicle {
    protected String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public abstract String sound();
}
