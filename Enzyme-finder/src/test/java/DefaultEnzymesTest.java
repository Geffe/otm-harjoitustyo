


import enzymes.EnzymeList;
import enzymes.DefaultEnzymes;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DefaultEnzymesTest {
    
    DefaultEnzymes defaultEnzymes;
    
    public DefaultEnzymesTest() {
    }
    
    
    @Before
    public void setUp() {
        this.defaultEnzymes = new DefaultEnzymes();
    }
    
    @Test
    public void getEnzymesFromXML(){
        EnzymeList list = this.defaultEnzymes.getEnzymesFromXML();
        assertEquals(10, list.amount());
        assertEquals("AatII", list.getEnzymes().get(0).getName());
        assertEquals("XhoI", list.getEnzymes().get(9).getName());   
    }
    
//    @Test
//    public void getEnzymesFromXMLFileNotFound(){
//        this.defaultEnzymes.defaultXmlFilePath = "foobar";
//        EnzymeList list = this.defaultEnzymes.getEnzymesFromXML();
//        assertEquals(null, list);
//          
//    }
    
//    @Test 
//    public void getDocumentWrongFile(){
//        
//        assertEquals(null,defaultEnzymes.getDocument("wrongFilepath"));
//    }
    
    
}
