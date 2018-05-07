package application;

import enzymes.EnzymeList;
import sequence.Sequence;
import sequence.SequenceSplitter;
import database.DatabaseConnection;
import java.util.Scanner;
import ui.Ui;

public class App {

    public void run() {
        DatabaseConnection foobar = new DatabaseConnection();
        EnzymeList enzymes = foobar.getEnzymesFromXML();

        Ui ui = new Ui(new Scanner(System.in));


        Sequence input = ui.getSequence();
        ui.listEnzymes(enzymes);

        EnzymeList valitut = ui.getSplittingEnzymes(enzymes);

        ui.printResult(input.getSequence());
        SequenceSplitter splitter = new SequenceSplitter(valitut);
        splitter.setSequence(input.getSequence());
        String splitted_text = splitter.split(input.getSequence());
        ui.printResult(splitted_text);
//        splitter.editSequence();
    }

}
