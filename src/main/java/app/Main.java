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
import manajemen_rental.Admin;
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

        Admin admin1 = new Admin("Windo", 200512, "windo3102@gmail.com");
        Admin admin2 = new Admin("Faiq", 32102, "faiqysrf2024@gmail.com");
        
        management.AdminList(admin1);
        management.AdminList(admin2);
        
        Customer customer1 = new Customer(650321321, "Aldeva");
        Customer customer2 = new Customer(987654321, "Anggara");
        
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
            System.out.println("Anda login sebagai Admin");
            Admin currentAdmin = null;
            boolean login = false;
            while (!exit) {
                if (!login){
                    System.out.println("1. Login");
                    System.out.println("2. Exit");
                    System.out.print("Masukkan Opsi: ");
                    int admChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (admChoice) {
                        case 1:
                            System.out.print("Masukkan Nama: ");
                            String loginName = scanner.nextLine(); 
                            System.out.print("Masukkan Password: ");
                            String tempPass = scanner.nextLine();
                            int loginPass;

                            try {
                                loginPass = Integer.parseInt(tempPass);
                            } catch (NumberFormatException e) {
                                System.out.println("Password harus berupa angka. Coba lagi.");
                                continue;
                            }

                                currentAdmin = management.findAdmin(loginName, loginPass);
                                if (currentAdmin != null) {
                                    System.out.println("Login berhasil! Selamat datang, " + currentAdmin.getAdmNm());
                                    login = true;
                                } else {
                                    System.out.println("Admin tidak terdaftar.");
                                } break;
                        case 2:
                            exit = true;

                    }
                } else {
                
                    System.out.println("\n===== Menu Admin =====");
                    System.out.println("1. Tambah Mobil");
                    System.out.println("2. Lihat Semua Mobil");
                    System.out.println("3. Update Harga Mobil");
                    System.out.println("4. Hapus Mobil");
                    System.out.println("========================");
                    System.out.println("5. Tambah Customer");
                    System.out.println("6. Lihat Semua Customer");
                    System.out.println("7. Update Nama Customer");
                    System.out.println("8. Hapus Customer");
                    System.out.println("========================");
                    System.out.println("9. Info Admin");
                    System.out.println("10. Exit");
                    System.out.print("Pilih operasi: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 
                    switch (choice) {
                        case 1: 
                            System.out.print("Masukkan Nama Mobil: ");
                            String carName = scanner.nextLine();
                            System.out.print("Masukkan Harga per Hari (Rp): ");
                            double pricePerDay = scanner.nextDouble();
                            Car newCar = new Car(carName, pricePerDay);
                            management.addCarToList(newCar);
                            System.out.println("Mobil " + carName + " Berhasil Ditambahkan ke Daftar Mobil!");
                            break;

                        case 2:
                            management.showAllCar();
                            break;

                        case 3:
                            System.out.print("Masukkan Nama Mobil yang Ingin Diupdate: ");
                            String carToUpdate = scanner.nextLine();
                            System.out.print("Masukkan Harga Baru: ");
                            double newPrice = scanner.nextDouble();
                            management.updateCarPrice(carToUpdate, newPrice);
                            break;

                        case 4:
                            System.out.print("Masukkan Nama Mobil Yang Ingin Dihapus: ");
                            String carToDelete = scanner.nextLine();
                            management.deleteCar(carToDelete);
                            break;

                        case 5:
                            System.out.print("Masukkan NIK customer: ");
                            int nik = scanner.nextInt();
                            scanner.nextLine(); // Konsumsi newline
                            System.out.print("Masukkan Nama Customer: ");
                            String customerName = scanner.nextLine();
                            Customer newCustomer = new Customer(nik, customerName);
                            management.addCustToList(newCustomer);
                            System.out.println("Customer " + customerName + " Berhasil DItambahkan!" );
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
                            currentAdmin.adminInfo();
                            break;

                        case 10:
                            exit = true;
                            System.out.println("Keluar dari mode Admin");
                            break;

                        default:
                            System.out.println("Pilihan tidak valid, silakan coba lagi.");
                            break;
                    }
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
