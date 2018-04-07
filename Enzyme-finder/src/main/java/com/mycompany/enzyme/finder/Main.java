
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
        Sequence input = new Sequence("ACTGGAATTCGCTACGGAATTCGATCGATCGAGGATCCCTGTGCAGAATTCCTGAT");
        
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
        
        Sequence output = new Sequence();
        SequenceSplitter splitter = new SequenceSplitter(enzymes);
        splitter.split(input.getSequence());
        
        int sekvenssinPituus = input.getSequence().length();
        int ekaIndeksi = 0;
        int vikaIndeksi = 6;
        
        while(vikaIndeksi <= sekvenssinPituus){
            String subString = input.getSequence().substring(ekaIndeksi, vikaIndeksi);
            System.out.println(subString);
            if(valitut.searchSequence(subString)){
                output.editSequence("_");
            //output.editSequence(input.getSequence().charAt(ekaIndeksi));
            }
            
            ekaIndeksi++;
            vikaIndeksi++;
        }   
        System.out.println(output.getSequence());
    }
    
}
