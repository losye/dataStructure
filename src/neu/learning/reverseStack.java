package neu.learning;

import java.util.Stack;

public class reverseStack {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
	//	takeLast(s);
		for(int i=0;i<s.size();i++){
			System.out.println(s.toArray()[i]);
		}
	//	System.out.println(takeLast(s));
		reverse(s);
		for(int i=0;i<s.size();i++){
			System.out.println(s.toArray()[i]);
		}
	//	System.out.println(takeLast(s));
		
	}
	public static void reverse(Stack s){
		if(s.isEmpty()){
			return ;
		}else{
			Object i = takeLast(s);
			reverse(s);
			s.push(i);
			return;
		}
	}
	public static Object takeLast(Stack s){
		Object result = s.pop();
		if(s.isEmpty()){
			return result;
		}
		else {
			Object last =  takeLast(s);
			//s.push(i);
			s.push(result);
			//return  s.push(i);
			return last;		
		}
	}
}
