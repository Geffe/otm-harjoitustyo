
package ui;


import com.mycompany.enzyme.finder.EnzymeList;
import com.mycompany.enzyme.finder.Sequence;
import java.util.Scanner;

public class Ui {

    private Scanner lukija;

    public Ui(Scanner lukija) {
        this.lukija = lukija;
    }

    public Sequence getSequence() {
        //sekvenssi on asetettu vielä valmiiksi kokeilun helpottamiseksi
        System.out.println("Syötä sekvenssi: ");
        Sequence input = new Sequence("ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGATGTGCAC");
        //                                 -EcoRI-     -EcoRI-         -BamHI-      -EcoRI-   -ApaLI-
        System.out.println(input.getSequence());
        return input;

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
