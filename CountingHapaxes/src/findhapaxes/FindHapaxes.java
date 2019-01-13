/*
 * From https://en .wikipedia.org/wiki/Hapax_legomenon
 * In corpus linguistics, a hapax legomenon (sometimes abbreviated to hapax)
 * is a word that occurs only once within a context, either in the written
 * record of an entire language, in the works of an author, or in a single text.
 * This program will read a text file and find all hapaxes in it.
 */
package findhapaxes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Drazen
 */
public class FindHapaxes {
    /**
     * Cleans the word by leaving only letters. All punctuation is removed.
     * @param word - the word to be cleaned
     * @return cleaned word
     */
    private static String cleanWord(String word) {
        String cleanWord = word.replaceAll("[^a-zA-Z]", "");
        return cleanWord;
    }

    /**
     * Reads all words from the input file, converts them to lowercase
     * and counts their frequency.
     * @param fileName
     * @return map of words and their frequencies
     * @throws IOException 
     */
    private static Map<String, Integer> readWords(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner input = new Scanner(file); 

        Map<String, Integer> words = new HashMap<>(); 
        while (input.hasNext()) {
          String word  = cleanWord(input.next().toLowerCase());
          if (!words.containsKey(word)) {
              words.put(word, 0);
          }
          words.put(word, words.get(word) + 1);
        }
        return words;
    }
    
    /**
     * Finds all hapaxes, that is, all words that appear only once n the input file
     * @param fileName
     * @return set of hapaxes
     */
    private static Set<String> findHapaxes(String fileName) {
        //Prepare the output collection
        Set<String> hapaxes = new HashSet<>();
        
        try {
            // Get all words from the input file, together with their frequencies
            Map<String, Integer> words = readWords(fileName);
            
            // Find those words that appear only once and add tehm to a set
            words.forEach((String word, Integer count) -> {
                if (count == 1) hapaxes.add(word);
            });
        } catch (IOException ex) {
            System.err.format("Can't read from file %s.\n", fileName);
            System.err.println(ex.getMessage());
        }
        
        return hapaxes;
    }   
    
    /**
     * Shows on screen all hapaxes in the given input file.
     * @param fileName 
     */
    private static void showHapaxes(String fileName) {
        //Find hapaxes
        Set<String> hapaxes = findHapaxes(fileName);
        
        //Show hapaxes
        hapaxes.forEach((String word) -> {
            System.out.println(word);
        });
    }
    
    /**
     * Finds all hapaxes in the input file passed as an argument.
     * If no input file is provided, default file name is "shakespeare.txt",
     * which contains all works by William Shakespeare downloaded from 
     * Project Gutenberg web site https://www.gutenberg.org/
     * @param args 
     */
    public static void main(String[] args) {
        String fileName = "shakespeare.txt";
        if (args.length > 0) {
            fileName = args[0];
        }
        showHapaxes(fileName);
    }
}
