package enzymes;

import java.util.ArrayList;

/**
 * Luokka käsittelee entsyymi-listoja.
 * 
 */
public class EnzymeList {

    private ArrayList<Enzyme> enzymes;
    private int amount;

    /**
     * Luokan ainoa konstruktori, joka on parametritön, mutta 
     * alustaa muuttujat.
     */
    public EnzymeList() {
        this.enzymes = new ArrayList();
        this.amount = 0;
    }

    /**
     * Metodi tekee entsyymi-listasta String-muuttujan, joka sisältää
     * entsyymien nimet.
     * @return String-muuttujan entsyymien nimistä
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; this.enzymes.size() > i; i++) {
            result += " " + this.enzymes.get(i).getName();
        }
        return result;
    }
    
    /**
     * Metodi muuttaa luokan entsyymi-listan parametrina saaduksi listaksi.
     * (Metodilla on käyttöä jatkokehityksessä.)
     * @param enzymes lista
     */
    public void setEnzymes(ArrayList<Enzyme> enzymes) {
        this.enzymes = enzymes;
        amount += enzymes.size();
    }

    /**
     * Metodi lisää luokan entsyymi-listaan uuden entsyymin.
     * @param enzyme 
     */
    public void addEnzyme(Enzyme enzyme) {
        this.enzymes.add(enzyme);
        this.amount += 1;
    }

    /**
     * Palauttaa koko listan ensyymeistä.
     * @return Entsyymi-listan
     */
    public ArrayList<Enzyme> getEnzymes() {
        return enzymes;
    }

    /**
     * Metodi etsii entsyymi-listasta nimen mukaan.
     * @param enzymeName entsyymin nimi
     * @return true, jos listasta löytyy parametrina annetun niminen entsyymi,
     * muuten false
     */
    public boolean searchName(String enzymeName) {
        for (int i = 0; i < enzymes.size(); i++) {
            if (enzymes.get(i).getName().equals(enzymeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi etsii entsyymi-listasta sekvenssin mukaan.
     * @param enzymeSequence entsyymin sekvenssi
     * @return true, jos listasta löytyy parametrina annetun sekvenssin omaava
     * entsyymi, muuten false
     */
    public boolean searchSequence(String enzymeSequence) {
        for (int i = 0; i < enzymes.size(); i++) {
            if (enzymes.get(i).getSequence().equals(enzymeSequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi etsii entsyymi-listasta syötteen mukaan entsyymin ja palauttaa sen.
     * @param id entsyymin nimi tai sekvenssi
     * @return Enzyme
     */
    public Enzyme getEnzyme(String id) {
        for (int i = 0; i < enzymes.size(); i++) {
            if ((enzymes.get(i).getName().equals(id)) || 
                    (enzymes.get(i).getSequence().equals(id))) {
                return enzymes.get(i);
            }
        }
        return null;
    }

    /**
     * Palauttaa entsyymi-listan koon.
     * @return int entsyymi-listan koko
     */
    public int amount() {
        return this.amount;
    }

}
