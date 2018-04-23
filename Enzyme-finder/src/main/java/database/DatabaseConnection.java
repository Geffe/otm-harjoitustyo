package database;
import com.mycompany.enzyme.finder.Enzyme;
import com.mycompany.enzyme.finder.EnzymeList;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
 
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
//    public void createNewDatabase(String fileName) {
// 
//        this.url = "jdbc:sqlite:/tmp/" + fileName;
// 
//        try (Connection conn = DriverManager.getConnection(url)) {
//            if (conn != null) {
//                DatabaseMetaData meta = conn.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created.");
//                Statement stmt = conn.createStatement();
//                ResultSet tables = meta.getTables(null, null, "Enzymes", null);
//                
//                if(!tables.next()){
//                    String sql = "CREATE TABLE Enzymes"+
//                                "(NAME varchar(10) PRIMARY KEY NOT NULL,"+
//                                "SEQUENCE varchar(10) NOT NULL)";
//                
//                stmt.executeUpdate(sql);
//                System.out.println("Taulu luotu");
//                }
//                
//                
//            }
// 
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    public EnzymeList getEnzymesFromXML() {
        try {
            File file = new File("src/main/java/database/defaultEnzymes.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory
                    .newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList enzymes = document.getElementsByTagName("Enzyme");
            
            EnzymeList list = new EnzymeList();

            for (int i = 0; i < enzymes.getLength(); i++) {
                
                String enzyme_text = enzymes.item(i).getTextContent();
                Element fstElmnt = (Element)enzymes.item(i);
                String enzyme_name = fstElmnt.getAttribute("name");
                Enzyme enzyme = new Enzyme(enzyme_name, enzyme_text);
//                System.out.println(enzyme.toString());
//                System.out.println(enzyme_text);
//                System.out.println(enzyme_name);
                list.addEnzyme(enzyme);
            }
            
            return list;
            
        } catch (ParserConfigurationException | SAXException | IOException e) {           
            e.printStackTrace();
        }
        
        return null;
    }
    
//    public void setDefaultEnzymes(){
//        try (Connection conn = DriverManager.getConnection(url)) {
//            System.out.println("luotu yhteys");
//            if (conn != null) {
//                
//                Statement stmt = conn.createStatement();
//                
//                String sql = "INSERT INTO Enzymes"+
//                                "(NAME,SEQUENCE)"+
//                                "(AatII,GACGTC)";
//                stmt.executeUpdate(sql);
//                System.out.println("lisätty entsyymi");
//                
//            }
// 
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
 

}