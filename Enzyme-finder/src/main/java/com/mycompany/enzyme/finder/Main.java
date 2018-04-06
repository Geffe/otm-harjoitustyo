
package com.mycompany.enzyme.finder;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args){
        //Alun kokeilua, siirrän eri komponentit omiin luokkiin myöhemmin, myönnän että koodi on erittäin kökköä
        HashMap<String,String> entsyymit = new HashMap();
        entsyymit.put("EcoRI", "GAATTC");
        entsyymit.put("BamHI", "GGATCC");
        
        Scanner lukija = new Scanner(System.in);
        System.out.println("Syötä sekvenssi: ");
        String sekvenssi = lukija.nextLine();
        
        System.out.println("Entsyymit: ");
        System.out.println(entsyymit.entrySet());
        
        HashMap<String,String> valitut = new HashMap();
        
        while(true){
            System.out.println("Syötä halutun entsyymin nimi tai lopeta");
            String syote = lukija.nextLine();
            
            if(syote.equals("lopeta")){
                break;
            }if(entsyymit.containsKey("syote")){
                valitut.put(syote,entsyymit.get(syote));
            }
        }
        
        String muokattuSekvenssi = "";
        
        int sekvenssinPituus = sekvenssi.length();
        int ekaIndeksi = 0;
        int vikaIndeksi = 5;
        
        while(vikaIndeksi == sekvenssinPituus-1){
            String subString = sekvenssi.substring(ekaIndeksi, vikaIndeksi);
            
            if(valitut.containsValue(subString)){
                muokattuSekvenssi = muokattuSekvenssi +"-"+subString+"-";
            }else{
                muokattuSekvenssi = muokattuSekvenssi+subString;
            }
            ekaIndeksi++;
            vikaIndeksi++;
        }
        System.out.println("****");
        System.out.println(muokattuSekvenssi);
        System.out.println("****");
        
      
        
    }
    
}
