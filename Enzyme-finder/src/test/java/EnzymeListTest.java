

import enzymes.Enzyme;
import enzymes.EnzymeList;
import java.util.ArrayList;
import org.junit.Before;
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
    public void setEnzymes(){
        ArrayList<Enzyme> enzymes = new ArrayList();
        enzymes.add(new Enzyme("BamHI","GGATCC"));
        enzymes.add(new Enzyme("EcoRI", "GAATTC"));
        
        list.setEnzymes(enzymes);
        
        assertEquals(2, list.amount());
    }
    
    @Test
    public void addEnzyme(){
        list.addEnzyme(new Enzyme("BamHI","GGATCC"));
        assertEquals(1,list.amount());
        
        list.addEnzyme(new Enzyme("EcoRI", "GAATTC"));
        assertEquals(2, list.amount());
    }
    
    @Test
    public void getEnzyme(){
        Enzyme enzyme = new Enzyme("BamHI","GGATCC");
        list.addEnzyme(enzyme);
        assertEquals(enzyme,list.getEnzyme("GGATCC"));
        assertEquals(enzyme,list.getEnzyme("BamHI"));
        assertEquals(null,list.getEnzyme("XX"));
    }
    
    @Test
    public void getEnzymes(){
        ArrayList<Enzyme> enzymes = new ArrayList();
        enzymes.add(new Enzyme("BamHI","GGATCC"));
        enzymes.add(new Enzyme("EcoRI", "GAATTC"));
        list.setEnzymes(enzymes);
        
        assertEquals(enzymes, list.getEnzymes());
    }
    
    @Test
    public void searchNameToimii(){
        list.addEnzyme(new Enzyme("BamHI","GGATCC"));
        assertTrue(list.searchName("BamHI"));
        assertFalse(list.searchName(""));
    }
    
    @Test
    public void searchSequenceWorks(){
        list.addEnzyme(new Enzyme("BamHI","GGATCC"));
        assertTrue(list.searchSequence("GGATCC"));
        assertFalse(list.searchSequence(""));
    }
}
