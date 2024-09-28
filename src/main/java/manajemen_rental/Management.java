/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen_rental;
import rental.Car;
import rental.Customer;
import java.util.ArrayList;


/**
 *
 * @author Zonaats
 */
public class Management {
    
    private ArrayList<Car> carList;
    private ArrayList<Customer> custList;
    
    public Management(){
        this.carList = new ArrayList();
        this.custList = new ArrayList();
    }
    
    public void addCarToList(Car car){
        carList.add(car);
        System.out.println("Mobil " + car + " Berhasil Ditambahkan ke Daftar Mobil!");
    }
    
    public void updateCarPrice(String carName, double newPrice){
        for (Car car : carList){
            if (car.getCarName().equalsIgnoreCase(carName)) {
                car.setCarPrice(newPrice);
                System.out.println("Berhasil Merubah Harga Mobil " + car.getCarName());
                return;
            }
        }
    }
    
    public void deleteCar(String carName){
        for (Car car : carList){
            if (car.getCarName().equalsIgnoreCase(carName)){
                carList.remove(car);
                System.out.println("Mobil " + car.getCarName() + " Berhasil Dihapus!");
                return;
            }
        }
    }
    
    public void showAllCar(){
        System.out.println("List Mobil AJ Travel");
        for (Car car : carList){
            System.out.println("Mobil: " + car.getCarName());
            System.out.println("Harga Per Hari: Rp." + car.getCarPrice());
            System.out.println("======================================");
        }
    }
    
    public void showAvailableCar(){
        System.out.println("List Mobil AJ Travel Yang Tersedia");
        for (Car car : carList){
            if (car.getCarStatus() == true){
                System.out.println("Mobil: " + car.getCarName());
                System.out.println("Harga Per Hari: " + car.getCarPrice());
                System.out.println("======================================");
            }
        }
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
    
    public void addCustToList(Customer customer){
        custList.add(customer);
        System.out.println("Customer " + customer.getName() + " Berhasil DItambahkan!" );
    }
    
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