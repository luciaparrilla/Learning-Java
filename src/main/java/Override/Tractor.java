package Override;

public class Tractor extends Vehicle{

    @Override
    public void start() {
        System.out.println("Starting the tractor.");
    }
}