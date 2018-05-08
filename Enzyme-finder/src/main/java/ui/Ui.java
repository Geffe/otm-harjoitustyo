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

        System.out.println("Syötä sekvenssi tai tiedostopolku");
        String syote = this.lukija.nextLine();
        Sequence sequence = new Sequence();

        while (true) {

            if (sequence.fromFile(syote) || sequence.fromString(syote)) {
                //System.out.println(sequence.getSequence());
                return sequence;

            } else {
                System.out.println("Syötettä ei voida lukea, anna uusi");
                syote = this.lukija.nextLine();

            }
        }
    }

    public void listEnzymes(EnzymeList list) {
        System.out.println("Entsyymit: ");
        System.out.println(list);
        System.out.println("");
    }

    public EnzymeList getSplittingEnzymes(EnzymeList enzymes) {

        EnzymeList valitut = new EnzymeList();

        while (true) {
           
            System.out.println("Syötä etsittävän entsyymin nimi tai x");
            String syote = this.lukija.nextLine();

            if (syote.equals("x")) {
                System.out.println("");
                break;
            } else if (enzymes.searchName(syote)) {
                valitut.addEnzyme(enzymes.getEnzyme(syote));
            }  else {
                System.out.println("Syötettä ei voitu valita");
            }
        }
        return valitut;
    }

    public void printResult(String text) {
        System.out.println(text);
    }

}
