package rev1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class readCSV {

    public static void main(String[] args) {
        
        String inputFile = args[0];
        String outputFile = "output.txt";
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = "x";
            while ((line = reader.readLine()) != null) 
                String[] row = line.split(",");
                data.add(row);
        
            if (line == null)
                break;

        reader.close();
        }
        Map<String, AppRating> appRatings = new HashMap<>();
        
        for (String[] row: data) 
            String appName = row[0];
            String category = row[1];
            double rating = row[2]; 
        


            
        
    }

}