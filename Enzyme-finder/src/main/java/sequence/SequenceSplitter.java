package sequence;

import enzymes.EnzymeList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Luokka muokkaa sekvenssiä ja etsii siitä entsyymien kohdat.
 * 
 */
public class SequenceSplitter {

    /*
        1. anna splittausentsyymit
        2. rakenna regexp niiden perusteella
        3. splittaa annettu sequence
     */
    private final String regex;
    private final EnzymeList list;
    private String sequence;

    /**
     * Luokan ainoa konstruktori, joka saa parametrinä entsyymi-listan,
     * joiden entsyymien mukaan sekvenssiä muokataan.
     * @param list 
     */
    public SequenceSplitter(EnzymeList list) {
        this.list = list;
        this.sequence = "";
        this.regex = regexBuilder();
    }
    /**
     * Metodi luo entsyymi-listn perusteella regex-muuttujan, joka
     * etsii sekvenssistä annetun listan entsyymit.
     * @return regexString muodostettuna entsyymien mukaan
     */
    public String regexBuilder() {
        String regexString = "";
        for (int i = 0; i < list.getEnzymes().size(); i++) {
            regexString += "(" + list.getEnzymes().get(i).getSequence() + ")";
            if (!(i + 1 == list.getEnzymes().size())) {
                regexString += "|";
            }
        }
        return regexString;
    }
    
    /**
     * Metodi etsii halutusta sekvenssistä halutut entsyymit ja korvaa
     * sekvenssistä löytyvät enstsyymien sekvenssit entsyymien nimillä.
     * @param originalSequence sekvenssi, josta etsitään entsyymit
     * @return sequence muokattu sekvenssi
     */
    public String split(String originalSequence) {

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(originalSequence);

        while (matcher.find()) {
            this.sequence = this.sequence.replaceAll(matcher.group(),
                    "**" + list.getEnzyme(matcher.group()).getName() + "**");
        }
      
        return this.sequence;

    }

    /**
     * Metodi asettaa luokassa muokattavan sekvenssin.
     * @param sequence 
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

//    public String getSequence() {
//        return this.sequence;
//    }

}
