package neu.learning;
import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> sup = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node < min){
        	sup.push(node);
        	min = node;
        }else{
        	sup.push(min);
        }
    }
    
    public void pop() {
        stack.pop();
        sup.pop();
    }
    
    public int top() {
        sup.pop();
        return stack.pop();
    }
    
    public int min() {
        return sup.peek();
    }
}
