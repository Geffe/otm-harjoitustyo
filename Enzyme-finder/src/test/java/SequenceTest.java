
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
    public void editSequence() {
        sequence.editSequence("GGATC");
        assertEquals("GGATCCATCCAATCTGACTGGATC", sequence.getSequence());
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
    public void fromFile(){
        assertFalse(sequence.fromFile("ACTGACTAG"));
        //muuta
        assertTrue(sequence.fromFile("/home/ninna/OTM/otm-harjoitustyo/Enzyme-finder/src/test/java/example_sequence.txt"));
    }
    
//    @Test
//    public void readFile(){
//        String text = sequence.readFile("/home/ninna/OTM/otm-harjoitustyo/Enzyme-finder/src/test/java/example_sequence.txt", StandardCharsets.UTF_8);
//    }
    @Test
    public void createEmptySequence(){
        Sequence emptyS = new Sequence();
        assertEquals(null, emptyS.getSequence());
    }
    
}
