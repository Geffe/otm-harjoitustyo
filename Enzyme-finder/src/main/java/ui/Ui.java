
package ui;


import enzymes.EnzymeList;
import sequence.Sequence;
import java.util.Scanner;

/**
 * Käyttöliittymä
 * 
 */
public class Ui {

    private final Scanner lukija;

    public Ui(Scanner lukija) {
        this.lukija = lukija;
    }

    public Sequence getSequence() {
        String syote;
        //sekvenssi on asetettu vielä valmiiksi kokeilun helpottamiseksi
        System.out.println("Syötä sekvenssi tai tiedostopolku");
        syote = this.lukija.nextLine();
        Sequence sequnece = new Sequence();

        //tiedoston luku keskeneräinen, sekvenssin luku onnistuu
        while (true) {
            // Sequence input = new Sequence("ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGATGTGCAC");
            //                                 -EcoRI-     -EcoRI-         -BamHI-      -EcoRI-   -ApaLI-
            if (sequnece.fromFile(syote)) {
                System.out.println(sequnece.getSequence());
                return sequnece;
            } else if (sequnece.fromString(syote)) {
                System.out.println(sequnece.getSequence());
                return sequnece;
            } else {
                System.out.println("Anna parempi syote!");
                syote = this.lukija.nextLine();

            }
                   
        
        }
    }

    public void listEnzymes(EnzymeList list) {
        System.out.println("Entsyymit: ");
        System.out.println(list);
    }

    public EnzymeList getSplittingEnzymes(EnzymeList enzymes) {

        EnzymeList valitut = new EnzymeList();

        while (true) {
            //kokeilun helpottamiseksi asetettu näin vielä
            System.out.println("Syötä halutun entsyymin nimi tai lopeta");
            String syote = this.lukija.nextLine();

            if (syote.equals("lopeta")) {
                break;
            } else if (enzymes.searchName(syote)) {
                valitut.addEnzyme(enzymes.getEnzyme(syote));
            } else if (syote.isEmpty() && valitut.getEnzymes().isEmpty()) {
                valitut.addEnzyme(enzymes.getEnzyme("BamHI"));
                System.out.println("Käytetään oletusentsyymiä BamHI");
                break;
            } else {
                System.out.println("Käytä parempia arvoja tyhmä!");
            }
        }
        return valitut;
    }

    public void printResult(String text) {
        System.out.println(text);
    }

}
