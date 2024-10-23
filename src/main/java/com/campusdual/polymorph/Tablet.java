package com.campusdual.polymorph;

public class Tablet extends Device implements IChargeable {

    public Tablet(String brand, String model) {
        super(brand, model);
    }

    public void changeScreenOrientation(){
        System.out.println("Switch screen orientation.");
    }

    @Override
    public void charge() {
        System.out.println(this.getBrand() + " " + this.getModel() + " is charging at 33 W.");
    }

    @Override
    public void use() {
        System.out.println("Using with touch screen and keyboard.");
    }
}
