

import com.mycompany.enzyme.finder.Enzyme;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class EnzymeTest {
    
    Enzyme enzyme;
    
    public EnzymeTest() {
    }
    
    @Before
    public void setUp() {
        this.enzyme = new Enzyme("BamHI","GGATCC");
    }
    
    @Test
    public void getName(){
        assertEquals("BamHI", enzyme.getName());
    }
    
    @Test
    public void getSequence(){
        assertEquals("GGATCC", enzyme.getSequence());
    }
    
    @Test
    public void toStringWorks(){
        assertEquals("BamHI GGATCC", enzyme.getName()+" "+enzyme.getSequence());
    }
    
    
}
