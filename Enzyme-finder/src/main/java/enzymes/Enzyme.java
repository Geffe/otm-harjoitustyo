
package enzymes;

/**
 * Luokka käsittelee yksittäisiä entsyymejä.
 * 
 */
public class Enzyme {
    
    private final String name;
    private final String sequence;
    
    /**
     * Luokan ainoa konstruktori, joka saa kaksi parametriä.
     * @param name entsyymin nimi
     * @param sequence entsyymin sekvenssi
     */
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
