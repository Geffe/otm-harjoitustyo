
package application;

import com.mycompany.enzyme.finder.Enzyme;
import com.mycompany.enzyme.finder.EnzymeList;
import com.mycompany.enzyme.finder.Sequence;
import com.mycompany.enzyme.finder.SequenceSplitter;
import database.DatabaseConnection;
import java.util.Scanner;


public class App {
    
    public void run(){
        DatabaseConnection foobar = new DatabaseConnection();
        EnzymeList enzymes = foobar.getEnzymesFromXML();
        System.out.println(enzymes.toString());
        System.out.println("tidiii");
        
//        foobar.createNewDatabase("test2.db");
//        EnzymeList enzymes = new EnzymeList();

//        enzymes.addEnzyme(new Enzyme("EcoRI", "GAATTC"));
//        enzymes.addEnzyme(new Enzyme("BamHI", "GGATCC"));

        Sequence input = getSequence();
        System.out.println("Entsyymit: ");
        System.out.println(enzymes);

        EnzymeList valitut = getSplittingEnzymes(enzymes);

        System.out.println(input.getSequence());
        SequenceSplitter splitter = new SequenceSplitter(valitut);
        splitter.setSequence(input.getSequence());
        String splitted_text = splitter.split(input.getSequence());
        printResult(splitted_text);
        splitter.editSequence();
    }

    private Sequence getSequence() {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Syötä sekvenssi: ");
        Sequence input = new Sequence("ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGATGTGCAC");
        //                                 -EcoRI-     -EcoRI-         -BamHI-      -EcoRI-   -ApaLI-
        return input;

    }

    private EnzymeList getSplittingEnzymes(EnzymeList enzymes) {
        Scanner lukija = new Scanner(System.in);
        EnzymeList valitut = new EnzymeList();

        while (true) {
            System.out.println("Syötä halutun entsyymin nimi tai lopeta");
            String syote = lukija.nextLine();

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

    private void printResult(String splitted_text) {
        System.out.println(splitted_text);
    }
}
