/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rental;
import rental.Customer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Zonaats
 */
public class Car{
    
    public static int totalCar = 0;
    public String carName;
    public int carCode;
    public boolean carStatus = true;
    public double pricePerDay;
    public LocalDateTime transactionDate;
    public Customer customer;
    
    public Car(String newName, double newPrice){
        this.carName = newName;
        this.carStatus = true;
        this.pricePerDay = newPrice;
        this.carCode = totalCar;
        totalCar++;
    }
    
    public void readInfo(){
        System.out.println("ID Kendaraan: " + this.carCode);
        System.out.println("Mobil: " + this.carName);
        System.out.println("Harga per hari: " + this.pricePerDay);
    }
    
    public void rentingCar(){
        if (carStatus){
            carStatus = false;
        }
    }
    
    public void returnCar(){
        if (!carStatus){
            carStatus = true;
        }
    }
    
    public String getCarName(){
        return carName;
    }
    
    public void setCarName(String newName){
        this.carName = newName;
    }
    
    public boolean getCarStatus(){
        return carStatus;
    }
    
    public double getCarPrice(){
        return pricePerDay;
    }
    
    public void setCarPrice(double newPrice){
        this.pricePerDay = newPrice;
    }

    public int getCarCode() {
        return carCode;
    }
    
    
}
