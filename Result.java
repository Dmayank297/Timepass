import java.util.*;

class Result {
    public static long calculateMaxQualityScore(int impactFactor, List<Integer> ratings) {
        int n = ratings.size();
        if (impactFactor == 1) {
            return maxSubarraySum(ratings);
        }

        // Precompute prefix and suffix max sums
        long[] leftMax = new long[n];  // Max sum ending at i
        long[] rightMax = new long[n]; // Max sum starting at i
        long current = 0, maxSoFar = Long.MIN_VALUE;
        
        // Left-to-right (prefix)
        for (int i = 0; i < n; i++) {
            current = Math.max(ratings.get(i), current + ratings.get(i));
            leftMax[i] = maxSoFar = Math.max(maxSoFar, current);
        }
        
        // Right-to-left (suffix)
        current = 0;
        maxSoFar = Long.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            current = Math.max(ratings.get(i), current + ratings.get(i));
            rightMax[i] = maxSoFar = Math.max(maxSoFar, current);
        }

        long maxScore = maxSubarraySum(ratings); // Initial score
        
        // Iterate over all subarrays
        for (int start = 0; start < n; start++) {
            long amplifySum = 0, adjustSum = 0;
            for (int end = start; end < n; end++) {
                // Incremental sum for amplified and adjusted subarrays
                int val = ratings.get(end);
                amplifySum += val * impactFactor;
                adjustSum += adjustValue(val, impactFactor);

                // Combine with prefix and suffix
                long left = (start > 0) ? leftMax[start - 1] : 0;
                long right = (end < n - 1) ? rightMax[end + 1] : 0;

                // Amplify strategy
                long amplifyScore = left + amplifySum + right;
                maxScore = Math.max(maxScore, amplifyScore);

                // Adjust strategy
                long adjustScore = left + adjustSum + right;
                maxScore = Math.max(maxScore, adjustScore);
            }
        }
        
        return maxScore;
    }

    // Kadane's Algorithm
    private static long maxSubarraySum(List<Integer> arr) {
        long maxSum = Long.MIN_VALUE, currentSum = 0;
        for (int num : arr) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Adjust value based on sign
    private static int adjustValue(int num, int impactFactor) {
        return (num >= 0) ? num / impactFactor : (int) Math.ceil((double) num / impactFactor);
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(1,4,-2,3,-3,-1);
        int impactFactor = 2;
        System.out.println("Maximum Quality Score: " + calculateMaxQualityScore(impactFactor, input));
    }
}