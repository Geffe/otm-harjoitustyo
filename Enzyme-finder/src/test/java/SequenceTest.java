
import sequence.Sequence;
import org.junit.Before;
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
    public void getSequence() {
        assertEquals("GGATCCATCCAATCTGACT", sequence.getSequence());
    }

    @Test
    public void setSequence() {
        sequence.setSequence("GATCATAGGCATTTACG");
        assertEquals("GATCATAGGCATTTACG", sequence.getSequence());
    }

    @Test
    public void fromString() {
        assertTrue(sequence.fromString("# hastag indicates comment\n"
                + "# This sequence holds \n"
                + "#   - 3x GAATTC\n"
                + "#   - 1x GGATCC\n"
                + "# Tested with regexp: ((GGATCC)|(GAATTC))\n"
                + "\n"
                + "ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGAT"));
        assertEquals("ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGAT", sequence.getSequence());

        assertFalse(sequence.fromString(""));
        
    }

    @Test
    public void fromFile() {
        assertFalse(sequence.fromFile("ACTGACTAG"));
        assertTrue(sequence.fromFile("src/main/java/ui/example_sequence.txt"));
        
     
    }
    @Test
    public void fromFileThrows() {
        // Unable to install mockito
        //Sequence aSpy = Mockito.spy(sequence);
        //Mockito.when(aSpy.readFile()).thenReturn(5l);
    
    }

    @Test
    public void createEmptySequence() {
        Sequence emptyS = new Sequence();
        assertEquals(null, emptyS.getSequence());
    }
    
    @Test
    public void fromSyote() {
        assertTrue(sequence.fromSyote("ACTGACTAG"));
        assertTrue(sequence.fromSyote("src/main/java/ui/example_sequence.txt"));
        assertTrue(sequence.fromSyote("ijnubygv"));
    }

}
