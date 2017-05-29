package offer;

import java.util.Stack;

/**
 * Created by losye
 *  判断栈的压入和弹出顺序是否相匹配
 *  如 12345  45321  true
 *     12345  43512  false
 */
public class IsPopOrder {

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        boolean result = false;
        if (pushA.length ==0 && popA.length ==0) {
            return true;
        }
        if (pushA.length == popA.length) {
            Stack<Integer>  stack  = new Stack<Integer>();
            int j =0;
            for (int i = 0; i < popA.length; i++) {
                if (pushA[i] == popA[j]) {
                    j++;
                    while(!stack.isEmpty()&& j < popA.length ){
                        int p = stack.pop();
                        if (p == popA[j]) {
                            j++;
                        }else{
                            stack.push(p);
                            break;
                        }
                    }
                }else {
                    stack.push(pushA[i]);
                }
            }
            while(j < popA.length  ){
                int k = stack.pop();
                if (popA[j] == k) {
                    j++;
                }else {
                    stack.push(k);
                    break;
                }
            }
            if (stack.isEmpty()) {
                return true;
            }
        }
        return result;
    }
}
