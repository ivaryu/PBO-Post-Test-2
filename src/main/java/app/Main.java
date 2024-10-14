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

        Truck truck1 = new Truck("Hino Ranger", 1800000, 6, 15000, "Box Truck");
        Truck truck2 = new Truck("Mitsubishi Fuso", 1700000, 6, 20000, "Dump Truck");
        
        Sedan sedan1 = new Sedan("Toyota Camry", 2000000, "Hitam", 4, 5);
        Sedan sedan2 = new Sedan("Mercedes Benz-C-Class", 2500000, "Biru", 4, 5);

        management.addCarToList(car1);
        management.addCarToList(car2);
        management.addCarToList(car3);
        management.addCarToList(car4);
        management.addCarToList(car5);

        management.addTruckToList(truck1);
        management.addTruckToList(truck2);

        management.addSedanToList(sedan1);
        management.addSedanToList(sedan2);

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
                    System.out.println("2. Tambah Truck");
                    System.out.println("3. Tambah Sedan");
                    System.out.println("4. Lihat Semua Mobil");
                    System.out.println("5. Lihat Semua Truck");
                    System.out.println("6. Lihat Semua Sedan");
                    System.out.println("7. Update Mobil");
                    System.out.println("8. Update Truck");
                    System.out.println("9. Update Sedan");
                    System.out.println("10. Hapus Mobil");
                    System.out.println("11. Hapus Truck");
                    System.out.println("12. Hapus Sedan");
                    System.out.println("========================");
                    System.out.println("13. Tambah Customer");
                    System.out.println("14. Lihat Semua Customer");
                    System.out.println("15. Update Nama Customer");
                    System.out.println("16. Hapus Customer");
                    System.out.println("========================");
                    System.out.println("17. Info Admin");
                    System.out.println("18. Exit");
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
                            System.out.print("Masukkan Nama Truck: ");
                            String carName1 = scanner.nextLine();
                            System.out.print("Masukkan Harga per Hari (Rp): ");
                            double pricePerDay1 = scanner.nextDouble();
                            System.out.print("Masukkan Jumlah roda: ");
                            int wheel = scanner.nextInt();
                            System.out.print("Masukkan kapasitas muat truck (KG):  ");
                            double capacity = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Masukkan Tipe: ");
                            String truckType = scanner.nextLine();
                            Truck newTruck = new Truck(carName1, pricePerDay1, wheel, capacity, truckType);
                            management.addTruckToList(newTruck);
                            System.out.println("Mobil " + carName1 + " Berhasil Ditambahkan ke Daftar Mobil!");
                            break;
                            
                        case 3:
                            System.out.print("Masukkan Nama Sedan: ");
                            String carName2 = scanner.nextLine();
                            System.out.print("Masukkan Harga per Hari (Rp): ");
                            double pricePerDay2 = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Masukkan warna sedan: ");
                            String color = scanner.nextLine();
                            System.out.print("Masukkan jumlah pintu: ");
                            int doors = scanner.nextInt();
                            System.out.print("Masukkan jumlah kursi: ");
                            int seat = scanner.nextInt();
                            Sedan newSedan = new Sedan(carName2, pricePerDay2, color, doors, seat);
                            management.addSedanToList(newSedan);
                            System.out.println("Mobil " + carName2 + " Berhasil Ditambahkan ke Daftar Mobil!");
                            break;
                            
                        case 4:
                            management.readAllCar();
                            break;
                            
                        case 5:
                            management.readAllTruck();
                            break;
                            
                        case 6:
                            management.readAllSedan();
                            break;

                        case 7:
                            System.out.print("Masukkan ID yang Ingin Diupdate: ");
                            int carToUpdate = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Baru: ");
                            String newNamez = scanner.nextLine();
                            System.out.print("Masukkan Harga Baru: ");
                            double newPrice = scanner.nextDouble();
                            management.updateCar(carToUpdate, newNamez, newPrice);
                            break;
                            
                        case 8:
                            System.out.print("Masukkan ID yang Ingin Diupdate: ");
                            int carToUpdate1 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Baru: ");
                            String newNamez1 = scanner.nextLine();
                            System.out.print("Masukkan Harga Baru: ");
                            double newPrice1 = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Masukkan Jumlah Roda: ");
                            int newWheel = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Kapasitas Muat: ");
                            double newCapacity = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Masukkan Tipe Truk: ");
                            String newType = scanner.nextLine();
                            management.updateTruck(carToUpdate1, newNamez1, newPrice1, newWheel, newCapacity, newType);
                            break;
                            
                        case 9: System.out.print("Masukkan ID yang Ingin Diupdate: ");
                            int carToUpdate2 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Baru: ");
                            String newNamez2 = scanner.nextLine();
                            System.out.print("Masukkan Harga Baru: ");
                            double newPrice2 = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Masukkan Warna: ");
                            String newCol = scanner.nextLine();
                            System.out.print("Masukkan Jumlah Pintu: ");
                            int newDoors = scanner.nextInt();
                            System.out.print("Masukkan Jumlah Kursi: ");
                            int newSeat = scanner.nextInt();
                            management.updateSedan(carToUpdate2, newNamez2, newPrice2, newCol, newDoors, newSeat);
                            break;

                        case 10:
                            System.out.print("Masukkan ID Mobil Yang Ingin Dihapus: ");
                            int carToDelete = scanner.nextInt();
                            management.deleteCar(carToDelete);
                            break;
                            
                        case 11:
                            System.out.print("Masukkan ID Truck Yang Ingin Dihapus: ");
                            int truckToDelete = scanner.nextInt();
                            management.deleteTruck(truckToDelete);
                            break;

                        case 12:
                            System.out.println("Masukkan ID Sedan Yang Ingin Dihapus: ");
                            int sedanId = scanner.nextInt();
                            management.deleteSedan(sedanId);
                            break;

                        case 13:
                            System.out.print("Masukkan NIK customer: ");
                            int nik = scanner.nextInt();
                            scanner.nextLine(); // Konsumsi newline
                            System.out.print("Masukkan Nama Customer: ");
                            String customerName = scanner.nextLine();
                            Customer newCustomer = new Customer(nik, customerName);
                            management.addCustToList(newCustomer);
                            System.out.println("Customer " + customerName + " Berhasil DItambahkan!" );
                            break;

                        case 14:
                            management.showCustomerList();
                            break;

                        case 15: 
                            System.out.print("Masukkan NIK customer yang ingin diupdate: ");
                            int custNikToUpdate = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Masukkan nama baru customer: ");
                            String newCustName = scanner.nextLine();
                            management.updateCustomerName(custNikToUpdate, newCustName);
                            break;

                        case 16:
                            System.out.print("Masukkan NIK customer yang ingin dihapus: ");
                            int custNikToDelete = scanner.nextInt();
                            management.deleteCustomer(custNikToDelete);
                            break;
                            
                        case 17:
                            currentAdmin.adminInfo();
                            break;

                        case 18:
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
                    System.out.println("2. Lihat Truck Tersedia");
                    System.out.println("3. Lihat Sedan Tersedia");
                    System.out.println("4. Rental Mobil");
                    System.out.println("5. Rental Truck");
                    System.out.println("6. Rental Sedan");
                    System.out.println("7. Lihat Mobil yang Dirental");
                    System.out.println("8. Lihat Truck yang Dirental");
                    System.out.println("9. Lihat Sedan yang Dirental");
                    System.out.println("10. Logout");
                    System.out.print("Pilih operasi: ");
                    int custOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (custOp) {
                        case 1: 
                            management.readAvailableCar();
                            break;

                        case 2:
                            management.readAvailableTruck();
                            break;

                        case 3:
                            management.readAvailableSedan();
                            break;

                        case 4: 
                            System.out.print("Masukkan ID Mobil yang ingin dirental: ");
                            int carToRent = scanner.nextInt();
                            Car car = management.findCarId(carToRent);
                            if (car != null) {
                                System.out.print("Berapa hari anda ingin merental mobil?: ");
                                int days = scanner.nextInt();
                                currentCustomer.rentCar(car, days);
                            } else {
                                System.out.println("Mobil tidak ditemukan.");
                            }
                            break;
                        
                        case 5:
                            System.out.print("Masukkan ID Truck yang ingin dirental: ");
                            int truckToRent = scanner.nextInt();
                            Truck truck = management.findTruckId(truckToRent);
                            if (truck != null) {
                                System.out.print("Berapa hari anda ingin merental truck?: ");
                                int days = scanner.nextInt();
                                currentCustomer.rentTruck(truck, days);
                            } else {
                                System.out.println("Truck tidak ditemukan.");
                            }
                            break;

                        case 6:
                            System.out.print("Masukkan ID Sedan yang ingin dirental: ");
                            int sedanRent = scanner.nextInt();
                            Sedan sedan = management.findSedanId(sedanRent);
                            if (sedan != null) {
                                System.out.print("Berapa hari anda ingin merental mobil?: ");
                                int days = scanner.nextInt();
                                currentCustomer.rentSedan(sedan, days);
                            } else {
                                System.out.println("Sedan tidak ditemukan.");
                            }
                            break;

                        case 7: 
                            currentCustomer.checkRentedCar();
                            break;
                        
                        case 8:
                            currentCustomer.checkRentedTruck();
                            break;

                        case 9:
                            currentCustomer.checkRentedSedan();
                            break;    

                        case 10: 
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
