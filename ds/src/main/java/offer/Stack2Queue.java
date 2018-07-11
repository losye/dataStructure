package offer;

import java.util.Stack;

/**
 * Created by losye
 */
public class Stack2Queue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();


    public void push(int value){
        stackPush.push(value);
    }

    public int pop(){
        if (!stackPop.isEmpty()){
            return stackPop.pop();
        }
        while (!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.push(1);
        stack2Queue.push(2);
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
        stack2Queue.push(3);
        System.out.println(stack2Queue.pop());
        stack2Queue.push(4);
        System.out.println(stack2Queue.pop());
    }

}
