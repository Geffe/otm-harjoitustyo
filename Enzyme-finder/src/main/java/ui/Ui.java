package ui;

import enzymes.EnzymeList;
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

//    public Sequence getSequence() {
//
//        System.out.println("Syötä sekvenssi tai tiedostopolku");
//        String syote = this.lukija.nextLine();
//        System.out.println("");
//        Sequence sequence = new Sequence();
//
//        while (true) {
//
//            if (sequence.fromFile(syote) || sequence.fromString(syote)) {
//                //System.out.println(sequence.getSequence());
//                return sequence;
//
//            } else {
//                System.out.println("Syötettä ei voida lukea, anna uusi");
//                syote = this.lukija.nextLine();
//
//            }
//        }
//    }
    public String askSequenceOrPath() {

        System.out.println("Syötä sekvenssi tai tiedostopolku");
        String syote = this.lukija.nextLine();
        System.out.println("");
        return syote;

    }

    /**
     * Jos annettua syötettä ei pystytty lukemaan, kysyy uudestaan
     * tiedostopolkua tai sekvenssiä
     * @return syöte
     */
    public String reAskSequenceOrPath() {

        System.out.println("Syötettä ei voida lukea, anna uusi");
        String syote = this.lukija.nextLine();
        System.out.println("");
        return syote;

    }

    public void listEnzymes(EnzymeList list) {
        System.out.println("Entsyymit: ");
        System.out.println(list);
        System.out.println("");
    }

    public EnzymeList getSplittingEnzymes(EnzymeList enzymes) {

        EnzymeList selectedEnzymes = new EnzymeList();

        while (true) {

            System.out.println("Syötä etsittävän entsyymin nimi tai x");
            String syote = this.lukija.nextLine();

            if (syote.equals("x") && selectedEnzymes.amount() == 0) {
                System.out.println("Mitään entsyymiä ei ole valittu");
            } else if (syote.equals("x")) {
                System.out.println("");
                break;
            } else if (enzymes.searchName(syote)) {
                selectedEnzymes.addEnzyme(enzymes.getEnzyme(syote));
            } else {
                System.out.println("Syötettä ei voitu valita");
            }
        }
        return selectedEnzymes;
    }

    public void printResult(String text) {
        System.out.println(text);
        System.out.println("_________________________");
        System.out.println("");

    }

    public boolean quit() {

        while (true) {
            System.out.println("Syötä: jatka/lopeta");
            String syote = this.lukija.nextLine();

            if (syote.equals("jatka")) {
                System.out.println("");
                return false;
            } else if (syote.equals("lopeta")) {
                return true;
            }
        }
    }

}
