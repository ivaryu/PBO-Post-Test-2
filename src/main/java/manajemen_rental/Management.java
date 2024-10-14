/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen_rental;
import rental.Car;
import rental.Customer;
import rental.Truck;
import rental.Sedan;
import java.util.ArrayList;


/**
 *
 * @author Zonaats
 */
public class Management implements OperasiCRUD{
    
    public final ArrayList<Car> carList;
    public final ArrayList<Truck> truckList;
    public final ArrayList<Sedan> sedanList;
    public final ArrayList<Customer> custList;
    public final ArrayList<Admin> adminList;
    
    public Management(){
        this.carList = new ArrayList();
        this.truckList = new ArrayList();
        this.sedanList = new ArrayList();
        this.custList = new ArrayList();
        this.adminList = new ArrayList();
    }
    
    public void AdminList(Admin admin){
        adminList.add(admin);
    }
    
    public Admin findAdmin(String name, int pass){
        for (Admin admin : adminList){
            if (admin.getAdmNm().equalsIgnoreCase(name) && admin.getAdmPs() == pass){
                return admin;
            }
        } return null;
    }
    
    @Override
    public void addCarToList(Car car){
        carList.add(car);
    }

    @Override
    public void addTruckToList(Truck truck){
        truckList.add(truck);
    }
    
    @Override
    public void addSedanToList(Sedan sedan){
        sedanList.add(sedan);
    }

    @Override
    public void readAvailableCar(){
        System.out.println("List Mobil AJ Travel Yang Tersedia");
        for (Car car : carList){
            if (car.getCarStatus() == true){
                car.readInfo();
                System.out.println("======================================");
            }
        }
    }
    
    @Override
    public void readAllCar(){
        System.out.println("List Mobil AJ Travel");
        for (Car car : carList){
            car.readInfo();
            System.out.println("======================================");
        }
    }
    
    @Override
    public void readAllTruck(){
        System.out.println("List Truck AJ Travel");
        for (Truck truck : truckList){
            truck.readInfo();
            System.out.println("======================================");
        }
    }
    
    @Override
    public void readAvailableTruck(){
        System.out.println("List Mobil AJ Travel Yang Tersedia");
        for (Truck truck : truckList){
            if (truck.getCarStatus() == true){
                truck.readInfo();
                System.out.println("======================================");
            }
        }
    }
    
    @Override
    public void readAllSedan(){
        System.out.println("List Sedan AJ Travel");
        for (Sedan sedan : sedanList){
            sedan.readInfo();
            System.out.println("======================================");
        }
    }
    
    @Override
    public void readAvailableSedan(){
        System.out.println("List Sedan AJ Travel Yang Tersedia");
        for (Sedan sedan : sedanList){
            if (sedan.getCarStatus() == true){
                sedan.readInfo();
                System.out.println("======================================");
            }
        }
    }
    
    @Override
    public void updateCar(int carId, String carName, double newPrice){
        Car currentCar = findCarId(carId);
        if (currentCar != null){
            currentCar.setCarName(carName);
            currentCar.setCarPrice(newPrice);
            System.out.println("Berhasil Merubah Data Mobil " + currentCar.getCarName());
        }
    }
    
    @Override
    public void updateTruck(int carId, String carName, double newPrice, int newWheel, double newCapacity, String newType){
        Truck currentTruck = findTruckId(carId);
        if (currentTruck != null){
            currentTruck.setCarName(carName);
            currentTruck.setCarPrice(newPrice);
            currentTruck.setWheel(newWheel);
            currentTruck.setCapacity(newCapacity);
            currentTruck.setTruckType(newType);
            System.out.println("Berhasil Merubah Data Truck " + currentTruck.getCarName());
        }
    }
    
    @Override
    public void updateSedan(int carId, String carName, double newPrice, String newColor, int newDoors, int newSeat){
        Sedan currentSedan = findSedanId(carId);
        if (currentSedan != null){
            currentSedan.setCarName(carName);
            currentSedan.setCarPrice(newPrice);
            currentSedan.setColor(newColor);
            currentSedan.setDoors(newDoors);
            currentSedan.setSeatSedan(newSeat);
            System.out.println("Berhasil Merubah Data Sedan " + currentSedan.getCarName());
        }
    }
    
    @Override
    public void deleteCar(int carId){
        Car currentCar = findCarId(carId);
        if (currentCar != null){
            carList.remove(currentCar);
            System.out.println("Mobil " + currentCar.getCarName() + " Berhasil Dihapus!");
        }
    }
    
    @Override
    public void deleteTruck(int carId){
        Truck currentTruck = findTruckId(carId);
        if (currentTruck != null){
            truckList.remove(currentTruck);
            System.out.println("Mobil " + currentTruck.getCarName() + " Berhasil Dihapus!");
        }
    }
    
    @Override
    public void deleteSedan(int carId){
        Sedan currentSedan = findSedanId(carId);
        if (currentSedan != null){
            sedanList.remove(currentSedan);
            System.out.println("Mobil " + currentSedan.getCarName() + " Berhasil Dihapus!");
        }
    }
    
    public Car findCarId(int carId){
        for (Car car : carList){
            if (car.getCarCode() == carId){
                return car;
            }
        }
        return null;
    }
    
    public Truck findTruckId(int carId){
        for (Truck truck : truckList){
            if (truck.getCarCode() == carId){
                return truck;
            }
        }
        return null;
    }
    
    public Sedan findSedanId(int carId){
        for (Sedan sedan : sedanList){
            if (sedan.getCarCode() == carId){
                return sedan;
            }
        }
        return null;
    }
    
    public Car findCar(String carName){
        for (Car car : carList){
            System.out.println("Memeriksa mobil: " + car.getCarName());
            if (car.getCarName().equalsIgnoreCase(carName)){
                return car;
            }
        }
        return null;
    }
    
    // Customer Part
    
    @Override
    public void addCustToList(Customer customer){
        custList.add(customer);
    }
    
    @Override
    public void showCustomerList(){
        System.out.println("List Customer Rental Mobil AJ Travel");
        if (custList.isEmpty()){
            System.out.println("Yah... Belum Ada Customer Nih");
        } else {
            for (Customer customer : custList){
            System.out.println("NIK Customer: " + customer.getNik());
            System.out.println("Nama Customer: " + customer.getName());
            System.out.println("======================================");
            }
        }   
    }
    
    @Override
    public void updateCustomerName(int nik, String newName){
        for (Customer customer : custList) {
            if (customer.getNik() == nik){
                customer.setName(newName);
                System.out.println("Customer dengan NIK" + customer.getNik() + " Berhasil Diperbarui!");
                return;
            }
        }
        System.out.println("Customer tidak ditemukan!");
    }
    
    @Override
    public void deleteCustomer(int nik){
        for (Customer customer : custList) {
            if (customer.getNik() == nik){
                custList.remove(customer);
                System.out.println("Customer dengan NIK" + customer.getNik() + " Berhasil Dihapus!");
                return;
            }
        }
        System.out.println("Customer tidak ditemukan!");
    }
    
    public Customer findCustomerByNik(int nik) {
    for (Customer customer : custList) {
        if (customer.getNik() == nik) {
            return customer;
            }
        }
        return null;
    }
}