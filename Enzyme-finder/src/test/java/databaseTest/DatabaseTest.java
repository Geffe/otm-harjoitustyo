
package databaseTest;

import enzymes.EnzymeList;
import database.DatabaseConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DatabaseTest {
    
    DatabaseConnection conn;
    
    public DatabaseTest() {
    }
    
    
    
    
    
    @Before
    public void setUp() {
        this.conn = new DatabaseConnection();
    }
    
    @Test
    public void getEnzymesFromXML(){
        EnzymeList list = this.conn.getEnzymesFromXML();
        assertEquals("EcoRI", list.getEnzymes().get(0).getName());
        
    }
    
    
}
