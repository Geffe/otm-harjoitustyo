
package com.mycompany.enzyme.finder;

import java.util.ArrayList;


public class EnzymeList {
    
    private ArrayList<Enzyme> enzymes;
    
    public EnzymeList(){
        this.enzymes = new ArrayList();
        
    }
    
    @Override
    public String toString(){
        String result = "";
        for (int i = 0; this.enzymes.size() > i; i++)
            result += " " + this.enzymes.get(i).getName();
        return result;
    }

    public void setEnzymes(ArrayList<Enzyme> enzymes) {
        this.enzymes = enzymes;
    }
    
    public void setEnzyme(Enzyme enzyme) {
        this.enzymes.add(enzyme);
    }

    public ArrayList<Enzyme> getEnzymes() {
        return enzymes;
    }
    
    public boolean searchName(String enzyme){
        for(int i= 0; i<enzymes.size();i++){
            if(enzymes.get(i).getName().equals(enzyme)){
                return true;
            }
        }
        return false;
    }
    
    public boolean searchSequence(String enzyme){
        for(int i= 0; i<enzymes.size();i++){
            if(enzymes.get(i).getSequence().equals(enzyme)){
                return true;
            }
        }
        return false;
    }
    
    public Enzyme getEnzyme(String syote){
        for(int i=0; i<enzymes.size();i++){
            if(enzymes.get(i).getName().equals(syote)){
                return enzymes.get(i);
            }
        }
        return new Enzyme("a","a");
        //huono, tiedän
    }

    
}
