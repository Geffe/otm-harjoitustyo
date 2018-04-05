
package com.mycompany.enzyme.finder;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args){
        HashMap<String,String> entsyymit = new HashMap();
        entsyymit.put(EcoRI, GAATTC);
        entsyymit.put(BamHI, GGATCC);
        
        Scanner lukija = new Scanner(System.in);
        System.out.println("Syötä sekvenssi: ");
        String sekvenssi = lukija.nextLine();
        
        System.out.println("Entsyymit: ");
        
    }
}
