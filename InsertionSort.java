public class InsertionSort {

    static void insertSort(int[] arr) {
        int n = arr.length;
        
        for(int i = 1; i<n; i++) {
            int v = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > v) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = v;
        }
    }
    static void printArray(int arr[])
    {
        System.out.println("Insetion Sort");
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {25,2,4,32,1,3};
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }
}