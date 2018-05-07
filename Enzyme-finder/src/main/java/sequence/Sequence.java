package sequence;

import database.DatabaseConnection;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;

public class Sequence {

    private String sequence;

    public Sequence() {
        this.sequence = "";
    }

    public Sequence(String sequence) {
        this.sequence = sequence;
    }

    public boolean fromString(String originalInput) {

        String[] lines = originalInput.split("\n");
        this.sequence = "";

        for (String line : lines) {
            String result = line.split("#")[0];
            String syote = result.toUpperCase();
            syote = syote.replaceAll("\\s", "");
            this.sequence += syote;
        }

        return !(this.sequence == null || this.sequence.equals(""));
    }

    private String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public boolean fromFile(String string) {

        if (string.contains(".xml") || true) {
            try {
                String text = readFile(string, StandardCharsets.UTF_8);
                System.out.println(text);
                return fromString(text); //tässsä kohtaa ongelma

            } catch (IOException ex) {
                Logger.getLogger(Sequence.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

        return false;

    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public void editSequence(String sequence) {
        this.sequence += sequence;
    }

}
