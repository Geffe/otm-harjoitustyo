
package databaseTest;

import enzymes.EnzymeList;
import database.DatabaseConnection;
import org.junit.Before;
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
        assertEquals(10, list.amount());
        assertEquals("AatII", list.getEnzymes().get(0).getName());
        assertEquals("XhoI", list.getEnzymes().get(9).getName());
        
    }
    
    @Test 
    public void getDocumentWrongFile(){
        
        assertEquals(null,conn.getDocument("wrongFilepath"));
    }
    
    
}
