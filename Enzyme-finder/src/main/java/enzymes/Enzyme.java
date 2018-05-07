
package enzymes;


public class Enzyme {
    
    private final String name;
    private final String sequence;
    
    public Enzyme(String name, String sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public String getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return name + " " + sequence; 
    }
    
    
}
