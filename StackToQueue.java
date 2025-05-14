import java.util.Stack;

class StackToQueue {
    private Stack<Integer> s;

    public StackToQueue() {
        s = new Stack<>();
    }

    void push(int x) {
        if(s.isEmpty()) return; 
    }

    int pop() {
        return s.pop();
    }

    int peek() {
        return s.peek();
    }

    boolean isEmpty() {
        return s.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue s = new StackToQueue();

        s.push(4);
    }
}