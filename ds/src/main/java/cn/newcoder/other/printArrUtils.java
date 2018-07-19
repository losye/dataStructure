package cn.newcoder.other;

import leetcode.linkedlist.ListNode;

public class printArrUtils {
	public static void showArr(int[] arr){
		if(arr == null || arr.length<0){
			return;
		}
		for(int item : arr){
			System.out.print(item + " ");
		}
		System.out.println();
	}


	public static void showNode(ListNode listNode){
		if(listNode == null){
			return;
		}
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
		System.out.println();
	}
}
