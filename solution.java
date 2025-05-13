public class solution {
    public static int getMinimumAlterations(String s) {
        int n = s.length();
        if (n < 3) {
            return 0;
        }
        
        // The healthy strings are those that are all 0s, all 1s, 0*1*, or 1*0*
        // We need to check all four possibilities and find the minimal flips
        
        // Case 1: All 0s
        int flipsAll0 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                flipsAll0++;
            }
        }
        
        // Case 2: All 1s
        int flipsAll1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '1') {
                flipsAll1++;
            }
        }
        
        // Case 3: 0s followed by 1s (0*1*)
        int flips01 = Integer.MAX_VALUE;
        // For each possible split point i (0..n), 0s before i, 1s after i
        int[] prefix0 = new int[n + 1]; // prefix0[i] is number of 1s in first i positions (flips to make them 0)
        int[] suffix1 = new int[n + 1]; // suffix1[i] is number of 0s in positions >=i (flips to make them 1)
        
        prefix0[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix0[i] = prefix0[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }
        
        suffix1[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix1[i] = suffix1[i + 1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        
        for (int i = 0; i <= n; i++) {
            int total = prefix0[i] + suffix1[i];
            if (total < flips01) {
                flips01 = total;
            }
        }
        
        // Case 4: 1s followed by 0s (1*0*)
        int flips10 = Integer.MAX_VALUE;
        int[] prefix1 = new int[n + 1]; // flips to make first i positions 1 (count 0s)
        int[] suffix0 = new int[n + 1]; // flips to make positions >=i 0 (count 1s)
        
        prefix1[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix1[i] = prefix1[i - 1] + (s.charAt(i - 1) == '0' ? 1 : 0);
        }
        
        suffix0[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix0[i] = suffix0[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        
        for (int i = 0; i <= n; i++) {
            int total = prefix1[i] + suffix0[i];
            if (total < flips10) {
                flips10 = total;
            }
        }
        
        // The answer is the minimal among all four cases
        return Math.min(Math.min(flipsAll0, flipsAll1), Math.min(flips01, flips10));
    }

    public static void main(String[] args) {
        String input = "11010";
        System.out.println(getMinimumAlterations(input));
    }
} 
    

