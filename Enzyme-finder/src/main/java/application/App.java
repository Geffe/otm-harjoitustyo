package application;

import enzymes.EnzymeList;
import sequence.Sequence;
import sequence.SequenceSplitter;
import enzymes.DefaultEnzymes;
import java.util.Scanner;
import ui.Ui;

/**
 * Luokka ohjaa koko sovelluksen kulkua.
 * 
 */
public class App {

    private Ui ui;
    private EnzymeList enzymes;
    private Sequence originalSequence;

    /**
     * Käynnistää pääohjelman ja käyttöliittymän.
     * Ohjelma pilkkoo DNA-sekvenssit annettujen entsyymien kohdalta.
     */
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
    
    /*
    Metodi kysyy käyttäjältä tiedostopolkua tai sekvenssiä.
    */
    private void getSequence() {
        String syote = this.ui.askSequenceOrPath();
        this.originalSequence = new Sequence();
        while (!originalSequence.fromSyote(syote)) {
            syote = this.ui.reAskSequenceOrPath();
        }
    }

    /*
    Metodi suorittaa annetun sekvenssin muokkaamisen valittujen
    enstsyymien mukaan ja tulostaa muokatun sekvenssin.
    */
    private void splitSequence() {
        EnzymeList selectedEnzymes = this.ui.getSplittingEnzymes(this.enzymes);
        SequenceSplitter splitter = new SequenceSplitter(selectedEnzymes);
        splitter.setSequence(originalSequence.getSequence());
        String splittedText = splitter.split(originalSequence.getSequence());
        this.ui.printResult(splittedText);
    }
}
