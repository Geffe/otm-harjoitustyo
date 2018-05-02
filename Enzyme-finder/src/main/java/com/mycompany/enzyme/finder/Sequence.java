
package com.mycompany.enzyme.finder;

import database.DatabaseConnection;
import org.w3c.dom.Document;


public class Sequence {
    
    private String sequence;

    public Sequence() {
        this.sequence = "";
    }

    public Sequence(String sequence) {
        this.sequence = sequence;
    }
    
    public boolean fromString(String string){
        String syote = string.toUpperCase();
        syote = syote.replaceAll("\\s", "");
        this.sequence = syote;
        
        if(this.sequence == null || this.sequence.equals("")){
            return false;
        }
        
        return true;
    }
    
    public boolean fromFile(String string){
        if(string.contains(".xml")){
            DatabaseConnection conn = new DatabaseConnection();
            Document document = conn.getDocument(string);
            String text = document.getTextContent();
            fromString(text);
            
            return true;
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
