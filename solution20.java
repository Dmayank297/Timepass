import java.util.*;
import java.io.*;

class Solution20 {
    /*
     * Complete the 'calculateMaxQualityScore' function below.
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER impactFactor
     * 2. INTEGER_ARRAY ratings
     */
    public static long calculateMaxQualityScore(int impactFactor, List<Integer> ratings) {
        // First calculate the original maximum subarray sum (Kadane's algorithm)
        long originalMax = kadane(ratings);
        
        // If impactFactor is 1, no change will happen with either operation
        if (impactFactor == 1) {
            return originalMax;
        }
        
        long maxScore = originalMax;
        int n = ratings.size();
        
        // Try all possible segments for amplification
        for (int i = 0; i < n; i++) {
            List<Integer> amplified = new ArrayList<>(ratings);
            for (int j = i; j < n; j++) {
                // Amplify the segment from i to j
                amplified.set(j, ratings.get(j) * impactFactor);
                long currentMax = kadane(amplified);
                if (currentMax > maxScore) {
                    maxScore = currentMax;
                }
            }
        }
        
        // Try all possible segments for adjustment
        for (int i = 0; i < n; i++) {
            List<Integer> adjusted = new ArrayList<>(ratings);
            for (int j = i; j < n; j++) {
                // Adjust the segment from i to j
                int original = ratings.get(j);
                int modified;
                if (original >= 0) {
                    modified = original / impactFactor; // floor for positive
                } else {
                    modified = (int) Math.ceil(original / (double) impactFactor); // ceil for negative
                }
                adjusted.set(j, modified);
                long currentMax = kadane(adjusted);
                if (currentMax > maxScore) {
                    maxScore = currentMax;
                }
            }
        }
        
        return maxScore;
    }
    
    // Kadane's algorithm to find maximum subarray sum
    private static long kadane(List<Integer> arr) {
        long maxSoFar = Long.MIN_VALUE;
        long maxEndingHere = 0;
        
        for (int num : arr) {
            maxEndingHere += num;
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        
        return maxSoFar;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(5, -3, -3, 2, 4);
        int impactFactor = 3;
        System.out.println("Maximum Quality Score: " + calculateMaxQualityScore(impactFactor, input));
    }
}