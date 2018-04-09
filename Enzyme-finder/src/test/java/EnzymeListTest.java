

import com.mycompany.enzyme.finder.Enzyme;
import com.mycompany.enzyme.finder.EnzymeList;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class EnzymeListTest {
    
    EnzymeList list;
    
    public EnzymeListTest() {
    }
    

    
    @Before
    public void setUp() {
        list = new EnzymeList();
        
    }
    
    @Test
    public void toStringToimii(){
        ArrayList<Enzyme> enzymes = new ArrayList();
        enzymes.add(new Enzyme("BamHI","GGATCC"));
        enzymes.add(new Enzyme("EcoRI", "GAATTC"));
        list.setEnzymes(enzymes);
        
        assertEquals(" BamHI EcoRI",list.toString());
    }
    
    @Test
    public void lisaaListan(){
        ArrayList<Enzyme> enzymes = new ArrayList();
        enzymes.add(new Enzyme("BamHI","GGATCC"));
        enzymes.add(new Enzyme("EcoRI", "GAATTC"));
        
        list.setEnzymes(enzymes);
        
        assertEquals(2, list.amount());
    }
    
    @Test
    public void lisaaYhden(){
        list.addEnzyme(new Enzyme("BamHI","GGATCC"));
        assertEquals(1,list.amount());
    }
    
    @Test
    public void searchNameToimii(){
        list.addEnzyme(new Enzyme("BamHI","GGATCC"));
        assertTrue(list.searchName("BamHI"));
        assertFalse(list.searchName(""));
    }
}
