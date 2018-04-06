
package com.mycompany.enzyme.finder;


import java.util.Scanner;


public class Main {
    
    public static void main(String[] args){
        //Alun kokeilua, siirrän eri komponentit omiin luokkiin myöhemmin
        
        EnzymeList enzymes = new EnzymeList();
        
        enzymes.setEnzyme(new Enzyme("EcoRI", "GAATTC"));
        enzymes.setEnzyme(new Enzyme("BamHI", "GGATCC"));
        
        
        Scanner lukija = new Scanner(System.in);
        System.out.println("Syötä sekvenssi: ");
        String sekvenssi = "AGCTGGATCCTAGCAT";
        
        System.out.println("Entsyymit: ");
        System.out.println(enzymes);
        
        EnzymeList valitut = new EnzymeList();
        
        while(true){
            System.out.println("Syötä halutun entsyymin nimi tai lopeta");
            String syote = lukija.nextLine();
            
            if(syote.equals("lopeta")){
                break;
            }else if(enzymes.searchName(syote)){
                valitut.setEnzyme(enzymes.getEnzyme(syote));
            }else if(syote.isEmpty() && valitut.getEnzymes().isEmpty()){
                valitut.setEnzyme(enzymes.getEnzyme("BamHI"));
                System.out.println("Käytetään oletusentsyymiä BamHI");
                break;
            }else{
                System.out.println("Käytä parempia arvoja tyhmä!");
            }
        }
        
        String muokattuSekvenssi = "";
        
        int sekvenssinPituus = sekvenssi.length();
        int ekaIndeksi = 0;
        int vikaIndeksi = 5;
        
        while(vikaIndeksi < sekvenssinPituus){
            String subString = sekvenssi.substring(ekaIndeksi, vikaIndeksi);
            
            if(valitut.searchSequence(subString)){
                System.out.println("löytyy");
            }
            ekaIndeksi++;
            vikaIndeksi++;
        }    
    }
    
}
