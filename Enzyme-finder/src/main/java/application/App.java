package application;

import enzymes.EnzymeList;
import sequence.Sequence;
import sequence.SequenceSplitter;
import database.DatabaseConnection;
import java.util.Scanner;
import ui.Ui;

public class App {

    public void run() {
        DatabaseConnection conn = new DatabaseConnection();
        EnzymeList enzymes = conn.getEnzymesFromXML();

        Ui ui = new Ui(new Scanner(System.in));

        Sequence input = ui.getSequence();
        ui.listEnzymes(enzymes);

        EnzymeList selectedEnzymes = ui.getSplittingEnzymes(enzymes);

        ui.printResult(input.getSequence());
        SequenceSplitter splitter = new SequenceSplitter(selectedEnzymes);
        splitter.setSequence(input.getSequence());
        String splitted_text = splitter.split(input.getSequence());
        ui.printResult(splitted_text);

    }

}
