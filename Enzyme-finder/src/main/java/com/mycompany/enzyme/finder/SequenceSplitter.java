
package com.mycompany.enzyme.finder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SequenceSplitter {
    
    /*
        1. anna splittausentsyymit
        2. rakenna regexp niiden perusteella
        3. splittaa annettu sequence
    */
    final String regex;
    final ArrayList<Enzyme> list;
    
    public SequenceSplitter(EnzymeList list){
//        this.regex = "(GGATCC)|(GAATTC)";

        
        this.list = list.getEnzymes();
        this.regex = this.regexBuilder();
    }
    public String regexBuilder(){
        String string= "";
        for(int i=0;i<list.size();i++){
            string += "(" + list.get(i).getSequence() + ")";
            if(!(i+1==list.size())){
                string += "|";
            }
        }
        return string;
    }
    
    public void split(String string){
        
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
//            System.out.println("Full match: " + matcher.group(0));
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("Group " + i + ": " + matcher.group(i));
// 
//            }

            System.out.println("Start index: " + matcher.start());
            System.out.println(" End index: " + matcher.end());
            System.out.println(" Found: " + matcher.group());
        }
        
    }
}
