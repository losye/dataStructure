package offer;

import java.util.Stack;

/**
 * Created by losye
 * 设计一个栈的数据结构，新增函数min 表示得到栈中最小值
 */
public class MinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();


    public int pop(){
        min.pop();
        return data.pop();
    }

    public int min(){
        return min.peek();
    }

    public void push(int n){
       if (min.isEmpty()){
           min.push(n);
       }else {
           if (min() > n){
               min.push(n);
           }else {
               min.push(min());
           }
       }
       data.push(n);

    }
}
