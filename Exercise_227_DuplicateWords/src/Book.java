
import java.util.HashMap;
import java.util.LinkedList;

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

    private String inputfilename, text;
    private HashMap<String, Integer> map = new HashMap<>();

    public Book(String inputfilename, String text) {
        this.inputfilename = inputfilename;
        this.text = text;
    }

    public HashMap<String, Integer> countWords() {

        String[] words = text.split(" ");

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.replace(word, map.get(word) + 1);
            }

        }

        LinkedList<String> keys = new LinkedList<String>();
        for (String key : map.keySet()) {
            if (map.get(key) < 2) {
                keys.add(key);
            }
        }
        for (String key : keys) {
            map.remove(key);
        }

        return map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public String getInputfilename() {
        return inputfilename;
    }
    
}
