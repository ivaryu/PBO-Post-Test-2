    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package manajemen_rental;
    import rental.Car;
    import rental.Customer;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    /**
     *
     * @author Zonaats
     */
    public class Transaksi {
        private Car car;
        private Customer customer;
        private int days;
        private LocalDateTime transactionDate;
        

        public Transaksi(Customer customer, Car car, int days) {
            this.customer = customer;
            this.car = car;
            this.days = days;
            this.transactionDate= LocalDateTime.now();  
        }

        public void custInvoice(int days) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String date = transactionDate.format(formatter);
            double total = car.getCarPrice() * days;
            System.out.println("                INVOICE");
            System.out.println("               AJ TRAVEL");
            System.out.println("Tanggal Transaksi: " + date);
            System.out.println("Customer: " + customer.getName());
            System.out.println("Pemakaian: " + days + " Hari");        
            System.out.println("Harga Per Hari: Rp" + car.getCarPrice());
            System.out.println("Total: Rp" + total);
            System.out.println("=======================================");
        }
    }
