/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rental;

/**
 *
 * @author Zonaats
 */
public class Car{
    
    private String carName;
    private int carCode;
    private boolean carStatus = true;
    private double pricePerDay;
    
    public static int totalCar = 0;
    
    public Car(String newName, double newPrice){
        this.carName = newName;
        this.carStatus = true;
        this.pricePerDay = newPrice;
        totalCar++;
    }
    
    public String getCarName(){
        return carName;
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
    
    
    
    
    
    
}
