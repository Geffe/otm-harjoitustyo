
import enzymes.Enzyme;
import enzymes.EnzymeList;
import sequence.SequenceSplitter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SequenceSplitterTest {
    
    SequenceSplitter splitter;
    
    public SequenceSplitterTest() {
    }
    

    
    @Before
    public void setUp() {
        EnzymeList list = new EnzymeList();
        list.addEnzyme(new Enzyme("BamHI","GGATCC"));
        list.addEnzyme(new Enzyme("EcoRI", "GAATTC"));
        splitter = new SequenceSplitter(list);
        
    }
    
    @Test
    public void regexBuilder(){
        assertEquals("(GGATCC)|(GAATTC)", splitter.regexBuilder());
        
    }
    
    @Test
    public void split(){
        splitter.setSequence("CTAGGATCCTCGGAATTCCT");
        splitter.split("CTAGGATCCTCGGAATTCCT");
        assertEquals("CTA**BamHI**TCG**EcoRI**CT", splitter.getSequence());
    }
    

}
