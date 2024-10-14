/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental;

/**
 *
 * @author Zonaats
 */
public final class Sedan extends Car {
    private String color;
    private int doors;
    private int seatSedan;
    
    public Sedan(String newName, double newPrice, String newColor, int newDoors, int newSeat){
        super(newName, newPrice);
        super.carCode = Car.totalCar;
        this.color = newColor;
        this.doors = newDoors;
        this.seatSedan = newSeat;
        Car.totalCar++;
    }
    
    @Override
    public void readInfo(){
        System.out.println("ID Kendaraan: " + super.carCode);
        System.out.println("Mobil: " + super.carName);
        System.out.println("Harga per hari: " + super.pricePerDay);
        System.out.println("Warna: " + this.color);
        System.out.println("Jumlah pintu: " + this.doors);
        System.out.println("Jumlah kursi: " + this.seatSedan);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeatSedan() {
        return seatSedan;
    }

    public void setSeatSedan(int seatSedan) {
        this.seatSedan = seatSedan;
    }
    
    
}
