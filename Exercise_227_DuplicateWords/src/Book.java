
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vizug
 */
public class Book {
    private String inputfilename,text;
    private HashMap<String,Integer> map;

    public Book(String inputfilename, String text) {
        this.inputfilename = inputfilename;
        this.text = text;
    }
    
    
    
    public HashMap<String,Integer> countWords(){
        
        String[] words = text.split(" ");
        
        for (String word : words) {
            if(!map.containsKey(word)){
                map.put(word,1);
            }
            else{
                map.replace(word, map.get(word)+1);
            }
            
        }
        
        return map;
    }

    @Override
    public String toString() {
        return String.format("%s %d");
    }
    
}
