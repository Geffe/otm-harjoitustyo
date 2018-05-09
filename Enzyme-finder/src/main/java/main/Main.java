package main;

import application.App;

/**
 * Luokka käynnistää ohjelman.
 *
 */
public class Main {

    /**
     * Metodi vain käynnistää varsinaisen ohjelman.
     * @param args 
     */
    public static void main(String[] args) {

        App app = new App();
        app.run();
    }

}
