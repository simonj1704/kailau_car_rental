package src;
import src.entities.Customer;

import java.sql.*;
import java.util.Scanner;

public class DBHandler {
    public static final String database_url = "jdbc:mysql://localhost:3306/kailau_car_rental";
    public static java.sql.Connection con;

    public void openDatabase() {
        try {
            con = DriverManager.getConnection(database_url, "Username", "Password");
            Statement s = con.createStatement();
            String sql = "Database Query Her";
            ResultSet rs = s.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    public void addCustomer(){
        try {
            Customer customer;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter customer name:");
            String name = in.nextLine();
            System.out.println("Enter customer address:");
            String address = in.nextLine();
            System.out.println("Enter customer zip code");
            String zipCode = in.nextLine();
            System.out.println("Enter customer city");
            String city = in.nextLine();
            System.out.println("Enter customer mobile number");
            String mobileNumber = in.nextLine();
            System.out.println("Enter customer phone number");
            String phoneNumber = in.nextLine();
            System.out.println("Enter customer e-mail:");
            String emailAddress = in.nextLine();
            System.out.println("Enter customer drivers license number");
            String driversLicenseNumber = in.nextLine();
            System.out.println("Enter 'driver since date' in the format of YYYY-MM-DD");
            String driverSinceDate = in.nextLine();

            new Customer(name,address,zipCode,city,mobileNumber,phoneNumber,emailAddress,driversLicenseNumber, driverSinceDate);

            con = DriverManager.getConnection(database_url, "root", "sesame80");
            Statement s = con.createStatement();
            String sql = "INSERT INTO customers (driver_license_number, customer_name, mobile_phone_number, phone_number, email_address, driver_since_date, address)" +
                    "VALUES(" + driversLicenseNumber + ",'" + name + "','"+ mobileNumber + "','" + phoneNumber + "','" +
                    emailAddress + "','" + driverSinceDate + "','" + address + "')";
            String sql2 = "INSERT INTO address (address,city_zip) " + "VALUES('" + address + "'," + zipCode +")";
            String sql3 = "INSERT INTO city (zip, city)" + "VALUES(" + zipCode + ",'" + city + "')";
            s.executeUpdate(sql3);
            s.executeUpdate(sql2);
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

    }

}
