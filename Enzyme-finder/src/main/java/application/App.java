package application;

import enzymes.EnzymeList;
import sequence.Sequence;
import sequence.SequenceSplitter;
import enzymes.DefaultEnzymes;
import java.util.Scanner;
import ui.Ui;

public class App {
        private Ui ui;
        private EnzymeList enzymes;
        private Sequence originalSequence;

    public void run() {
        DefaultEnzymes defaultEnzymes = new DefaultEnzymes();
        this.enzymes = defaultEnzymes.getEnzymesFromXML();
        this.ui = new Ui(new Scanner(System.in));
        getSequence();
        this.ui.listEnzymes(this.enzymes);
        splitSequence();
        
        
        while (!this.ui.quit()) {
            splitSequence();
        }
    }
    
    public void getSequence() {
        String syote = this.ui.askSequenceOrPath();
        this.originalSequence = new Sequence();
        while (!originalSequence.fromSyote(syote)) {
            syote = this.ui.reAskSequenceOrPath();
        }
    }
    
    public void splitSequence() {
       EnzymeList selectedEnzymes = this.ui.getSplittingEnzymes(this.enzymes);
       SequenceSplitter splitter = new SequenceSplitter(selectedEnzymes);
       splitter.setSequence(originalSequence.getSequence());
       String splitted_text = splitter.split(originalSequence.getSequence());
       this.ui.printResult(splitted_text);
    }
}
