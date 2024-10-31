package harder1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FacialRecognition {
    public static void main(String[] args) throws IOException {
        // Read original faces from file
        Scanner file = new Scanner(new File("faces.txt"));
        String[] names = new String[5];
        double[][] measurements = new double[5][6];
        
        // Read 5 faces
        for (int i = 0; i < 5; i++) {
            names[i] = file.nextLine();
            for (int j = 0; j < 6; j++) {
                measurements[i][j] = Double.parseDouble(file.nextLine());
            }
        }
        file.close();
        
        // Get mystery face measurements
        Scanner input = new Scanner(System.in);
        double[] mystery = new double[6];
        System.out.println("Enter 6 measurements for mystery face:");
        for (int i = 0; i < 6; i++) {
            mystery[i] = input.nextDouble();
        }
        
        // Find best match
        int bestMatch = 0;
        double smallestDiff = Double.MAX_VALUE;
        
        for (int i = 0; i < 5; i++) {
            double diff = 0;
            double[] ratios1 = calculateRatios(measurements[i]);
            double[] ratios2 = calculateRatios(mystery);
            
            // Calculate sum of squares % difference
            for (int j = 0; j < 15; j++) {
                double d = (ratios2[j] - ratios1[j]) / ratios1[j];
                diff += d * d;
            }
            
            if (diff < smallestDiff) {
                smallestDiff = diff;
                bestMatch = i;
            }
        }
        
        System.out.println("Best match is: " + names[bestMatch]);
    }
    
    static double[] calculateRatios(double[] m) {
        double[] ratios = new double[15];
        int k = 0;
        
        // Calculate all 15 ratios
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                ratios[k++] = m[i] / m[j];
            }
        }
        return ratios;
    }
}