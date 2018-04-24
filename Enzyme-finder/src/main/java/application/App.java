
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
       
       
        Ui ui = new Ui(new Scanner(System.in));
        
//        foobar.createNewDatabase("test2.db");
//        EnzymeList enzymes = new EnzymeList();

//        enzymes.addEnzyme(new Enzyme("EcoRI", "GAATTC"));
//        enzymes.addEnzyme(new Enzyme("BamHI", "GGATCC"));

        Sequence input = ui.getSequence();
        ui.listEnzymes(enzymes);

        EnzymeList valitut = ui.getSplittingEnzymes(enzymes);

        ui.printResult(input.getSequence());
        SequenceSplitter splitter = new SequenceSplitter(valitut);
        splitter.setSequence(input.getSequence());
        String splitted_text = splitter.split(input.getSequence());
        ui.printResult(splitted_text);
        splitter.editSequence();
    }

    

    

    
}
