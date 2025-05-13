public class MinOperationsBinaryString {
    public static int minOperations(String s) {
        int n = s.length();
        int operations = 0;
        char[] arr = s.toCharArray();

        // Traverse the string to eliminate "010" or "101"
        for (int i = 1; i < n - 1; i++) {
            // Check for subsequences "010" or "101"
            if ((arr[i - 1] == '0' && arr[i] == '1' && arr[i + 1] == '0') ||
                (arr[i - 1] == '1' && arr[i] == '0' && arr[i + 1] == '1')) {
                operations++;
                arr[i] = arr[i - 1]; // Flip the middle character to remove the pattern
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        String input = "001100";
        System.out.println(minOperations(input));
    }
}
