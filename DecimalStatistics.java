package harder1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DecimalStatistics {

    public static void main(String[] args) {
        String filePath = "data.txt"; // Change this to your file path
        ArrayList numbers1 = new ArrayList<>();
        
        // Step 1: Read the file and store numbers
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Split by whitespace
                for (String part : parts) {
                    try {
                        double number = Double.parseDouble(part);
                        numbers1.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid number: " + part);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Step 2: Calculate statistics
        int quantity = numbers1.size();
        if (quantity == 0) {
            System.out.println("No valid numbers found.");
            return;
        }

        double sum = 0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (double num : numbers) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }

        double average = sum / quantity;
        double range = max - min;

        // Step 3: Display results
        System.out.printf("Quantity of numbers: %d%n", quantity);
        System.out.printf("Average (mean): %.2f%n", average);
        System.out.printf("Largest number: %.2f%n", max);
        System.out.printf("Smallest number: %.2f%n", min);
        System.out.printf("Range of data: %.2f%n", range);
    }
}