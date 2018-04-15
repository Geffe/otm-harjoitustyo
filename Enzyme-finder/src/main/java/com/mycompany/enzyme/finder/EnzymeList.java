
package com.mycompany.enzyme.finder;

import java.util.ArrayList;


public class EnzymeList {
    
    private ArrayList<Enzyme> enzymes;
    private int amount;
    
    public EnzymeList(){
        this.enzymes = new ArrayList();
        this.amount = 0;
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
        amount += enzymes.size();
    }
    
    public void addEnzyme(Enzyme enzyme) {
        this.enzymes.add(enzyme);
        this.amount += 1;
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
            if(enzymes.get(i).getSequence().equals(syote)){
                return enzymes.get(i);
            }
        }
        return null;
    }
    
    public int amount(){
        return this.amount;
    }

    
}
