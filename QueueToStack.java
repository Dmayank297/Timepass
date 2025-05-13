import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    private Queue<Integer> q;

    public QueueToStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for(int i=0; i<q.size() -1; i++) {
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }

    public void printStack() {
        if(empty()) {
            return;
        }
        for(int i=0; i< q.size() -1; i++) {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
        QueueToStack s = new QueueToStack();
        s.push(5);
        System.out.println(s.empty());
    }
}
