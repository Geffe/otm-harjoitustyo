

import sequence.Sequence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SequenceTest {
    
    Sequence sequence;
    
    public SequenceTest() {
    }
    

    
    @Before
    public void setUp() {
        sequence = new Sequence("GGATCCATCCAATCTGACT");
    }
    
    @Test
    public void getSequence(){
        assertEquals("GGATCCATCCAATCTGACT", sequence.getSequence());
    }
    
    @Test
    public void setSequence(){
        sequence.setSequence("GATCATAGGCATTTACG");
        assertEquals("GATCATAGGCATTTACG", sequence.getSequence());
    }
    
    @Test
    public void editSequence(){
        sequence.editSequence("GGATC");
        assertEquals("GGATCCATCCAATCTGACTGGATC", sequence.getSequence());
    }
 
}
