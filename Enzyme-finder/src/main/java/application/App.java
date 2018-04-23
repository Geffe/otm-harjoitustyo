
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

        Scanner lukija = new Scanner(System.in);
        System.out.println("Syötä sekvenssi: ");
        Sequence input = new Sequence("ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGATGTGCAC");
        //                                 -EcoRI-     -EcoRI-         -BamHI-      -EcoRI-   -ApaLI-

        System.out.println("Entsyymit: ");
        System.out.println(enzymes);

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

        System.out.println(input.getSequence());
        SequenceSplitter splitter = new SequenceSplitter(valitut);
        splitter.setSequence(input.getSequence());
        splitter.split(input.getSequence());
        splitter.editSequence();
    }
}
