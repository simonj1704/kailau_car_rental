package src;
import java.sql.*;

public class DBHandler {
    public static final String database_url = "jdbc:mysql://localhost:3306/****";
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
}
