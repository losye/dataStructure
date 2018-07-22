package neu.learning;

import java.util.Stack;

public class reverseStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        //	takeLast(s);
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.toArray()[i]);
        }
        //	System.out.println(takeLast(s));
        reverse(s);
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.toArray()[i]);
        }
        //	System.out.println(takeLast(s));

    }

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        Integer i = takeLast(s);
        reverse(s);
        s.push(i);
    }

    public static Integer takeLast(Stack<Integer> s) {
        Integer result = s.pop();
        if (s.isEmpty()) {
            return result;
        } else {
            Integer last = takeLast(s);
            //s.push(i);
            s.push(result);
            //return  s.push(i);
            return last;
        }
    }
}
