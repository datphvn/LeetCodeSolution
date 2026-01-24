import java.util.*;

public class ImplementQueueUsingStacks232 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public ImplementQueueUsingStacks232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }

    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks232 queue = new ImplementQueueUsingStacks232();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());   // 1
        System.out.println(queue.pop());    // 1
        System.out.println(queue.empty());  // false
    }
}
