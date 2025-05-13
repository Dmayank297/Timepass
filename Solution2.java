import java.util.*;

public class Solution2 {
    public static long calculateMaxQualityScore(int impactFactor, List<Integer> ratings) {
        if (impactFactor == 1) {
            return kadane(ratings);
        }

        long originalMax = kadane(ratings);
        long maxAmplify = maximizeAmplify(ratings, impactFactor);
        long maxAdjust = maximizeAdjust(ratings, impactFactor);

        return Math.max(originalMax, Math.max(maxAmplify, maxAdjust));
    }

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

    private static long maximizeAmplify(List<Integer> ratings, int impactFactor) {
        long maxQuality = Long.MIN_VALUE;
        int n = ratings.size();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> modified = new ArrayList<>(ratings);
                for (int k = i; k <= j; k++) {
                    modified.set(k, modified.get(k) * impactFactor);
                }
                long current = kadane(modified);
                if (current > maxQuality) {
                    maxQuality = current;
                }
            }
        }
        return maxQuality;
    }

    private static long maximizeAdjust(List<Integer> ratings, int impactFactor) {
        long maxQuality = Long.MIN_VALUE;
        int n = ratings.size();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> modified = new ArrayList<>(ratings);
                for (int k = i; k <= j; k++) {
                    int num = modified.get(k);
                    if (num >= 0) {
                        modified.set(k, num / impactFactor);
                    } else {
                        modified.set(k, (int) Math.ceil((double) num / impactFactor));
                    }
                }
                long current = kadane(modified);
                if (current > maxQuality) {
                    maxQuality = current;
                }
            }
        }
        return maxQuality;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(5, -3, -3, 2, 4);
        int impactFactor = 3;
        System.out.println("Maximum Quality Score: " + calculateMaxQualityScore(impactFactor, input));
    }
}
