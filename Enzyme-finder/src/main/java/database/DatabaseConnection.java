package database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class DatabaseConnection {
    
    private String url;
    
    public DatabaseConnection(){
        this.url = null;
    }
 
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public void createNewDatabase(String fileName) {
 
        this.url = "jdbc:sqlite:/tmp/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                Statement stmt = conn.createStatement();
                ResultSet tables = meta.getTables(null, null, "Enzymes", null);
                
                if(!tables.next()){
                    String sql = "CREATE TABLE Enzymes"+
                                "(NAME varchar(10) PRIMARY KEY NOT NULL,"+
                                "SEQUENCE varchar(10) NOT NULL)";
                
                stmt.executeUpdate(sql);
                System.out.println("Taulu luotu");
                }
                
                
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setDefaultEnzymes(){
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("luotu yhteys");
            if (conn != null) {
                
                Statement stmt = conn.createStatement();
                
                String sql = "INSERT INTO Enzymes"+
                                "(NAME,SEQUENCE)"+
                                "(AatII,GACGTC)";
                stmt.executeUpdate(sql);
                System.out.println("lisätty entsyymi");
                
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 

}