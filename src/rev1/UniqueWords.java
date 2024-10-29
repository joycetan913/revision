package rev1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.io.Reader;
import java.util.Set;

public class UniqueWords {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        String inputFile = args[0];
        String stopWordsFile = "stopwords.txt";
        String outputFile ="outputFile.txt";
        Set<String> UniqueWords = new HashSet<>();
        

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line = "x";
            while ((line = reader.readLine()) != null){
                String transformed = line.replaceAll("\\p{Punct}", "").toLowerCase().trim();

                if(line == null)
                    break;
                
            for (String word: transformed.split(" "))
            UniqueWords.add(word);
            
            }
        
        reader.close();
        }

        System.out.printf("Unique word in %s: %d", inputFile, UniqueWords.size());

        for (String word: UniqueWords)
            System.out.printf("Unique word: %s", word);
    }
    
}
