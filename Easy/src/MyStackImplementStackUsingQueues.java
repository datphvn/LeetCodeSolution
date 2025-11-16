import java.util.*;

public class MyStackImplementStackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Constructor
    public MyStackImplementStackUsingQueues() {}

    // Đưa phần tử vào đỉnh stack
    public void push(int x) {
        q2.add(x);

        // Chuyển toàn bộ phần tử từ q1 sang q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Đổi tên hai queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Xóa và trả về phần tử ở đỉnh stack
    public int pop() {
        return q1.poll();
    }

    // Trả về phần tử ở đỉnh stack
    public int top() {
        return q1.peek();
    }

    // Kiểm tra rỗng
    public boolean empty() {
        return q1.isEmpty();
    }

    // --------- MAIN TEST ----------
    public static void main(String[] args) {
        MyStackImplementStackUsingQueues st = new MyStackImplementStackUsingQueues();

        st.push(1);
        st.push(2);
        System.out.println(st.top()); // 2
        System.out.println(st.pop()); // 2
        System.out.println(st.empty()); // false
    }
}
