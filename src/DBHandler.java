package src;
import src.entities.Car;
import src.entities.Customer;
import src.entities.Rental;

import java.sql.*;
import java.util.Scanner;

public class DBHandler {
    public static final String database_url = "jdbc:mysql://127.0.0.1:3306/kailau_car_rental";
    public static java.sql.Connection con;
    /**
     * Selects all data from customer table and prints it out
     */
    public String queryCustomers(){
        StringBuilder customers = new StringBuilder();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT driver_license_number, customer_name, mobile_phone_number, phone_number, " +
                    "email_address, driver_since_date, address, city_zip, city_name " +
                    "FROM customers " +
                    "JOIN address " +
                    "USING(address) " +
                    "JOIN city " +
                    "USING(city_zip) " +
                    "ORDER BY customer_name;";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                customers.append(rs.getInt(1)).append(" ").append(rs.getString(2))
                        .append(" ").append(rs.getString(3)).append(" ").append(rs.getString(4))
                        .append(" ").append(rs.getString(5)).append(" ").append(rs.getDate(6))
                        .append(" ").append(rs.getString(7)).append(" ").append(rs.getInt(8))
                        .append(" ").append(rs.getString(9));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return customers.toString();
    }

    /**
     * Selects all data from brands table and prints it out
     */
    public void queryBrands() {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM brands ORDER BY brand_id";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }


    /**
     * Selects all data from car table and prints it out
     */
    public String queryCar() {
        StringBuilder cars = new StringBuilder();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT registration_number, model_name, brand_name, YEAR(registration_year), " +
                    "fuel_type, car_type, odometer, rented " +
                    " FROM cars " +
                    "JOIN model " +
                    "USING (model_id) " +
                    "JOIN brands " +
                    "USING (brand_id);";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                cars.append(rs.getString(1)).append(" ").append(rs.getString(2)).append(" ").
                        append(rs.getString(3)).append(" ").append(rs.getInt(4)).append(" ").
                        append(rs.getString(5)).append(" ").append(rs.getString(6)).
                        append(" ").append(rs.getInt(7)).append("Km ");
                if (rs.getString(8).equals("1")){
                    cars.append("YES").append("\n");
                } else {
                    cars.append("NO").append("\n");
                }
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return cars.toString();
    }


    /**
     * Selects all data from rental contracts and prints it out
     */
    public String queryRentalContracts(){
        StringBuilder contracts = new StringBuilder();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM rental_contracts;";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                contracts.append(rs.getInt(1)).append(" ").append(rs.getDate(2)).
                        append(" ").append(rs.getDate(3)).append(" ").append(rs.getInt(4)).
                        append("Km ").append(rs.getInt(5)).append("Km ").append(rs.getInt(6)).
                        append(" ").append(rs.getString(7) + "\n");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return contracts.toString();
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
            String sql3 = "INSERT INTO city (city_zip, city_name)" + "VALUES(" + zipCode + ",'" + city + "')";
            s.executeUpdate(sql3);
            s.executeUpdate(sql2);
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

    }

    /**
     * Takes a Car object as parameter and adds a car to the database and relevant tables
     * @param car
     */
    public void addCarDatabase(Car car){
        try {
            con  = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "INSERT IGNORE INTO cars(registration_number, registration_year, odometer, rented, model_id) " +
                    "VALUES ('" + car.getRegistrationNumber() + "','" + car.getRegistrationYear() + "'," +
                    car.getOdometer() + "," + car.isRented() + ", (SELECT model_id FROM model WHERE model_name = '" + car.getModel() + "'));";
            String sql2 = "INSERT INTO brands(brand_id, brand_name) " +
                    "VALUES ((SELECT MAX(brand_id)+1 FROM brands brn), '" + car.getBrand() + "') " +
                    "ON DUPLICATE KEY UPDATE " +
                    "brand_name = brand_name;";
            String sql3 = "INSERT INTO model(model_id, model_name, fuel_type, car_type, brand_id) " +
                    "VALUES ((SELECT MAX(model_id)+1 FROM model mdl), " +
                    "'" + car.getModel() + "', '" + car.getFuelType() + "', '" + car.getType() + "', " +
                    "(SELECT brand_id FROM brands WHERE brand_name = '" + car.getBrand() + "')) " +
                    "ON DUPLICATE KEY UPDATE " +
                    "model_name = model_name;";

            int rows = 0;
            rows += s.executeUpdate(sql2);
            rows += s.executeUpdate(sql3);
            rows += s.executeUpdate(sql);
            System.out.println("Rows affected: " + rows);

            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Takes a rental object as parameter and adds a rental to the database and relevant tables
     * @param rental
     */
    public void addRentalDatabase(Rental rental) {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "INSERT INTO rental_contracts(from_date, to_date, max_km, km_on_start, " +
                    "driver_license_number, registration_number)"
                    + "VALUES ('" + rental.getFromDate() + "','" + rental.getToDate() + "','" + rental.getMaxKm() + "','"
                    + rental.getKm() + "','" + rental.getDriverLicenseNumber() + "','"
                    + rental.getCarRegistrationNumber() + "')";

            System.out.println("rows affected: " + s.executeUpdate(sql));
            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();

        dbHandler.queryRentalContracts();
        dbHandler.addRentalDatabase(new Rental("2000-9-12", "2000-10-11",
                23235564, 103, 200, "AX63648"));
    }
}
