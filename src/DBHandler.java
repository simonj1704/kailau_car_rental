package src;
import src.entities.Car;
import src.entities.Customer;

import java.sql.*;
import java.util.Scanner;

public class DBHandler {
    //todo create second rental_contract table so contracts dont disappear when deleting customers
    public static final String database_url = "jdbc:mysql://127.0.0.1:3306/kailau_car_rental";
    public static java.sql.Connection con;
    /**
     * Selects all data from customer table and prints it out
     */
    public void queryAllCustomers(){
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
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+
                        " " + rs.getString(3) + " " + rs.getString(4) +
                        " " + rs.getString(5) + " " + rs.getDate(6) +
                        " " + rs.getString(7) + " " + rs.getInt(8) +
                        " " + rs.getString(9));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Selects all data from customer tables with given search parameter and prints it
     * @param searchParameter
     */
    public void querySpecificCustomer(String searchParameter){
        try {
            con = DriverManager.getConnection(database_url,"root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT driver_license_number, customer_name, mobile_phone_number, phone_number," +
                    "email_address, driver_since_date, address, city_zip, city_name " +
                    "FROM customers " +
                    "INNER JOIN address " +
                    "USING(address) " +
                    "INNER JOIN city " +
                    "USING(city_zip) " +
                    "WHERE driver_license_number " +
                    "LIKE " + "%" + searchParameter + "%";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+
                        " " + rs.getString(3) + " " + rs.getString(4) +
                        " " + rs.getString(5) + " " + rs.getDate(6) +
                        " " + rs.getString(7) + " " + rs.getInt(8) +
                        " " + rs.getString(9));
            }
            int rows = 0;
            rows += s.executeUpdate(sql);
            System.out.println("Rows affected: " + rows);
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * deletes a customer from the database through a subquery in address table cascading on address column
     * using drivers license number as search parameter
     * @param searchParameter
     */

    public void deleteCustomerFromDatabase(String searchParameter){
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "DELETE FROM address " +
                    "WHERE address " +
                    " = (SELECT address FROM customers WHERE driver_license_number) = " + searchParameter + ")";
            s.executeUpdate(sql);
            int rows = 0;
            rows += s.executeUpdate(sql);
            System.out.println("Rows affected: " + rows);
            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
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
            String sql = "SELECT registration_number, model_name, brand_name, registration_year, " +
                    "fuel_type, car_type, odometer, available " +
                    " FROM cars " +
                    "JOIN model " +
                    "USING (model_id) " +
                    "JOIN brands " +
                    "USING (brand_id);";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                cars.append(rs.getString(1)).append(" ").append(rs.getString(2)).append(" ")
                        .append(rs.getString(3)).append(" ").append(rs.getDate(4)).append(" ")
                        .append(rs.getString(5)).append(" ").append(rs.getString(6)).append(" ")
                        .append(rs.getInt(7)).append(" ").append(rs.getBoolean(8) + "\n");
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
    public void queryRentalContracts(){
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM rental_contracts;";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getDate(2)+
                        " " + rs.getDate(3) + " " + rs.getInt(4) +
                        " " + rs.getInt(5) + " " + rs.getInt(6) +
                        " " + rs.getString(7));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * adds a customer to the kailau database using a customer object
     * @param customer
     */

    public void addCustomerToDatabase(Customer customer){
        try {
            con = DriverManager.getConnection(database_url, "root", "sesame80");
            Statement s = con.createStatement();
            String sql = "INSERT IGNORE INTO customers (driver_license_number, customer_name, mobile_phone_number, phone_number," +
                    " email_address, driver_since_date, address)" +
                    "VALUES(" + customer.getDriversLicenseNumber() + ",'" + customer.getName() + "','" +
                    customer.getMobileNumber() + "','" + customer.getMobileNumber() + "','" + customer.getPhoneNumber() +
                    "','" + customer.getDriverSinceDate() + "','" + customer.getAddress() + "')";
            String sql2 = "INSERT IGNORE INTO address (address,city_zip) " + "VALUES('" + customer.getAddress() + "'," + customer.getZipCode() +")";
            String sql3 = "INSERT IGNORE INTO city (city_zip, city_name)" + "VALUES(" + customer.getZipCode() + ",'" + customer.getCity()+ "')";
            s.executeUpdate(sql3);
            s.executeUpdate(sql2);
            s.executeUpdate(sql);
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
     * Takes a Car object as parameter and adds a car to the database and relevant tables
     * @param car
     */
    public void addCarDatabase(Car car){
        try {
            con  = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "INSERT IGNORE INTO cars(registration_number, registration_year, odometer, available, model_id) " +
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

    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();
        dbHandler.queryAllCustomers();
        dbHandler.queryRentalContracts();
        dbHandler.addCarDatabase(new Car("Mercedes", "E250", "Diesel", "AF23124", "2003-02-01", 12322, "Luxury", false));
        System.out.println(dbHandler.queryCar());
    }
}
