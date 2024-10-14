/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen_rental;
import rental.*;

/**
 *
 * @author Zonaats
 */
public interface OperasiCRUD {
    void addCarToList(Car car);
    void addTruckToList(Truck truck);
    void addSedanToList(Sedan sedan);
    void readAvailableCar();
    void readAllCar();
    void readAllTruck();
    void readAvailableTruck();
    void readAllSedan();
    void readAvailableSedan();
    void updateCar(int carId, String carName, double newPrice);
    void updateTruck(int carId, String carName, double newPrice, int newWheel, double newCapacity, String newType);
    void updateSedan(int carId, String carName, double newPrice, String newColor, int newDoors, int newSeat);
    void deleteCar(int carId);
    void deleteTruck(int carId);
    void deleteSedan(int carId);
    // ---
    void addCustToList(Customer customer);
    void showCustomerList();
    void updateCustomerName(int nik, String newName);
    void deleteCustomer(int nik);
    
    
}
