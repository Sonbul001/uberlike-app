import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ride {
    private int ID;
    private String source;
    private String destination;
    private Customer customer;
    private Driver driver;
    private boolean isCompleted = false;

    public Ride(String source, String destination, Customer customer, Driver driver){
        this.source = source;
        this.destination = destination;
        this.customer = customer;
        this.driver = driver;
        String sql = "INSERT INTO Rides (customerID, driverID, source, destination) VALUES ('" + customer.getUserName() + "', '" + driver.getUserName() + "', '" + source + "', '" + destination + "')";
        String sql2 = "SELECT ID FROM Rides WHERE customerID='" + customer.getUserName() + "' AND driverID='" + driver.getUserName() +"' AND source='" + source +"' AND destination='"+destination +"'";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.executeQuery(sql2);
            rs.next();
            this.ID = rs.getInt("ID");
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        
    }
    public void completed(){
        isCompleted = true;
        String sql = "UPDATE Rides SET isCompleted= true WHERE ID=" + ID;
        String sql2 = "DELETE FROM Offers WHERE customerID='" + customer.getUserName() + "' AND driverID='" + driver.getUserName() +"' AND source='" + source +"' AND destination='"+destination +"'";
        String sql3 = "DELETE FROM Requests WHERE customerID='" + customer.getUserName() + "' AND source='" + source +"' AND destination='"+destination +"'";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.execute(sql2);
            stmt.execute(sql3);
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:uberlike.db";
        try {
            conn = DriverManager.getConnection(url);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
