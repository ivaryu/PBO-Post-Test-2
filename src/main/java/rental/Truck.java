/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental;

/**
 *
 * @author Zonaats
 */
public final class Truck extends Car {
    private int wheel;
    private double loadCapacity;
    private String truckType;

    public Truck(String newName, double newPrice, int newWheel, double newCapacity, String newType) {
        super(newName, newPrice);
        super.carCode = Car.totalCar;
        super.carStatus = true;
        this.wheel = newWheel;
        this.loadCapacity = newCapacity;
        this.truckType = newType;
        Car.totalCar++;
    }
    
    @Override
    public void readInfo(){
        System.out.println("ID Kendaraan: " + super.carCode);
        System.out.println("Mobil: " + super.carName);
        System.out.println("Harga per hari: " + super.pricePerDay);
        System.out.println("Jumlah roda: " + this.wheel);
        System.out.println("Kapasitas muat: " + this.loadCapacity);
        System.out.println("Tipe Truk: " + this.truckType);
    }
    
    @Override
    public void rentingCar(){
        if (carStatus){
            carStatus = false;
        }
    }
    
    @Override
    public void returnCar(){
        if (!carStatus){
            carStatus = true;
        }
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public double getCapacity() {
        return loadCapacity;
    }

    public void setCapacity(double capacity) {
        this.loadCapacity = capacity;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }
    
    
}
