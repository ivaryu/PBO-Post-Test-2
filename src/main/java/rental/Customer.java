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
    private Transaksi transaksi;
    
    public Customer(int newCustNik, String newCustName){
        this.custNik = newCustNik;
        this.custName = newCustName;
        this.rentedCar = new ArrayList();
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
    
    public void rentCar(Car car, int days){
        if (car.getCarStatus() == true){
            Transaksi transaksi = new Transaksi(this, car, days);
            transaksi.custInvoice(days);
            rentedCar.add(car);
            car.rentingCar();
            
        } else {
            System.out.println("Mobil " + car + " Tidak Tersedia :( ");
            System.out.println("Silahkan Rental Mobil Yang Lain");
        }
    }
    
    public void returnCar(Car car){
        if (rentedCar.contains(car)){
            rentedCar.remove(car);
            car.returnCar();
            System.out.println("Mobil" + car.getCarName() + " telah dikembalikan!");
        } else {
            System.out.println("Mobil ini tidak dirental oleh anda.");
        }
    }
    
}

