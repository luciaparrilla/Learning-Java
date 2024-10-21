package Override;

public class Car extends Vehicle{

    @Override
    public void start() {
        System.out.println("Starting the car.");
    }
}
