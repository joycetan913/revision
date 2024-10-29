package rev1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.FileNotFoundException;

public class readCSV {

    public static void main(String[] args) throws IOException, FileNotFoundException{
        
        String inputFile = args[0];
        String outputFile = "output.txt";

        Map<String, Customer> customerMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 12) {
                    System.out.println("Skipping incomplete line: " + line);
                    continue; // Skip incomplete lines
                }

                Customer customer = new Customer(
                        values[1],  // Customer Id
                        values[2],  // First Name
                        values[3],  // Last Name
                        values[4],  // Company
                        values[5],  // City
                        values[6],  // Country
                        values[7],  // Phone 1
                        values[8],  // Phone 2
                        values[9],  // Email
                        values[10], // Subscription Date
                        values[11]  // Website
                );

                customerMap.putIfAbsent(customer.getCustomerId(), customer);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Example of retrieving a customer
        Customer c = customerMap.get("9F9AdB7B8A6f7F2");
        if (c != null) {
            System.out.println(c.toString());
        } else {
            System.out.println("Customer not found.");
        }
    }
}