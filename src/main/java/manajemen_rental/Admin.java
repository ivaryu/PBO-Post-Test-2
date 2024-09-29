/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen_rental;

import rental.Car;
import rental.Customer;

import java.util.Scanner;
/**
 *
 * @author Zonaats
 */
public class Admin {
    private String adminName;
    private int adminPass;
    private String adminEmail;
    private Management management;
    Scanner scanner = new Scanner(System.in);
    
    public Admin(String name, int pass, String email){
        this.adminName = name;
        this.adminPass = pass;
        this.adminEmail = email;
    }
    
    public String getAdmNm(){
        return adminName;
    }
    
    public int getAdmPs(){
        return adminPass;
    }
    
    public String getAdmEmail(){
        return adminEmail;
    }
    
    public void adminInfo(){
        System.out.println("======================");
        System.out.println("Nama: " + adminName);
        System.out.println("Email: " + adminEmail);
    }
}
