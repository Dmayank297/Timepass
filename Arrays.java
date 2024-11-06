public class Arrays {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than the length of the array
        
        // Step 1: Store the last k elements
        int temp[] = new int[k]; // Create array of size k
        
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];  // Store the last k elements in temp
        }

        // Step 2: Shift the first n-k elements to the right
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Step 3: Copy the k stored elements back into the array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
        
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int sum1 = n*(n+1)/2;
        int sum2 = 0;
        for(int i = 0; i<n; i++) {
            sum2 += nums[i];
        }

        return (sum1 - sum2);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        // rotate(nums, k);
        int res = missingNumber(nums);
        System.out.println(res);



    }
}
