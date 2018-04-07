
package com.mycompany.enzyme.finder;


public class Sequence {
    
    private String sequence;

    public Sequence() {
        this.sequence = "";
    }

    public Sequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    
    public void editSequence(String sequence){
        this.sequence += sequence;
    }
    
    
    
}
