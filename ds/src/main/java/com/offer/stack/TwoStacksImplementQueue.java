package com.offer.stack;

import java.util.Stack;

import org.junit.Test;
/**
 * 两个栈实现一个队列
 * @author zzy
 *
 */
public class TwoStacksImplementQueue {
	
	public class TwoStackQueue{
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;
		
		public TwoStackQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		
		public void push(int pushInt){
			stackPush.push(pushInt);
		}
		
		/**
		 * 1.Pop栈空才放到Pop栈中
		 * 2.Push栈一次性放过去，不准许放几个 
		 */
		public int pop(){
			if(stackPush.isEmpty() && stackPop.isEmpty()){
				throw new RuntimeException("stackPush is empty");
			}else if(stackPop.isEmpty()){
				while(!stackPush.isEmpty()){
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}
		
		public int peek(){
			if(stackPush.isEmpty() && stackPop.isEmpty()){
				throw new RuntimeException("stackPush is empty");
			}else if(stackPop.isEmpty()){
				while(!stackPush.isEmpty()){
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}	
	}
	
	@Test
	public void test(){
		TwoStackQueue test = new TwoStackQueue();
		test.push(1);
		test.push(2);
		test.push(3);
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
	}
	
}
