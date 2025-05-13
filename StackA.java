class StackA {
    int n;
    int[] arr = new int[n];
    int i;

    public StackA() {
        n = 5;
        i = -1;
    }
    void push(int ele) {
        if(i > n) {
            System.out.println("Stack is full ");
            return;
        }
        arr[++i] = ele;
    }
    int pop() {
        if(i < 0) {
            System.out.println("Stack is already empty ");
            return 0;
        }
        return arr[i--];
    }

    int top() {
        if(i < 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[i];
    }
    boolean isEmpty() {
        return i < 0;
    }

    void printStack() {
        if(i < 0) {
            System.out.println("Stack is empty ");
            return;
        }
        for(int j=i; j>=0; j--) {
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        StackA s = new StackA();
        
        System.out.println("Is empty? " + s.isEmpty());
        s.printStack();
    }
}