/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Zonaats
 */

package app;
import manajemen_rental.Management;
import rental.*;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Management management = new Management();
        Car car1 = new Car("Toyota Avanza", 600000);
        Car car2 = new Car("Toyota Innova", 700000);
        Car car3 = new Car("Toyota Fortuner", 850000);
        Car car4 = new Car("Toyota Rush", 600000);
        Car car5 = new Car("Daihatsu Sigra", 600000);

        management.addCarToList(car1);
        management.addCarToList(car2);
        management.addCarToList(car3);
        management.addCarToList(car4);
        management.addCarToList(car5);

        Customer customer1 = new Customer(650321321, "Aldeva");
        Customer customer2 = new Customer(987654321, "Windo");
        
        management.addCustToList(customer1);
        management.addCustToList(customer2);
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("===== AJ Travel Rental Mobil =====");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Customer");
        System.out.println("3. Keluar");
        System.out.print("Pilih akses: ");
        int role = scanner.nextInt();
        
        if (role == 1){
            System.out.println("Anda login sebagai Management!");
            while (!exit) {
                System.out.println("\n===== Menu Management =====");
                System.out.println("1. Tambah Mobil");
                System.out.println("2. Lihat Semua Mobil");
                System.out.println("3. Update Harga Mobil");
                System.out.println("4. Hapus Mobil");
                System.out.println("5. Tambah Customer");
                System.out.println("6. Lihat Semua Customer");
                System.out.println("7. Update Nama Customer");
                System.out.println("8. Hapus Customer");
                System.out.println("9. Exit");
                System.out.print("Pilih operasi: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1: 
                        System.out.print("Masukkan nama mobil: ");
                        String carName = scanner.nextLine();
                        System.out.print("Masukkan harga per hari (Rp): ");
                        double pricePerDay = scanner.nextDouble();
                        Car newCar = new Car(carName, pricePerDay);
                        management.addCarToList(newCar);
                        break;

                    case 2:
                        management.showAllCar();
                        break;

                    case 3:
                        System.out.print("Masukkan nama mobil yang ingin diupdate: ");
                        String carToUpdate = scanner.nextLine();
                        System.out.print("Masukkan harga baru: ");
                        double newPrice = scanner.nextDouble();
                        management.updateCarPrice(carToUpdate, newPrice);
                        break;

                    case 4:
                        System.out.print("Masukkan nama mobil yang ingin dihapus: ");
                        String carToDelete = scanner.nextLine();
                        management.deleteCar(carToDelete);
                        break;

                    case 5:
                        System.out.print("Masukkan NIK customer: ");
                        int nik = scanner.nextInt();
                        scanner.nextLine(); // Konsumsi newline
                        System.out.print("Masukkan nama customer: ");
                        String customerName = scanner.nextLine();
                        Customer newCustomer = new Customer(nik, customerName);
                        management.addCustToList(newCustomer);
                        break;

                    case 6:
                        management.showCustomerList();
                        break;

                    case 7: 
                        System.out.print("Masukkan NIK customer yang ingin diupdate: ");
                        int custNikToUpdate = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Masukkan nama baru customer: ");
                        String newCustName = scanner.nextLine();
                        management.updateCustomerName(custNikToUpdate, newCustName);
                        break;

                    case 8:
                        System.out.print("Masukkan NIK customer yang ingin dihapus: ");
                        int custNikToDelete = scanner.nextInt();
                        management.deleteCustomer(custNikToDelete);
                        break;

                    case 9:
                        exit = true;
                        System.out.println("Keluar dari mode Admin");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid, silakan coba lagi.");
                        break;
                }
            }
        } else if (role == 2){
            System.out.println("Anda login sebagai Customer!");
            Customer currentCustomer = null;
            boolean loggedIn = false;

            while (!exit) {
                if (!loggedIn) {
                    
                    System.out.println("\n===== Menu Customer =====");
                    System.out.println("1. Login");
                    System.out.println("2. Registrasi");
                    System.out.println("3. Exit");
                    System.out.print("Pilih operasi: ");
                    int custChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (custChoice) {
                        case 1: 
                            System.out.print("Masukkan NIK: ");
                            int nikToLogin = scanner.nextInt();
                            currentCustomer = management.findCustomerByNik(nikToLogin);
                            if (currentCustomer != null) {
                                System.out.println("Login berhasil! Selamat datang, " + currentCustomer.getName());
                                loggedIn = true;
                            } else {
                                System.out.println("Customer tidak ditemukan.");
                            }
                            break;

                        case 2: 
                            System.out.print("Masukkan NIK: ");
                            int newCustNik = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Masukkan nama: ");
                            String newCustName = scanner.nextLine();
                            currentCustomer = new Customer(newCustNik, newCustName);
                            management.addCustToList(currentCustomer);
                            loggedIn = true;
                            System.out.println("Registrasi berhasil!");
                            break;

                        case 3: 
                            exit = true;
                            break;

                        default:
                            System.out.println("Pilihan tidak valid, silakan coba lagi.");
                            break;
                    }
                } else {
                    // Menu jika customer sudah login
                    System.out.println("\n===== Menu Customer =====");
                    System.out.println("1. Lihat Mobil Tersedia");
                    System.out.println("2. Rent Mobil");
                    System.out.println("3. Lihat Mobil yang Dirental");
                    System.out.println("4. Logout");
                    System.out.print("Pilih operasi: ");
                    int custOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (custOp) {
                        case 1: 
                            management.showAvailableCar();
                            break;

                        case 2: 
                            System.out.print("Masukkan nama mobil yang ingin dirental (Masukkan nama mobil secara LENGKAP): ");
                            String carToRent = scanner.nextLine();
                            Car car = management.findCar(carToRent);
                            if (car != null) {
                                System.out.print("Berapa hari anda ingin merental mobil?: ");
                                int days = scanner.nextInt();
                                currentCustomer.rentCar(car, days);
                            } else {
                                System.out.println("Mobil tidak ditemukan.");
                            }
                            break;

                        case 3: 
                            currentCustomer.checkRentedCar();
                            break;

                        case 4: 
                            loggedIn = false;
                            System.out.println("Logout berhasil.");
                            break;

                        default:
                            System.out.println("Pilihan tidak valid, silakan coba lagi.");
                            break;
                    }
                }
            }
        } else if (role == 3){
            exit = true;
            System.out.println("Terima kasih telah menggunakan!");
        }
        scanner.close();
    }
}
