package sequence;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka käsittelee kokonaista sekvenssiä, josta tarkoitus on etsiä haluttuja
 * entsyymejä.
 *
 */
public class Sequence {

    private String sequence;

    /**
     * Luokan konstruktori, joka on parametritön.
     */
    public Sequence() {

    }

    /**
     * Luokan konstruktori, joka saa parametrin.
     * @param sequence sekvenssi
     */
    public Sequence(String sequence) {
        this.sequence = sequence;

    }

    /**
     * Metodi luo annetusta tekstistä sekvenssin.
     *
     * @param originalInput sisältää tekstiä, jossa voi olla muutakin kuin
     * puhdas sekvenssi
     * @return true jos sekvenssi ei ole tyhjä ja muuten false
     */
    public boolean fromString(String originalInput) {

        String[] lines = originalInput.split("\n");
        this.sequence = "";

        for (String line : lines) {
            String result = line.split("#")[0];
            String syote = result.toUpperCase();
            syote = syote.replaceAll("\\s", "");
            this.sequence += syote;
        }
        return !(this.sequence.equals(""));
    }

    /*
     * Metodi muodostaa tiedoston sisällöstä String-olion.
     *
     * @param path tiedostosijainti
     * @param encoding StandardCharsets.UTF_8
     * @return String- muttujan, jossa on tiedoston sisältö
     * @throws IOException jos tiedoston lukeminen epäonnistuu
     */
    private String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Metodi tarkastelee, onko annettu syöte tiedosto vai sekvenssi.
     *
     * @param path tiedostopolku tai puhdas sekvenssi
     * @return true jos parametri on toimiva tiedostopolku ja false jos
     * parametri ei ole tiedostopolku tai tiedosto on tyhjä
     */
    public boolean fromFile(String path) {

        if (new File(path).isFile()) {
            try {
                String text = readFile(path, StandardCharsets.UTF_8);

                return fromString(text);

            } catch (IOException ex) {
                Logger.getLogger(Sequence.class.getName()).log(Level.FINE, null, ex);
                return false;
            }
        }
        return false;
    }

    /**
     * Metodi tutkii syötteen toimivuutta.
     * @param input string
     * @return true, jos parametri on toimiva tiedostopolku tai 
     * jokin muu kuin tyhjä string, muuten false
     */
    public boolean fromInput(String input) {
        return (this.fromFile(input) || this.fromString(input));
    }

    /**
     * Metodi palauttaa sekvenssin.
     * @return Sequence sekvenssi
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * Metodi asettaa skvenssille string-muuttujan.
     * @param sequence 
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
