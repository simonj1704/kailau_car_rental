package src;

import src.entities.Car;
import src.entities.Customer;
import src.entities.Rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBHandler {
    public static final String database_url = "jdbc:mysql://127.0.0.1:3306/kailau_car_rental";
    public static java.sql.Connection con;

    /**
     * Selects all data from customer table and prints it out
     */
    public ArrayList<Customer> queryCustomers() {
        ArrayList<Customer> customersList = new ArrayList<>();
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

            while (rs.next()) {
                customersList.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9)));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return customersList;
    }

    /**
     * Selects all data from customer tables with given search parameter and prints it
     *
     * @param searchParameter Driver License Number
     */
    public ArrayList<Customer> querySpecificCustomer(String searchParameter) {
        ArrayList<Customer> specificCustomerList = new ArrayList<>();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT driver_license_number, customer_name, mobile_phone_number, phone_number," +
                    "email_address, driver_since_date, address, city_zip, city_name " +
                    "FROM customers " +
                    "INNER JOIN address " +
                    "USING(address) " +
                    "INNER JOIN city " +
                    "USING(city_zip) " +
                    "WHERE driver_license_number " +
                    "LIKE " + "%" + searchParameter + "%" +
                    " OR customer_name LIKE '%" + searchParameter + "';";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                specificCustomerList.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            int rows = 0;
            rows += s.executeUpdate(sql);
            System.out.println("Rows affected: " + rows);
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return specificCustomerList;
    }
    public ArrayList<Rental> querySpecificRentalContract(String searchParameter){
        ArrayList<Rental> specificRentalContracts = new ArrayList<>();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT id_rental_contract, from_date, to_date, max_km, km_on_start, " +
                    " driver_license_number, customer_name, registration_number " +
                    "FROM rental_contracts " +
                    "INNER JOIN customers " +
                    "USING(driver_license_number) " +
                    "WHERE driver_license_number " +
                    "LIKE '%" + searchParameter + "%' " +
                    "OR registration_number LIKE '%" + searchParameter + "%' " +
                    "OR id_rental_contract LIKE '%" + searchParameter + "%';";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                specificRentalContracts.add(new Rental(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(6),
                        rs.getString(7), rs.getInt(4), rs.getInt(5), rs.getString(8)));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return specificRentalContracts;
    }
    public ArrayList<Car> querySpecificCar(String searchParameter){
        ArrayList<Car> specificCar = new ArrayList<>();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT * " +
                    "FROM cars " +
                    "INNER JOIN model " +
                    "USING(model_id) " +
                    "INNER JOIN brands " +
                    "USING(brand_id) " +
                    "WHERE registration_number " +
                    "LIKE " + "'%" + searchParameter + "%'";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                specificCar.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getString(7), rs.getBoolean(8)));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return specificCar;

    }

    /**
     * deletes a customer from the database through a subquery in address table cascading on address column
     * using driver license number as search parameter
     *
     * @param searchParameter Driver license number
     */
    public void deleteCustomerFromDatabase(String searchParameter) {
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

            while (rs.next()) {
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
    public ArrayList<Car> queryCar() {
        ArrayList<Car> cars = new ArrayList<>();
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

            while (rs.next()) {
                cars.add(new Car(rs.getString(3), rs.getString(2), rs.getString(5),
                        rs.getString(1), rs.getString(4), rs.getInt(7),
                        rs.getString(6), rs.getBoolean(8)));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return cars;
    }


    /**
     * Selects all data from rental contracts and prints it out
     */
    public ArrayList<Rental> queryRentalContracts() {
        ArrayList<Rental> rentalList = new ArrayList<>();
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT id_rental_contract, from_date, to_date, max_km, km_on_start, " +
                    " driver_license_number, customer_name, registration_number " +
                    "FROM rental_contracts " +
                    "INNER JOIN customers " +
                    "USING(driver_license_number);";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                rentalList.add(new Rental(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(6),
                        rs.getString(7), rs.getInt(4), rs.getInt(5), rs.getString(8)));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return rentalList;
    }

    /**
     * adds a customer to the kailau database using a customer object
     *
     * @param customer to be added to database
     */
    public void addCustomerToDatabase(Customer customer) {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "INSERT IGNORE INTO customers (driver_license_number, customer_name, mobile_phone_number, phone_number," +
                    " email_address, driver_since_date, address)" +
                    "VALUES(" + customer.getDriversLicenseNumber() + ",'" + customer.getName() + "','" +
                    customer.getMobileNumber() + "','" + customer.getPhoneNumber() + "','" + customer.getEmail() +
                    "','" + customer.getDriverSinceDate() + "','" + customer.getAddress() + "')";
            String sql2 = "INSERT IGNORE INTO address (address,city_zip) " + "VALUES('" + customer.getAddress() + "'," + customer.getZipCode() + ")";
            String sql3 = "INSERT IGNORE INTO city (city_zip, city_name)" + "VALUES(" + customer.getZipCode() + ",'" + customer.getCity() + "')";
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
     *
     * @param car object to be used to add car to database
     */
    public void addCarDatabase(Car car) {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
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
     *
     * @param rental object to be added to database
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

    public void deleteCarFromDatabase(String searchParameter) {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "DELETE FROM cars " +
                    "WHERE registration_number " +
                    " = " + searchParameter + ")";
            s.executeUpdate(sql);
            int rows = 0;
            rows += s.executeUpdate(sql);
            System.out.println("Rows affected: " + rows);
            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

    }

}
