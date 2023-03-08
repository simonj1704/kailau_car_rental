package src;
import java.sql.*;

public class DBHandler {
    public static final String database_url = "jdbc:mysql://127.0.0.1:3306/kailau_car_rental";
    public static java.sql.Connection con;

    /**
     * Selects all data from customer table and prints it out
     */
    public void queryCustomerTable(){
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM customers";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+
                        " " + rs.getString(3) + " " + rs.getString(4) +
                        " " + rs.getString(5) + " " + rs.getDate(6) +
                        " " + rs.getString(7) + " " + rs.getInt(8));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Selects all data from brands table and prints it out
     */
    public void queryBrandsTable() {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM brands";
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
    public void queryCarTable() {
        try {
            con = DriverManager.getConnection(database_url, "root", "password");
            Statement s = con.createStatement();
            String sql = "SELECT registration_number, registration_year, odometer, available,\n" +
                    "\tmodel_name, fuel_type, car_type, brand_name\n" +
                    " FROM cars\n" +
                    "\tJOIN model\n" +
                    "\t\tUSING (model_id)\n" +
                    "\tJOIN brands\n" +
                    "\t\tUSING (brand_id);";
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getDate(2)+
                        " " + rs.getInt(3) + " " + rs.getInt(4) +
                        " " + rs.getString(5) + " " + rs.getString(6) +
                        " " + rs.getString(7) + " " + rs.getString(8));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
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

    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();
        dbHandler.queryCustomerTable();
        dbHandler.queryRentalContracts();
    }
}
