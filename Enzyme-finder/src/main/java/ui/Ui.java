package ui;

import enzymes.EnzymeList;
import java.util.Scanner;

/**
 * Käyttöliittymä
 *
 */
public class Ui {

    private final Scanner sc;

    /**
     * Luokan ainoa konstruktori, joka saa parametrinä Scanner-olion.
     * @param sc lukee käyttäjän syötteet
     */
    public Ui(Scanner sc) {
        this.sc = sc;
    }


    /**
     * Metodi kysyy käyttäjältä tiedostopolkua tai sekvenssiä.
     * @return käyttäjän syöte
     */
    public String askSequenceOrPath() {

        System.out.println("Syötä sekvenssi tai tiedostopolku");
        String syote = this.sc.nextLine();
        System.out.println("");
        return syote;

    }

    /**
     * Jos annettua syötettä ei pystytty lukemaan, kysyy uudestaan
     * tiedostopolkua tai sekvenssiä
     * @return käyttäjän syöte
     */
    public String reAskSequenceOrPath() {

        System.out.println("Syötettä ei voida lukea, anna uusi");
        String syote = this.sc.nextLine();
        System.out.println("");
        return syote;

    }

    /**
     * Metodi tulostaa entsyymi-listan sisällön.
     * @param list entsyymi-lista
     */
    public void listEnzymes(EnzymeList list) {
        System.out.println("Entsyymit: ");
        System.out.println(list);
        System.out.println("");
    }

    /**
     * Metodi kysyy käyttäjältä entsyymejä, joiden kohtia sekvenssistä etsitään.
     * @param enzymes valittavissa olevat entsyymit
     * @return valitut entsyymit
     */
    public EnzymeList getSplittingEnzymes(EnzymeList enzymes) {

        EnzymeList selectedEnzymes = new EnzymeList();

        while (true) {

            System.out.println("Syötä etsittävän entsyymin nimi tai x");
            String syote = this.sc.nextLine();

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

    /**
     * Metodi tulostaa parametrinä saadun tekstin.
     * @param text tulostettava teksti
     */
    public void printResult(String text) {
        System.out.println(text);
        System.out.println("_________________________");
        System.out.println("");

    }

    /**
     * Metodi kysyy käyttäjältä, jatketaanko/lopetetaanko ohjelma.
     * @return true, jos ohjelma halutaan lopettaa, muuten false
     */
    public boolean quit() {

        while (true) {
            System.out.println("Syötä: jatka/lopeta");
            String syote = this.sc.nextLine();

            if (syote.equals("jatka")) {
                System.out.println("");
                return false;
            } else if (syote.equals("lopeta")) {
                return true;
            }
        }
    }

}
