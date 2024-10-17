package encapsulation;

public class Vehicle {
    //Definamos atributos, como : marca, matrícula, modelo, disponibilidad para alquilar y velocidad máxima legal
    private String brand;
    private String licensePlate;
    private String model;
    private boolean available;
    public static final int LEGAL_MAX_SPEED = 120;

    public Vehicle(String brand, String license, String model) {
        this.brand = brand;
        this.licensePlate = license;
        this.model = model;
        this.available = true;
    }
    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void rentACar() {
        if (this.available){
            this.available = false;
            System.out.println("The vehicle with license plate " + this.licensePlate + " has been rented.");
        } else {
            System.out.println("The vehicle with license plate " + this.licensePlate + " is not available");
        }
    }

    public void returnACar() {
        if (!this.available){
            this.available = true;
            System.out.println("The vehicle with license plate " + this.licensePlate + " has been returned");
        } else {
            System.out.println("The vehicle with license plate " + this.licensePlate + " is already available");
        }
    }

    public String getDetails(){
        //return this.getBrand() + " " + this.getModel() + ", license plate: " + this.getLicensePlate();
        return this.brand + " " + this.model + "\n\tLicense plate: " + this.licensePlate + "\n\tAvailable: " + (this.available ? "Yes" : "No" );
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("Citroen", "0000BBB", "Xsara");
        System.out.println(v.getDetails());
        v.rentACar();
        System.out.println(v.getDetails());
        v.returnACar();
        System.out.println(v.getDetails());
    }
}
