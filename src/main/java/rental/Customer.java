/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental;
import manajemen_rental.Transaksi;
import java.util.ArrayList;

/**
 *
 * @author Zonaats
 */
public class Customer {
    private int custNik;
    private String custName;
    private ArrayList<Car> rentedCar;
    private ArrayList<Truck> rentedTruck;
    private ArrayList<Sedan> rentedSedan;
    private Transaksi transaksi;
    
    public Customer(int newCustNik, String newCustName){
        this.custNik = newCustNik;
        this.custName = newCustName;
        this.rentedCar = new ArrayList();
        this.rentedTruck = new ArrayList();
        this.rentedSedan = new ArrayList();
    }
    
    public int getNik(){
        return custNik;
    }
    
    public String getName(){
        return custName;
    }
    
    public void setName(String newName){
        this.custName = newName;
    }
    
    public void checkRentedCar(){
        System.out.println("Lihat Mobil Yang Dirental!");
        if (rentedCar.isEmpty()) {
            System.out.println("Belum merental mobil...");
            // main()
        }
        for (Car car : rentedCar){
            System.out.println("Mobil Yang Dirental: " + car.getCarName());
        }
    }

    public void checkRentedTruck(){
        System.out.println("Lihat Truck yang dirental");
        if (rentedTruck.isEmpty()) {
            System.out.println("Belum merental truck...");
            // main()
        }
        for (Truck truck : rentedTruck){
            System.out.println("Truck Yang Dirental: " + truck.getCarName());
        }
    }

    public void checkRentedSedan(){
        System.out.println("Lihat Sedan yang dirental");
        if (rentedSedan.isEmpty()) {
            System.out.println("Belum merental sedan...");
            // main()
        }
        for (Sedan sedan : rentedSedan){
            System.out.println("Sedan Yang Dirental: " + sedan.getCarName());
        }
    }
    
    public void rentCar(Car car, int days){
        if (car.getCarStatus() == true){
            Transaksi transaksi = new Transaksi(this, car, days);
            transaksi.custInvoice(days);
            rentedCar.add(car);
            car.rentingCar();
            
        } else {
            System.out.println("Mobil " + car.getCarName() + " Tidak Tersedia :( ");
            System.out.println("Silahkan Rental Mobil Yang Lain");
        }
    }
    
    public void rentTruck(Truck truck, int days){
        if (truck.getCarStatus() == true){
            Transaksi transaksi = new Transaksi(this, truck, days);
            transaksi.custInvoice(days);
            rentedTruck.add(truck);
            truck.rentingCar();
            
        } else {
            System.out.println("Truck " + truck.getCarName() + " Tidak Tersedia :( ");
            System.out.println("Silahkan Rental Mobil Yang Lain");
        }
    }

    public void rentSedan(Sedan sedan, int days){
        if (sedan.getCarStatus() == true){
            Transaksi transaksi = new Transaksi(this, sedan, days);
            transaksi.custInvoice(days);
            rentedSedan.add(sedan);
            sedan.rentingCar();
            
        } else {
            System.out.println("Sedan " + sedan.getCarName() + " Tidak Tersedia :( ");
            System.out.println("Silahkan Rental Mobil Yang Lain");
        }
    }
    
    
}

