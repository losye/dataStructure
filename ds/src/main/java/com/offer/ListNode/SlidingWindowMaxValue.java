package com.offer.ListNode;

import cn.newcoder.other.printArrUtils;

import java.util.LinkedList;
/**
 * 求滑动窗口的最大值
 * @author zzy
 *	利用双端队列
 */
public class SlidingWindowMaxValue {
	 public static void main(String[] args) {
	        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
	        int w = 3;
	        printArrUtils.showArr(getWindowMaxValue(arr, w));
	    }

	    private static int[] getWindowMaxValue(int[] arr, int w) {

	        if (arr == null || w < 1 || arr.length < w) {
	            return null;
	        }

	        LinkedList<Integer> deque = new LinkedList<Integer>();
	        int[] res = new int[arr.length - w + 1];
	        int cnt = 0;
	        for (int i = 0; i < arr.length; i++) {
	            while (!deque.isEmpty() && arr[deque.peekFirst()] <= arr[i]) {
	                deque.pollLast();
	            }
	            deque.addLast(i);
	            if (deque.peekFirst() <= i - w) {
	                deque.pollFirst();
	            }
	            if (i >= w - 1) {
	                res[cnt++] = arr[deque.peekFirst()];
	            }
	        }

	        return res;
	    }

}
