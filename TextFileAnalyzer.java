package harder1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileAnalyzer {
    public static void main(String[] args) {
        String filename = "yourfile.txt"; 
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(" "); // Append each line followed by a space
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = content.toString();

        // Counting letters
        int numLetters = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                numLetters++;
            }
        }

        // Counting words
        String[] words = text.split("\\s+"); // Split by one or more whitespace characters
        int numWords = words.length;

        // Counting sentences
        int numSentences = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                numSentences++;
            }
        }

       // Calculating averages 
       double averageLettersPerWord = (numWords > 0) ? Math.round((double) numLetters / numWords * 10) / 10.0 : 0.0; 
       double averageWordsPerSentence = (numSentences > 0) ? Math.round((double) numWords / numSentences * 10) / 10.0 : 0.0;

       // Displaying results 
       System.out.println("Number of letters: " + numLetters); 
       System.out.println("Number of words: " + numWords); 
       System.out.println("Number of sentences: " + numSentences); 
       System.out.println("Average number of letters per word: " + averageLettersPerWord); 
       System.out.println("Average number of words per sentence: " + averageWordsPerSentence); 
   } 
}