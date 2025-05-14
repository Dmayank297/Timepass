public class QueueA {
    int n;
    int q[];
    int start;
    int end;
    int curSize;

    QueueA() {
        n = 5;
        q = new int[n];
        start = -1;
        end = -1;
        curSize = 0;
    }

    void push(int x) {
        if(curSize == n) {
            System.out.println("Queue is full");
            return;
        }

        if(curSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % n; 
        }
        q[end] = x;
        curSize++;
    }

    int pop() {
        if(curSize == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int ele = q[start];
        if(curSize == 1) start = end = -1;
        else start = (start + 1) % n;
        
        curSize -= 1;
        return ele;
    }

    int peek() {
        if(curSize == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        return q[start];
    }

    int size() {
        return curSize;
    }

    boolean isEmpty() {
        return curSize == 0;
    }
}
